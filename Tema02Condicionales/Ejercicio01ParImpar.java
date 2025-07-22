package Tema02Condicionales;

import java.util.Scanner;

/**
 * Tema 2: [Estructuras de Control]
 * <p>
 * Ejercicio 01: [Decir si es Par o Impar]
 *
 * @author kabadev
 */

public class Ejercicio01ParImpar {

    public static void main(String[] args) {
        /*Pedir un numero y decir si es par o impar*/

        int num;
        System.out.println("Introduce un numero: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();


        if (num % 2 == 0) {
            System.out.println("El numero " + num + " es par.");
        } else {
            System.out.println("El numero " + num + " es impar.");
        }
        sc.close();
    }
}
