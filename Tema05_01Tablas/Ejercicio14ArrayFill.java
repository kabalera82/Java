package Tema05_01Tablas;

import java.util.Arrays;

/**
 * Tema 5 01: [Conceptos Básicos]
 * Ejercicio 14: [Crea un array y rellena con método Fill]
 * Rellena la posición 4 a 7 (excluyendo 8) con el valor 7.
 */
public class Ejercicio14ArrayFill {

    public static void main(String[] args) {
        // Creamos un array de 10 posiciones
        int[] matriz = new int[10];

        // Rellenamos desde la posición 4 hasta la 7 (recuerda que el 8 no se incluye)
        Arrays.fill(matriz, 4, 8, 7);

        // Mostramos el array completo para ver el resultado
        System.out.println("🧩 Resultado del array: " + Arrays.toString(matriz));
    }
}
