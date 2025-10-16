package Tema11Colecciones.Ejercicio01Arrays.Ejercicio01Inicializar;

import java.util.Arrays;

/**
 * Inicializar Array
 *
 * Clase del paquete java.util
 * Tamaño Fijo: Estructura de datos estática.
 * Homogeneidad: Permite almacenar elementos del mismo tipo.
 * Indexación: Cada elemento se identifica por su posición.
 *
 * Array tien la propiedad .length para conocer su longitud
 */


public class Inicializar {
    public static void main(String[] args) {


        /**
         * - - - Bucle for Clasico - - -
         * <p>
         *     Se utiliza cuando conocemos el número de iteraciones.
         * </p>
         */
        int[] pares = new int[10];
        for (int i = 0; i < pares.length; i++) {
            System.out.println("for"+ pares[i]);
        }

        /**
         * - - - Bucle for for-each - - -
         * <p>
         *     No necesitas el índice solo los valores.
         * </p>
         */
        for (int p : pares){
            System.out.println("for-each:" + p);
        }

        /**
         * - - - While - - -
         * <p>
         *     Utilizando una condicion evaluadora.
         *     Se debe inicializar la condición.
         * </p>
         */
        int i = 0;

        while (i<pares.length){
            System.out.println(i++);
        }

        /**
         * Bucle con Streams
         *
         * No se rompe con break
         * Dificil acceso al índice
         */
        Arrays.stream(pares).forEach(numero ->
                        System.out.println("Streams: ")
                );





    }
}
