package Tema12AcesoDatos.ejercicio03.src.main.java;

import static java.nio.file.StandardOpenOption.*;

import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class LeyendoCsv {
    private static final Path RUTA = Paths.get("datos.csv");

    public static void archivos() {
        System.out.println("Inserte el texto a añadir.");
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // Convierte la cadena en un array de bytes
        byte data[] = s.getBytes();

        // Abre un flujo de salida hacia RUTA
        // Si no existe, lo crea (CREATE)
        // Añade el nuevo contenido al final del archivo (APPEND)
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(RUTA, CREATE, APPEND))) {

            // Escribe los bytes del texto en el archivo
            // desde la posición 0 hasta el final del array
            out.write(data, 0, data.length);

            // Captura cualquier error de entrada/salida
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public static void leyendo() {

        // Asigna la ruta del archivo a una variable local
        Path file = RUTA;

        // Abre un flujo de entrada (InputStream) para leer bytes del archivo
        // Luego lo envuelve en un InputStreamReader,
        // que convierte los bytes leídos en caracteres (texto)
        // Finalmente, BufferedReader añade un buffer de lectura
        // que mejora el rendimiento y permite leer línea a línea
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {

            // Crea una lista para almacenar todas las líneas del archivo
            List<String> lineas = new ArrayList<>();

            // Variable temporal para cada línea leída
            String texto = null;

            // Mientras haya líneas por leer en el archivo...
            while ((texto = reader.readLine()) != null) {
                lineas.add(texto);           // ...añade la línea a la lista
                System.out.println(texto);   // ...y la muestra por consola
            }

            int contador = 0;
            // Muestra por consola todo el contenido almacenado en la lista
            System.out.println("Contenido del ArrayList:");
            for(String l : lineas){
                contador++;
                System.out.println("linea :" + contador + " " +l);
            }
            // Captura y muestra cualquier error de lectura
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}





