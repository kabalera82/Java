package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio04NumDec {

    public static void main(String[] args) {
        /* Crea un programa que pida un numero con decimales e indique si es un numero
        casi cero o no. Para el programa "casi cero" es un numero que esta entre -0.9 y 0.9 */
        double num;
        System.out.println("Introduce un numero con decimales: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextDouble();

        if (num > -0.9 && num < 0.9) {
            System.out.println("El numero " + num + " es casi cero.");
        } else {
            System.out.println("El numero " + num + " no es casi cero.");
        }
        sc.close();
    }
}
