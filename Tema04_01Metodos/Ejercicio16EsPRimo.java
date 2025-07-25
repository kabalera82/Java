package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio16EsPRimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número cualquiera:");
        int num = sc.nextInt();

        if (esPrimo(num)) {
            System.out.println(num + " es un número primo.");
        } else {
            System.out.println(num + " Es un número compuesto.");
        }

        sc.close();
    }

    static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        boolean primo = true; // suponemos que el número es primo
        int i = 2;

        while (i < num && primo) {
            if (num % i == 0) {
                primo = false;
            }
            i++;
        }
        return primo;
    }
}
