package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio01ComprobacionNum {
    public static void main(String[] args) {

        // Diseñar un programa que muestre, para cada número introducido por teclado, si
        // es par, si es positivo y su cuadrado. El proceso se repetirá hasta que el
        // número introducido sea 0.
        Scanner sc = new Scanner(System.in);
        int num;

        // Solicitar al usuario que introduzca un número
        System.out.println("Introduce un número: ");
        num = sc.nextInt();

        // Repetir el proceso hasta que el número introducido sea 0
        while (num != 0) {
            // Verificar si el número es par o impar
            boolean esPar = num % 2 == 0;
            // Verificar si el número es positivo o negativo
            boolean esPositivo = num >= 0;

            // Mostrar los resultados
            System.out.println("Es par?: " + esPar);
            System.out.println("Es positivo?: " + esPositivo);
            System.out.println("Cuadrado: " + (num * num));

            // Solicitar al usuario que introduzca otro número
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
        }

        // Cerrar el escáner
        sc.close();
    }
}
