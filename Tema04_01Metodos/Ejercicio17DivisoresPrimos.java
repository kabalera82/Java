package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio17DivisoresPrimos {

    /**
     * Escribir una función a la que se le pase un número entero y
     * devuelva el número de divisores primos que tiene.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número:");
        int numero = sc.nextInt();

        int numDivisoresPrimos = numDivisoresPrimos(numero);
        System.out.println("El número " + numero + " tiene " + numDivisoresPrimos + " divisores primos.");

        sc.close();
    }

    static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int numDivisoresPrimos(int num) {
        int cont = 0; // contador de divisores
        for (int i = 2; i <= num; i++) {
            if (esPrimo(i) && num % i == 0) { // si i es primo y divide a num
                cont++; // incrementamos el número de divisores
            }
        }
        return cont;
    }
}
