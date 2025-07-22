package Tema05_01Tablas;

import java.util.Random;

/**
 * Tema 5 01: [Conceptos Básicos]
 * <p>
 * Ejercicio 13: [Crea y Ordena]
 *
 * @author kabadev
 */
public class Ejercicio13CreaOrdena {
    /**
     * Crea un array de numeros 100 posciones (tamaño 100), que contendra los numeros del 1 al 100.
     * Obtener la suma de todos los numeros del array y obtener la media.
     * Ordena el array
     */
    public static void main(String[] args) {
        //Declaramos el array de 100 posiciones
        int[] nuevoArray = new int[100];
        int acumulador = 0;

        //Generamos el bucle para los 100 numeros aleatorios
        for (int i = 0; i < nuevoArray.length; i++) {
            nuevoArray[i] = (int) (Math.random() * 1000);
            System.out.println(nuevoArray[i]);
            acumulador += nuevoArray[i];
            System.out.println("El acumulador esta en: " + acumulador);
        }

        // Metodo de Ordenacion por Seleccion
        ordenacionSeleccion(nuevoArray);
        for (int i = 0; i < nuevoArray.length; i++) {
            System.out.println(nuevoArray[i]);
        }
    }

    public static void ordenacionSeleccion(int[] matriz) {
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
