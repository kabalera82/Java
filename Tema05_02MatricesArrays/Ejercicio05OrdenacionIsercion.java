// Algoritmo de ordenación por inserción
package Tema05_02MatricesArrays;

/**
 * Tema 5, 2 [Tablas]
 * <p>
 * Ejercicio 05: [Metodo de ordenación por inserción]
 *
 * @author kabadev
 */

public class Ejercicio05OrdenacionIsercion {

    public static void main(String[] args) {

        int[] matriz = {5, 2, 3, 1, 4, 6};

        System.out.println("\nMatriz original:");
        for (int num : matriz) {
            System.out.print(num + " ");
        }
        System.out.println("");

        ordenacionInsercion(matriz);
        ordenacionInsercion2(matriz);

        System.out.println("\nMatriz ordenada:");
        for (int num : matriz) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static void ordenacionInsercion(int[] matriz) {

        // bucle para las pasadas
        // empezamos en j = 1 ya que el primer elemento se considera ordenado por defecto.
        for (int i = 1; i < matriz.length; i++) {

            int auxiliar = matriz[i];

            int j = i - 1; // Para obtener el valor de la posicion anterior


            while ((j > -1) && (matriz[j] > auxiliar)) {
                // Desplazamos el elemento hacia la derecha
                matriz[j + 1] = matriz[j];
                j--; // Restamos -1 a j para volver a comparar con el elemento anterior
            }
            matriz[j + 1] = auxiliar; // Insertamos el elemento auxiliar en su posición correcta
            // asignamos el valor de auxiliar a la posición j+1
            j--;

            System.out.println("Iteración " + i + ":");
            for (int num : matriz) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void ordenacionInsercion2(int[] matriz) {

        for (int i = 1; i < matriz.length; i++) {
            int aux = matriz[i]; // Guardamos el valor de la posición i en una variable auxiliar
            int j = i - 1;
            while ((j > -1) && (matriz[j] > aux)) {
                // Desplazamos el elemento hacia la derecha
                matriz[j + 1] = matriz[j];
                j--; // Restamos -1 a j para volver a comparar con el elemento anterior
            }

            matriz[j + 1] = aux; // Insertamos el elemento auxiliar en su posición correcta

            j--;

            for (int elemento : matriz) {
                System.out.print(elemento + " ");
            }
        }
    }

}