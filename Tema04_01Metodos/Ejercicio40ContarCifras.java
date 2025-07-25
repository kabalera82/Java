package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio40ContarCifras {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int numero = sc.nextInt();
        sc.close();

        long[] r2 = contarCifras(numero);
        // Llama al método contarCifras con el número introducido y guarda el resultado (un array con pares e impares) en 'r2'.

        System.out.printf("(Con Streams) Pares: %d, Impares: %d%n", r2[0], r2[1]);
        // Imprime el número de cifras pares (r2[0]) y cifras impares (r2[1]) en formato legible.
    }

    /**
     * Devuelve un array long[2]:
     * [0] = cantidad de cifras pares
     * [1] = cantidad de cifras impares
     */
    public static long[] contarCifras(int numero) {
        // Declara un método estático llamado contarCifras que recibe un int y devuelve un array de long con dos elementos.

        String cad = String.valueOf(Math.abs(numero));
        // Convierte el número a positivo con Math.abs y luego a String (para poder trabajar cada dígito como carácter).

        long pares = cad.chars()              // 'chars()' crea un Stream (flujo) de códigos Unicode para cada carácter del String.
                .map(c -> c - '0')    // Convierte cada carácter ('0', '1', '2', etc.) en su valor numérico (0, 1, 2, etc.).
                .filter(d -> d % 2 == 0) // Filtra (deja pasar) solo los dígitos pares (d % 2 == 0).
                .count();             // Cuenta cuántos dígitos pasaron el filtro, devolviendo un long.

        long impares = cad.length() - pares;
        // Calcula los dígitos impares restando el total de cifras (length) menos los pares.

        return new long[]{pares, impares};
        // Devuelve un array con dos elementos: el primero es el número de pares y el segundo es el de impares.
    }
}
