package Tema11_01FicherosDeTexto.Ejercicio01Ejemplo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivo {
    public static void main(String[] args) {

        //Vamos a crear un Archivo
        // ✏️ Nombre del archivo que queremos crear
        var nombreArchivo = "data/miArchivo.txt"; //String nombreArchivo

        // 🗂️ Creamos un objeto File con ese nombre
        var archivo = new File(nombreArchivo); // File archivo

        // 👷 Usamos try-catch para manejar errores
        try {
            // 🔎 Verificamos si el archivo ya existe
            if (archivo.exists()) {
                System.out.println("⚠️ ¡El archivo ya existe!");
            } else {
                // 🛠️ Creamos el archivo (y un objeto para escribir en él)
                var salida = new PrintWriter(new FileWriter(archivo));//FileWriter salida

                // 📝 Aquí podríamos escribir en el archivo (ahora está vacío)
                salida.println("¡Hola, este es mi archivo creado desde Java!");
                salida.println(" Puedes escribir lo que quieras.");
                salida.println(" Marcos Mola Mazo.");

                // 💾 Guardamos y cerramos el archivo
                salida.close();

                System.out.println("✅ ¡Archivo creado exitosamente!");
            }
        } catch (IOException e) {
            // ❌ Si hay un error, lo mostramos en consola
            System.out.println("⚠️ Error al crear archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}