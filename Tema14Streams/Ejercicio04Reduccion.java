package Tema14Streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * Ejercicio 04 - Operaciones de reduccion
 *
 * Las operaciones terminales reducen el Stream a un unico valor:
 *   count()    — numero de elementos
 *   sum()      — suma (solo en IntStream/LongStream/DoubleStream)
 *   min/max()  — minimo/maximo
 *   average()  — media
 *   anyMatch() — alguno cumple la condicion
 *   allMatch() — todos cumplen la condicion
 *   noneMatch()— ninguno cumple la condicion
 *   reduce()   — reduccion generica
 */
public class Ejercicio04Reduccion {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);

        // count
        long total = numeros.stream().filter(n -> n > 4).count();
        System.out.println("Mayores de 4: " + total);

        // sum, min, max, average — con mapToInt para obtener IntStream
        int suma = numeros.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);

        OptionalInt min = numeros.stream().mapToInt(Integer::intValue).min();
        OptionalInt max = numeros.stream().mapToInt(Integer::intValue).max();
        System.out.println("Min: " + min.getAsInt() + " | Max: " + max.getAsInt());

        double media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.printf("Media: %.2f%n", media);

        // anyMatch, allMatch, noneMatch
        boolean hayMayorDe8 = numeros.stream().anyMatch(n -> n > 8);
        boolean todosMayorDe0 = numeros.stream().allMatch(n -> n > 0);
        boolean ningunNegativo = numeros.stream().noneMatch(n -> n < 0);

        System.out.println("\nHay algun > 8:     " + hayMayorDe8);
        System.out.println("Todos > 0:         " + todosMayorDe0);
        System.out.println("Ningun negativo:   " + ningunNegativo);

        // reduce — acumulador generico
        // reduce(identidad, acumulador)
        int producto = numeros.stream().reduce(1, (a, b) -> a * b);
        System.out.println("\nProducto (reduce): " + producto);

        int sumaReduce = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Suma (reduce):     " + sumaReduce);

        // Caso practico — lista de precios
        List<Double> precios = Arrays.asList(29.99, 149.99, 9.99, 79.99, 49.99);

        System.out.println("\n=== Estadisticas de precios ===");
        System.out.printf("Total:    %.2f€%n", precios.stream().mapToDouble(Double::doubleValue).sum());
        System.out.printf("Minimo:   %.2f€%n", precios.stream().mapToDouble(Double::doubleValue).min().orElse(0));
        System.out.printf("Maximo:   %.2f€%n", precios.stream().mapToDouble(Double::doubleValue).max().orElse(0));
        System.out.printf("Media:    %.2f€%n", precios.stream().mapToDouble(Double::doubleValue).average().orElse(0));
        System.out.println("Hay algun precio > 100€: " + precios.stream().anyMatch(p -> p > 100));
    }
}
