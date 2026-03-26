package Tema11_01FicherosDeTexto.Ejercicio01Ejemplo;

import java.nio.file.Files;   // Para usar el método readAllLines
import java.nio.file.Paths;   // Para crear rutas del sistema
import java.util.List;        // Para almacenar las líneas como lista de String

public class LeerTodoArchivo {
    public static void main(String[] args) {

        // 📝 var → String (porque es un texto que indica el nombre del archivo)
        var nombreArchivo = "data/miArchivo.txt"; // String

        try {
            // 📥 Leemos todas las líneas del archivo y las guardamos en una lista de cadenas
            // Cada elemento de la lista representa una línea del archivo
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));

            // 📢 Mostramos mensaje de inicio
            System.out.println("Contenido del archivo: ");

            // 🔁 Primera forma de recorrer la lista: bucle for-each clásico
            for (String linea : lineas) {
                System.out.println(linea); // Imprime cada línea del archivo
            }

            // 🔁 Segunda forma (alternativa): con expresión lambda (funcional)
            // Esta línea hace lo mismo: imprime cada línea usando un método compacto
            lineas.forEach(System.out::println);

        } catch (Exception e) {
            // ❌ Si ocurre algún error (por ejemplo, si no existe el archivo), se captura aquí
            System.out.println("Error al leer archivo: " + e.getMessage());
            e.printStackTrace(); // Muestra detalles técnicos del error en consola
        }
    }
}
