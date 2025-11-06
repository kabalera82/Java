package src.main.java;

import src.main.java.csv.CsvSalida;
import src.main.java.csv.CsvTabla;
import src.main.java.csv.CsvUtiles;
import src.main.java.model.Producto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;                // Representa rutas de forma segura/portátil.
import java.nio.file.Paths;               // Fábrica de Path (Paths.get(...)).
import java.util.List;


/**
 * Programa de ejemplo que:
 * Comprobamos la existencia del directorio 'data/'.☑️
 * Intenta leer un archivo CSV 'clientesResumen.csv' en UTF-8.☑️
 * Sacar por consola
 * Interpreta la primera línea como cabeceras.
 * Parse a cada línea en campos y las añade a una CsvTable.
 * Muestra el contenido como tabla mediante CsvPrinter.

 */
public class App {

    private static final Path RUTA = Paths.get("data", "productos.csv");

    public static void main(String[] args) {

        // Comprobamos la existencia del directorio 'data/'.
        try {
            Files.createDirectories(RUTA.getParent());
            System.out.println("👌 Ruta cargada");


        } catch (IOException e) {
            System.err.println("❌ No se pudo asegurar el directorio: " + e.getMessage());
        }

        CsvTabla tabla = new CsvTabla();

        Producto producto = new Producto();

        try (BufferedReader bufer = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)) {

            String linea = bufer.readLine();

            if(linea == null) {
                System.err.println("❌ No se pudo asegurar el directorio: ");
                return;
            }

            // Parsear cabeceras.
            // CsvUtils.parseCSVLine debe convertir "a,b,c" -> ["a","b","c"]
            // manejando comillas si fuera necesario: "a","b, con,comas","c"
            List<String> cabeceras = CsvUtiles.parseCSVLineas(linea);

            tabla.setCabeceras(cabeceras);

            while((linea = bufer.readLine()) != null) {
                List <String> campos = CsvUtiles.parseCSVLineas(linea);

                tabla.addFilas(campos);
            }



        } catch (NoSuchFileException e) {
            // toAbsolutePath() ayuda a diagnosticar mostrando la ruta completa.
            System.err.println("No aparece el archivo: " + RUTA.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         Mostrar el contenido leido en formato tabular.
         CsvPrinter.print(table) se encarga del formato (alineación, separadores, etc.).
         Si la tabla no tiene filas, idealmente CsvPrinter debería mostrar solo cabeceras
         o informar "sin datos".
         */



    }
}