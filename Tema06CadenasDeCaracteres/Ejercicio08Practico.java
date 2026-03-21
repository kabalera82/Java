package Tema06CadenasDeCaracteres;

import java.util.Scanner;

/**
 * Ejercicio 08 - Ejercicios practicos con String
 *
 * Problemas clasicos que combinan varios metodos de String:
 * palindromos, contar palabras, invertir, capitalizar.
 */
public class Ejercicio08Practico {

    // Comprueba si una cadena es palindromo (igual al reves, ignorando espacios y mayusculas)
    public static boolean esPalindromo(String texto) {
        String limpio = texto.toLowerCase().replaceAll("[^a-z0-9]", "");
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }

    // Cuenta el numero de palabras en una frase
    public static int contarPalabras(String frase) {
        if (frase == null || frase.isBlank()) return 0;
        return frase.trim().split("\\s+").length;
    }

    // Capitaliza la primera letra de cada palabra
    public static String capitalizarPalabras(String frase) {
        if (frase == null || frase.isEmpty()) return frase;
        String[] palabras = frase.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String p : palabras) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0)))
                  .append(p.substring(1))
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Cuenta cuantas veces aparece un caracter en una cadena
    public static int contarOcurrencias(String texto, char c) {
        int count = 0;
        for (char ch : texto.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }

    // Comprueba si una cadena contiene solo digitos
    public static boolean soloDigitos(String texto) {
        return texto != null && texto.matches("\\d+");
    }

    public static void main(String[] args) {

        // Palindromos
        String[] candidatos = {"Ana", "racecar", "Hola", "A man a plan a canal Panama", "Java"};
        System.out.println("=== Palindromos ===");
        for (String s : candidatos) {
            System.out.printf("%-35s -> %s%n", s, esPalindromo(s) ? "SI" : "NO");
        }

        // Contar palabras
        System.out.println("\n=== Contar palabras ===");
        String[] frases = {"Hola mundo", "  Java es  genial  ", "", "Una"};
        for (String f : frases) {
            System.out.printf("\"%s\" -> %d palabras%n", f, contarPalabras(f));
        }

        // Capitalizar
        System.out.println("\n=== Capitalizar palabras ===");
        System.out.println(capitalizarPalabras("hola mundo desde java"));
        System.out.println(capitalizarPalabras("el rapido zorro marron"));

        // Contar ocurrencias
        System.out.println("\n=== Contar ocurrencias ===");
        String texto = "programacion en java";
        System.out.printf("'a' aparece %d veces en \"%s\"%n", contarOcurrencias(texto, 'a'), texto);

        // Solo digitos
        System.out.println("\n=== Solo digitos ===");
        System.out.println("\"12345\"  -> " + soloDigitos("12345"));
        System.out.println("\"123a5\"  -> " + soloDigitos("123a5"));
        System.out.println("\"\"       -> " + soloDigitos(""));
    }
}
