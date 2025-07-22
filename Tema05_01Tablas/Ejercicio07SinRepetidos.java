package Tema05_01Tablas;

import java.util.Arrays;

public class Ejercicio07SinRepetidos {
    /*
     * Implementar la función:
     * int[] sinRepetidos(int t[]), que construye y devuelve una tabla de la longitud apropiada,
     * con los elementos de t, donde se han eliminado los datos repetidos.
     */

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] arrayConRepetidos = {1, 2, 2, 3, 4, 4, 5};
        int[] arraySinRepetidos = sinRepetidos(arrayConRepetidos);
        System.out.println(Arrays.toString(arraySinRepetidos)); // Imprime: [1, 2, 3, 4, 5]
    }


    static int[] sinRepetidos(int[] t) {
        int[] temporal = new int[0]; // Creamos un array temporal con longitud 0

        for (int elemento : t) {
            if (buscar(temporal, elemento) == -1) { // Si no está: insertamos
                // Algoritmo de inserción
                temporal = Arrays.copyOf(temporal, temporal.length + 1);
                temporal[temporal.length - 1] = elemento; // Añadimos al final
            }
        }

        return temporal;
    }


    static int buscar(int[] array, int elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return i; // Devuelve el índice si se encuentra el elemento
            }
        }
        return -1; // Devuelve -1 si no se encuentra el elemento
    }
}
