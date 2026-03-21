package Tema11Colecciones.Ejercicio10HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ejemplo de uso de HashMap para contar palabras en una frase.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1️⃣ Leer una frase
        System.out.println("Introduce una frase:");
        String frase = scanner.nextLine();

        // 2️⃣ Convertir a minúsculas y dividir en palabras (usando espacios)
        String[] palabras = frase.toLowerCase().split("\\s+");

        // 3️⃣ Crear un HashMap para almacenar palabra -> contador
        HashMap<String, Integer> contador = new HashMap<>();

        // 4️⃣ Recorrer las palabras e ir contando
        for (String palabra : palabras) {
            // Si la palabra ya existe, incrementamos
            if (contador.containsKey(palabra)) {
                contador.put(palabra, contador.get(palabra) + 1);
            } else {
                // Si no existe, empezamos en 1
                contador.put(palabra, 1);
            }
        }

        // 5️⃣ Mostrar el resultado
        System.out.println("\nFrecuencia de palabras:");
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        scanner.close();
    }
}

