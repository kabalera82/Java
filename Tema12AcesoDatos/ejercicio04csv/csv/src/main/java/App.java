package Tema12AcesoDatos.ejercicio04csv.csv.src.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets; // Para especificar UTF-8 al leer el archivo.
import java.nio.file.Files;               // API moderna de NIO para operaciones con ficheros.
import java.nio.file.NoSuchFileException; // Excepción específica si el archivo no existe.
import java.nio.file.Path;                // Representa rutas de forma segura/portátil.
import java.nio.file.Paths;               // Fábrica de Path (Paths.get(...)).
import java.util.List;                    // Para listas inmutables/mutables de cadenas.

/**
 * Programa de ejemplo que:
 * Asegura la existencia del directorio 'data/'.
 * Intenta leer un archivo CSV 'clientesResumen.csv' en UTF-8.
 * Interpreta la primera línea como cabeceras.
 * Parsea cada línea en campos y las añade a una CsvTable.
 * Muestra el contenido como tabla mediante CsvPrinter.
 *
 * Consideraciones:
 * El código usa try-with-resources para cerrar automáticamente el BufferedReader.
 * Se captura NoSuchFileException para dar un mensaje claro si el CSV no existe.
 * Se informa si el CSV está vacío (sin cabeceras).
 * Se asume que CsvUtils.parseCSVLine maneja correctamente comillas/separadores.
 */

public class App {

    // Usar Path evita problemas de separadores de ruta entre SO (Windows/Linux/Mac)

    private static final Path RUTA = Paths.get(
            "src/main/data/clientesResumen.csv"
    );



    public static void main(String[] args) {

        try {
            Files.createDirectories(RUTA.getParent());
        } catch (IOException e) {
            System.err.println("❌ No se pudo asegurar el directorio: " + e.getMessage());
        }

        // Estructura en memoria para almacenar el contenido del csv
        CsvTable table = new CsvTable();

        try (BufferedReader br = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)) {

            String linea;

            linea = br.readLine();

            // Si la primera línea es null, el archivo está vacío (0 bytes o sin contenido legible)
            if (linea == null) {
                System.err.println("Csv vacío: no hay cabeceras ni datos.");
                return;
            }

            // CsvUtils.parseCSVLine debe convertir "a,b,c" -> ["a","b","c"]
            // manejando comillas si fuera necesario: "a","b,con,comas","c"
            List<String> headers = CsvUtils.parseCSVLine(linea);

            // Cargar las cabeceras en la tabla para que CsvPrinter pueda etiquetar columnas.
            table.setHeaders(headers);

            // Leer el resto de líneas hasta EOF.
            // Cada línea representa una fila de datos con el mismo número de columnas (idealmente).
            while ((linea = br.readLine()) != null) {

                // Parsear cada línea en campos individuales según el formato CSV.
                List<String> campos = CsvUtils.parseCSVLine(linea);

                // Añadir la fila a la tabla.
                // Suele ser buena práctica validar longitud: campos.size() == headers.size().
                table.addRow(campos);
            }

        } catch (NoSuchFileException e) {
            // Caso específico: el archivo no existe en la ruta esperada.
            System.err.println("No aparece el archivo: " + RUTA.toAbsolutePath());
        } catch (IOException e) {
            // Otras IOExceptions: permisos, bloqueo de archivo, encoding corrupto, etc.
            e.printStackTrace();
        }

        /* CsvPrinter.print(table) se encarga del formato (alineación, separadores, etc.).
           Si la tabla no tiene filas, idealmente CsvPrinter debería mostrar solo cabeceras
           o informar "sin datos".
        */
        CsvPrinter.print(table);
    }
}
