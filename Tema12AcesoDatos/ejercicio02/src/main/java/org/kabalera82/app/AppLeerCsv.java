package org.kabalera82.app;

import org.kabalera82.csv.CsvUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase que lee un archivo CSV línea a línea y muestra su contenido por consola.
 * <p>
 * Utiliza la clase {@link org.kabalera82.csv.CsvUtils} para dividir cada línea
 * en campos respetando las comillas y comas internas.
 * </p>
 */


public class AppLeerCsv {

    //Definimos el Path para referenciar la ruta absoluta
    private static final Path RUTA = Path.of("F:/Marcos/Programacion/Java/Java/Tema12AcesoDatos/ejercicio02/src/main/java/org/kabalera82/data/clientes.csv");


    public static void main(String[] args) {
        // Asergurarse de que existe el directorio y el archivo
        if (!Files.exists(RUTA)) {
            System.out.println("El archivo no existe: " + RUTA.toAbsolutePath());
            return;
        }

        System.out.println("leyendo archivo CSV desde: " + RUTA.toAbsolutePath());

        //Apertura y lectura linea a linea
        try (BufferedReader br = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)) {
            String linea;
            int numLinea = 1;

            while ((linea = br.readLine()) != null) {
                // Llamamos al método de utilidad para dividir la línea en campos
                List<String> campos = CsvUtils.parseCSVLines(linea);

                // Mostrar el contenido como una "tabla" simple
                System.out.printf("Línea %02d → %s%n", numLinea, campos);
                numLinea++;
            }


        } catch (IOException e) {
            System.err.println(" Error al leer el archivo: " + e.getMessage());
        }

    }
}