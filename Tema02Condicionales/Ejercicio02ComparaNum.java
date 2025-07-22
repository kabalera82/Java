package Tema02Condicionales;

import java.util.Scanner;

/**
 * Tema 2: [Estructuras de Control]
 * <p>
 * Ejercicio 02: [Comprobar Entradas de Numeros con diferentes controles]
 *
 * @author kabadev
 */
public class Ejercicio02ComparaNum {
    /* Pedir dos números por consola y decir si son iguales o no */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = sc.nextInt();

        if (num1 == num2) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintos");
        }
        System.out.println("Introduce un número: ");
        Integer num3 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        Integer num4 = sc.nextInt();

        if (num3.equals(num4)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son distintos");
        }

        //Pide dos numeros por consola y muestra el mayor.
        System.out.println("Introduce un numero: ");
        num1 = sc.nextInt();
        System.out.println("Introduce otro numero: ");
        num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El numero " + num1 + " es mayor que " + num2);
        } else if (num1 < num2) {
            System.out.println("El numero " + num2 + " es mayor que " + num1);
        } else {
            System.out.println("Los numeros son iguales.");
        }

        /* Crea un programa que pida un numero con decimales e indique si es un numero
        casi cero o no. Para el programa "casi cero" es un numero que esta entre -0.9 y 0.9 */
        double num;
        System.out.println("Introduce un numero con decimales: ");
        num = sc.nextDouble();

        if (num > -0.9 && num < 0.9) {
            System.out.println("El numero " + num + " es casi cero.");
        } else {
            System.out.println("El numero " + num + " no es casi cero.");
        }

        /* Pedir dos números y mostrarlos ordenadamente en forma decreciente */
        int Mayor, Menor;
        System.out.println("Introduce un número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        num2 = sc.nextInt();
        Mayor = num1 > num2 ? num1 : num2; // Operador ternario para asignar a la variable Mayor el valor del número mayor
        Menor = num1 < num2 ? num1 : num2; // Operador ternario para asignar a la variable Menor el valor del número menor
        System.out.println(Mayor + ", " + Menor);
        sc.close();

    }
}
