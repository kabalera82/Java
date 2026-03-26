package Tema11_01FicherosDeTexto.Ejercicio01Ejemplo;

import java.io.*;
import java.util.Scanner;

public class EditarArchivo {

    public static void main(String[] args) {

        // 📝 Nombre del archivo a editar
        var nombreArchivo = "data/miArchivo.txt";

        // 📁 Creamos el objeto File
        var archivo = new File(nombreArchivo);

        // 🔎 Verificamos si el archivo existe
        if (!archivo.exists()) {
            System.out.println("❌ El archivo no existe. Crea uno primero.");
            return;
        }

        // ✍️ Mostramos el contenido actual
        System.out.println("📖 Contenido actual del archivo:");
        try (var lector = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer archivo: " + e.getMessage());
        }

        // 🛠️ Preguntamos al usuario si quiere sobrescribir o agregar
        Scanner sc = new Scanner(System.in);
        System.out.println("\n¿Quieres sobrescribir (s) o agregar (a)?");
        String opcion = sc.nextLine();

        // 🖊️ Abrimos el archivo según la opción elegida
        boolean agregar = opcion.equalsIgnoreCase("a");

        try (var escritor = new PrintWriter(new FileWriter(archivo, agregar))) {
            System.out.println("✏️ Escribe lo que quieras guardar (usa 'FIN' para terminar):");
            String entrada;
            do {
                entrada = sc.nextLine();
                if (!entrada.equalsIgnoreCase("FIN")) {
                    escritor.println(entrada);
                }
            } while (!entrada.equalsIgnoreCase("FIN"));

            System.out.println("✅ ¡Archivo actualizado con éxito!");
        } catch (IOException e) {
            System.out.println("⚠️ Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
