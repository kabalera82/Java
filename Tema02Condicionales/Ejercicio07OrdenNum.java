package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio07OrdenNum {

    public static void main(String[] args) {

        /*
         * Realizar de nuevo la Actividad resuelta 2.3 considerando el caso de que los números introducidos sean iguales
         */

        int num1, num2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2);
        } else if (num1 < num2) {
            System.out.println(num2 + " es mayor que " + num1);
        } else {
            System.out.println("Los números son iguales");
        }
        sc.close();

    }
}
