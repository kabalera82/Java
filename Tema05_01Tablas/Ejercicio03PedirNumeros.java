package Tema05_01Tablas;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Tema 5: [Conceptos Básicos]
 * <p>
 * Ejercicio 03: [Pedir Numeros y generar tabla]
 *
 * @author kabadev
 */
public class Ejercicio03PedirNumeros {

    /*
     * Escribir una aplicación que solicite al usuario cuántos números desea introducir.
     * A continuación, introducir por teclado esa cantidad de números enteros,
     * y por último, mostrar en el orden inverso al introducido.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de números que deseas introducir: ");
        int cantidad = sc.nextInt();

        int[] t = new int[cantidad];

        for (int i = 0; i < t.length; i++) {
            System.out.println("Introduce el número " + (i + 1) + ": ");
            t[i] = sc.nextInt();
        }

        System.out.println("Números introducidos: " + Arrays.toString(t));

        System.out.println("Números introducidos en orden inverso: ");
        for (int i = t.length - 1; i >= 0; i--) {
            System.out.print(t[i] + " ");
        }

        sc.close();
    }
}
