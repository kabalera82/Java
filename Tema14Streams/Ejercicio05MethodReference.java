package Tema14Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Ejercicio 05 - Referencias a metodos (method references)
 *
 * Una referencia a metodo es una lambda mas concisa cuando el cuerpo
 * solo llama a un metodo existente.
 *
 * Tipos:
 *   Clase::metodoEstatico       — Integer::parseInt
 *   objeto::metodoInstancia     — miObjeto::metodo
 *   Clase::metodoInstancia      — String::toUpperCase
 *   Clase::new                  — Persona::new (referencia a constructor)
 */
public class Ejercicio05MethodReference {

    static void imprimir(String s) {
        System.out.println("-> " + s);
    }

    static boolean esLargo(String s) {
        return s.length() > 4;
    }

    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Marcos", "Luis", "Valentina", "Eva");

        // Lambda vs method reference
        System.out.println("=== Lambda vs Method Reference ===");
        nombres.stream().forEach(s -> System.out.println(s));         // lambda
        nombres.stream().forEach(System.out::println);                // metodo de instancia de objeto

        // Metodo estatico de clase
        System.out.println("\n=== Metodo estatico ===");
        nombres.stream().forEach(Ejercicio05MethodReference::imprimir);

        // Metodo de instancia de clase (se aplica a cada elemento)
        System.out.println("\n=== toUpperCase (instancia de clase) ===");
        nombres.stream()
               .map(String::toUpperCase)
               .forEach(System.out::println);

        // Metodo estatico como Predicate
        System.out.println("\n=== Nombres largos (metodo estatico como predicate) ===");
        nombres.stream()
               .filter(Ejercicio05MethodReference::esLargo)
               .forEach(System.out::println);

        // Conversion con referencia a metodo
        System.out.println("\n=== Convertir String a Integer ===");
        List<String> numerosStr = Arrays.asList("1", "2", "3", "4", "5");
        numerosStr.stream()
                  .map(Integer::parseInt)       // String::parseInt seria error — es Integer
                  .map(n -> n * n)
                  .forEach(System.out::println);

        // Referencia a constructor
        System.out.println("\n=== Referencia a constructor ===");
        List<String> palabras = Arrays.asList("hola", "mundo", "java");

        // Lambda: s -> new StringBuilder(s)
        // Method reference: StringBuilder::new
        palabras.stream()
                .map(StringBuilder::new)
                .map(sb -> sb.reverse().toString())
                .forEach(System.out::println);
    }
}
