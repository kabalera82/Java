package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio23Teclado {


    /*
     * Solicita por teclado un número de tipo int al usuario y
     * escribe un programa que muestre true o false,
     * dependiendo de si el número es positivo.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un número entero:");
        int numero = sc.nextInt();
        boolean esPositivo = numero > 0;
        boolean esNegativo = numero < 0;

        System.out.println(esPositivo);
        System.out.println(esNegativo);
        sc.close();


    }

}
