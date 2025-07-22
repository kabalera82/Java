package Tema05_01Tablas;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio05RellenarPares {
    /**
     * Escribir la función int[] rellenaPares(int longitud, int fin),
     * que crea y devuelve una tabla ordenada de la longitud especificada,
     * que se encuentra rellena con números pares aleatorios
     * comprendidos en el rango desde 2 hasta fin (inclusive).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita la longitud del array al usuario
        System.out.print("Introduce la longitud del array: ");
        int longitud = scanner.nextInt();

        // Solicita el valor máximo (fin) al usuario
        System.out.print("Introduce el valor máximo (fin): ");
        int fin = scanner.nextInt();

        // Genera el array con los valores proporcionados por el usuario
        int[] resultado = rellenaPares(longitud, fin);

        // Imprime el array generado
        System.out.println(Arrays.toString(resultado));
    }

    static int[] rellenaPares(int longitud, int fin) {
        // Creamos la tabla con la longitud adecuada
        int[] pares = new int[longitud];

        int i = 0; // Indica con qué elemento de la tabla estamos trabajando

        while (i < pares.length) { // Terminaremos de rellenar la tabla cuando
            // el número de pares sea igual que la longitud de la tabla
            int num = (int) (Math.random() * fin + 1);
            if (num % 2 == 0) { // Si es par
                pares[i] = num; // Lo guardamos en el elemento i
                i++; // Incrementamos el indicador
            }
        }

        // Ahora falta ordenar la tabla
        Arrays.sort(pares);
        return pares;
    }
}
