package Tema05_01Tablas;

import java.util.Arrays;
import java.util.Random;

/**
 * Tema 5 01: [Conceptos Básicos]
 * Ejercicio 15: [Crea un array, rellena con método Fill y copialo a otro array con CopyOf]
 * Muestra el segundo Array
 */
public class Ejercicio15CopyOf {

    public static void main(String[] args) {
        // Creamos el primer array de 10 elementos
        int[] original = new int[10];
        // Rellenamos el array original con el número 5
        Arrays.fill(original, 5);

        // Copiamos el array con copyOf
        int[] copia = Arrays.copyOf(original, original.length);

        // Mostramos el array copiado
        System.out.println("Array copiado: " + Arrays.toString(copia));
    }
}
