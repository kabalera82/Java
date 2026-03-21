package Tema14Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 03 - Stream API basico
 *
 * Un Stream es un flujo de datos sobre el que se aplican operaciones
 * de forma declarativa (que queremos) en lugar de imperativa (como hacerlo).
 *
 * Operaciones intermedias — devuelven un Stream, son lazy (no ejecutan hasta el terminal):
 *   filter(), map(), sorted(), distinct(), limit(), skip()
 *
 * Operaciones terminales — consumen el Stream y devuelven resultado:
 *   collect(), forEach(), count(), findFirst(), anyMatch(), reduce()
 */
public class Ejercicio03StreamBasico {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 5, 3, 8, 2, 9, 4, 7, 6, 10);

        // filter — filtrar elementos que cumplen condicion
        System.out.println("=== filter: mayores de 5 ===");
        numeros.stream()
               .filter(n -> n > 5)
               .forEach(System.out::println);

        // map — transformar cada elemento
        System.out.println("\n=== map: multiplicar por 2 ===");
        numeros.stream()
               .map(n -> n * 2)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // sorted — ordenar
        System.out.println("\n=== sorted: orden ascendente ===");
        numeros.stream()
               .sorted()
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // distinct — eliminar duplicados
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("\n=== distinct: sin duplicados ===");
        conDuplicados.stream()
                     .distinct()
                     .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Encadenar operaciones: filter + map + sorted + collect
        System.out.println("\n=== Encadenado: pares > 4, multiplicados x3, ordenados ===");
        List<Integer> resultado = numeros.stream()
            .filter(n -> n % 2 == 0)
            .filter(n -> n > 4)
            .map(n -> n * 3)
            .sorted()
            .collect(Collectors.toList());
        System.out.println(resultado);

        // Operaciones con Strings
        List<String> nombres = Arrays.asList("Ana", "Luis", "Maria", "Pedro", "Carmen", "Lucia");

        System.out.println("\n=== Nombres que empiezan por 'L', en mayusculas ===");
        nombres.stream()
               .filter(n -> n.startsWith("L"))
               .map(String::toUpperCase)
               .sorted()
               .forEach(System.out::println);
    }
}
