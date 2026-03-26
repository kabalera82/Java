package Tema11_01FicherosDeTexto.Ejercicio02Bonana.persistence;

import Tema11_01FicherosDeTexto.Ejercicio02Bonana.model.Frutas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO encargado de gestionar la lectura y escritura de frutas en archivo de texto.
 * Formato del archivo: id;nombre;precioKg;stockKg
 */
public class FrutaFileDao {

    /** Ruta del archivo de persistencia */
    private final Path archivoFrutas =
            Path.of("Tema11_01FicherosDeTexto/Ejercicio02Bonana/data/misFrutitas.txt");

    /**
     * Carga las frutas desde el archivo de texto.
     * Si no existe, lo crea vacío.
     */
    public List<Frutas> listadoFrutas() {
        List<Frutas> frutas = new ArrayList<>();

        try {
            // Aseguramos que la carpeta existe
            Files.createDirectories(archivoFrutas.getParent());
            File archivo = archivoFrutas.toFile();

            // Crear el archivo vacío si no existe
            if (!archivo.exists()) {
                try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))) {
                    System.out.println("📄 Archivo creado: " + archivo.getAbsolutePath());
                }
                return frutas;
            }

            // Leer línea a línea
            try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = entrada.readLine()) != null) {
                    if (!linea.isBlank()) {
                        String[] partes = linea.split("[;,]"); // acepta ; o ,
                        if (partes.length == 4) {
                            try {
                                int id = Integer.parseInt(partes[0]);
                                String nombre = partes[1];
                                double precioKg = Double.parseDouble(partes[2]);
                                int stockKg = Integer.parseInt(partes[3]);
                                frutas.add(new Frutas(id, nombre, precioKg, stockKg));
                            } catch (NumberFormatException e) {
                                System.out.println("⚠️ Error en línea: " + linea);
                            }
                        }
                    }
                }
            }

            System.out.println("✅ Archivo leído correctamente. Frutas cargadas: " + frutas.size());

        } catch (IOException e) {
            System.out.println("❌ Error al gestionar el archivo: " + e.getMessage());
        }

        return frutas;
    }

    /**
     * Guarda la lista de frutas en el archivo, sobrescribiendo su contenido anterior.
     */
    public void guardarFrutas(List<Frutas> frutas) {
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivoFrutas.toFile()))) {
            for (Frutas f : frutas) {
                salida.printf("%d;%s;%.2f;%d%n",
                        f.getId(), f.getNombre(), f.getPrecioKg(), f.getStockKg());
            }
            System.out.println("💾 Archivo guardado correctamente (" + frutas.size() + " frutas).");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }
}
