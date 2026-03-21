package src.main.java;

import src.main.java.csv.CsvTabla;
import src.main.java.csv.CsvUtiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final Path RUTA = Paths.get("data", "productos.csv");


    public static void main(String[] args) {

        try {
            Files.createDirectories(RUTA.getParent());
            System.out.println("👌 Ruta cargada");


        } catch (IOException e) {
            System.err.println("❌ No se pudo asegurar el directorio: " + e.getMessage());
        }


        try (BufferedReader bufer = Files.newBufferedReader(RUTA, StandardCharsets.UTF_8)) {

            String linea = bufer.readLine();

            if(linea == null) {
                System.err.println("❌ No se pudo asegurar el directorio: ");
                return;
            }
            System.out.println("leyendo archivo CSV desde: " + RUTA.toAbsolutePath());

            //Apertura y lectura linea a linea

                int numLinea = 1;

                while ((linea = bufer.readLine()) != null) {
                    // Llamamos al método de utilidad para dividir la línea en campos


                    List<String> campos = CsvUtiles.parseCSVLineas(linea);

                    // Mostrar el contenido como una "tabla" simple
                    System.out.printf("Línea %02d → %s%n", numLinea, campos);
                    numLinea++;
                }



            } catch (IOException e) {
                System.err.println(" Error al leer el archivo: " + e.getMessage());
            }

        }
    }


