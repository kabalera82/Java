package Tema06CadenasDeCaracteres;

/**
 * Ejercicio 05 - Comparacion de Strings
 *
 * == compara referencias (si son el mismo objeto en memoria).
 * equals() compara el contenido — SIEMPRE usar esto para comparar texto.
 *
 * Este es uno de los errores mas frecuentes en Java.
 */
public class Ejercicio05Comparacion {

    public static void main(String[] args) {

        // El pool de strings — literales identicos comparten referencia
        String a = "Hola";
        String b = "Hola";
        String c = new String("Hola"); // fuerza nuevo objeto en heap

        System.out.println("=== == (compara referencias) ===");
        System.out.println("a == b: " + (a == b));   // true — mismo literal del pool
        System.out.println("a == c: " + (a == c));   // false — c es objeto nuevo

        System.out.println("\n=== equals() (compara contenido) ===");
        System.out.println("a.equals(b): " + a.equals(b));   // true
        System.out.println("a.equals(c): " + a.equals(c));   // true — mismo contenido

        // equalsIgnoreCase — sin distinguir mayusculas
        String x = "java";
        String y = "JAVA";
        System.out.println("\nx.equals(y):           " + x.equals(y));           // false
        System.out.println("x.equalsIgnoreCase(y): " + x.equalsIgnoreCase(y));  // true

        // compareTo — orden lexicografico (para ordenar)
        // devuelve 0 si igual, <0 si this va antes, >0 si this va despues
        String s1 = "banana";
        String s2 = "manzana";
        System.out.println("\n\"banana\".compareTo(\"manzana\"): " + s1.compareTo(s2)); // negativo
        System.out.println("\"manzana\".compareTo(\"banana\"): " + s2.compareTo(s1)); // positivo
        System.out.println("\"banana\".compareTo(\"banana\"): " + s1.compareTo(s1)); // 0

        // Null safety — evitar NullPointerException
        String nulo = null;
        System.out.println("\n=== Comparacion segura con null ===");
        // nulo.equals("algo") → NullPointerException
        System.out.println("\"algo\".equals(nulo): " + "algo".equals(nulo)); // false, seguro
        System.out.println("Objects.equals:       " + java.util.Objects.equals(nulo, "algo")); // false, seguro
    }
}
