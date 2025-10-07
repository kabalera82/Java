package Tema10_01FicherosDeTexto.Ejercicio02Bonana.persistence;

import Tema10_01FicherosDeTexto.Ejercicio02Bonana.model.Frutas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO encargada de gestionar el archivo de frutas.
 * <p>
 * Si el archivo no existe, lo crea vacío.
 * Si existe, lo lee y carga los datos en memoria.
 * </p>
 */
public class FrutaFileDao {

    /** Ruta del archivo donde se almacenan las frutas */
    private final Path archivoFrutas =
            Path.of("Tema10_01FicherosDeTexto/Ejercicio02Bonana/data/misFrutitas.txt");

    /**
     * Crea el archivo si no existe.
     * Si existe, lo lee y carga las frutas en memoria.
     * @return lista de frutas cargadas o vacía si no hay datos
     */
    public List<Frutas> listadoFrutas() {
        List<Frutas> frutas = new ArrayList<>();

        try {
            // Crear la carpeta si no existe
            Files.createDirectories(archivoFrutas.getParent());

            File archivo = archivoFrutas.toFile();

            // Si no existe, creamos el archivo vacío
            if (!archivo.exists()) {
                try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))) {
                    System.out.println("✅ Archivo creado: " + archivo.getAbsolutePath());
                }
                return frutas; // lista vacía (primera ejecución)
            }

            // Si existe, leemos línea a línea
            try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = entrada.readLine()) != null) {
                    if (!linea.isBlank()) {
                        String[] partes = linea.split(";");
                        if (partes.length == 4) {
                            try {
                                String nombre = partes[1];
                                double precioKg = Double.parseDouble(partes[2]);
                                int stockKg = Integer.parseInt(partes[3]);
                                frutas.add(new Frutas(nombre, precioKg, stockKg));

                            } catch (NumberFormatException e) {
                                System.out.println("⚠️ Error en línea: " + linea);
                            }
                        }
                    }
                }
                System.out.println("✅ Archivo leído correctamente. Frutas cargadas: " + frutas.size());
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error al gestionar el archivo: " + e.getMessage());
        }

        return frutas;
    }
}
