package Tema10FicherosDeTexto;

import java.io.*; // Importamos todas las clases de entrada/salida

public class LeerArchivo {
    public static void main(String[] args) {

        // 📝 var → String (porque es un texto)
        var nombreArchivo = "miArchivo.txt"; // String

        // 📁 var → File (porque usamos new File(...))
        var archivo = new File(nombreArchivo); // File

        try {
            // ✅ Comprobamos si el archivo existe
            if (archivo.exists()) {
                // 📖 var → BufferedReader (porque usamos new BufferedReader(...))
                var entrada = new BufferedReader(new FileReader(archivo)); // BufferedReader

                // 📄 var → String (porque readLine() devuelve una línea de texto)
                var linea = entrada.readLine(); // String

                // 📚 Leemos línea por línea mientras no sea null
                while (linea != null) {
                    System.out.println(linea);
                    linea = entrada.readLine(); // actualizamos a la siguiente línea
                }

                entrada.close(); // 💾 Cerramos el archivo
                System.out.println("✅ ¡Archivo leído correctamente!");
            } else {
                System.out.println("❌ El archivo no existe.");
            }

        } catch (IOException e) {
            // ❗ Mostramos el error en consola
            System.out.println("⚠️ Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
