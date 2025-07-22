package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio09TablaMult {


    public static void main(String[] args) {
        /*
        Pedir un número entre 1 y 10. Mostrar su tabla de multiplicar.
         */
        Scanner sc = new Scanner(System.in); // Corregir la inicialización del Scanner
        int num;

        do {
            System.out.println("Introduzca un número del 1 al 10:");
            num = sc.nextInt();
        } while (!(1 <= num && num <= 10));

        System.out.println("\n\nTabla del " + num);
        for (int i = 1; i <= 10; i++) { // Corregir la sintaxis del bucle for
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}
