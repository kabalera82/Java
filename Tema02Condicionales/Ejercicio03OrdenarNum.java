package Tema02Condicionales;

import java.util.Scanner;

/**
 * Tema 2: [Estructuras de Control]
 * <p>
 * Ejercicio 03: [Ordenación de números]
 *
 * @author kabadev
 */

public class Ejercicio03OrdenarNum {


    public static void main(String[] args) {

        //Pedir tres números y mostrarlos ordenados de mayor a menor.
        int num1, num2, num3;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        num2 = sc.nextInt();
        System.out.println("Introduce el tercer número: ");
        num3 = sc.nextInt();

        if (num1 > num2 && num1 > num3) {
            if (num2 > num3) {
                System.out.println(num1 + " > " + num2 + " > " + num3);
            } else {
                System.out.println(num1 + " > " + num3 + " > " + num2);
            }
        } else if (num2 > num1 && num2 > num3) {
            if (num1 > num3) {
                System.out.println(num2 + " > " + num1 + " > " + num3);
            } else {
                System.out.println(num2 + " > " + num3 + " > " + num1);
            }
        } else if (num3 > num1 && num3 > num2) {
            if (num1 > num2) {
                System.out.println(num3 + " > " + num1 + " > " + num2);
            } else {
                System.out.println(num3 + " > " + num2 + " > " + num1);
            }
        } else {
            System.out.println("Los números son iguales");
        }
        sc.close();

    }
}
