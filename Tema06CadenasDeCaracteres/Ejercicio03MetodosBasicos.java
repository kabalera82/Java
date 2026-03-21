package Tema06CadenasDeCaracteres;

/**
 * Ejercicio 03 - Metodos basicos de String
 *
 * Los String en Java son INMUTABLES — cada operacion crea un nuevo objeto.
 * Los metodos no modifican el String original, devuelven uno nuevo.
 */
public class Ejercicio03MetodosBasicos {

    public static void main(String[] args) {

        String texto = "  Hola, Mundo!  ";

        // Longitud e inspeccion
        System.out.println("length():      " + texto.length());          // 17
        System.out.println("charAt(2):     " + texto.charAt(2));         // H
        System.out.println("isEmpty():     " + texto.isEmpty());         // false
        System.out.println("isBlank():     " + texto.isBlank());         // false (Java 11+)

        // Busqueda
        System.out.println("\nindexOf('o'):  " + texto.indexOf('o'));     // 4
        System.out.println("lastIndexOf:   " + texto.lastIndexOf('o'));  // 10
        System.out.println("contains:      " + texto.contains("Mundo")); // true
        System.out.println("startsWith:    " + texto.startsWith("  H")); // true
        System.out.println("endsWith:      " + texto.endsWith("!  "));   // true

        // Modificaciones (devuelven nuevo String)
        System.out.println("\ntoUpperCase:   " + texto.toUpperCase());
        System.out.println("toLowerCase:   " + texto.toLowerCase());
        System.out.println("trim():        |" + texto.trim() + "|");       // elimina espacios
        System.out.println("strip():       |" + texto.strip() + "|");      // como trim pero Unicode (Java 11+)
        System.out.println("replace:       " + texto.replace("Mundo", "Java"));

        // Extraccion
        String limpio = texto.trim();
        System.out.println("\nsubstring(0,4): " + limpio.substring(0, 4));  // Hola
        System.out.println("substring(6):   " + limpio.substring(6));       // Mundo!

        // Conversion
        System.out.println("\nvalueOf(42):   " + String.valueOf(42));
        System.out.println("valueOf(3.14): " + String.valueOf(3.14));
        System.out.println("parseInt:      " + Integer.parseInt("123") + 1); // 124
    }
}
