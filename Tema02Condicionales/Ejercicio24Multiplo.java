package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio24Multiplo {


    /**
     * Realiza un programa que informe al usuario (mostrando true)
     * si un primer número es múltiplo de otro número.
     * Ambos números se piden por teclado.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = sc.nextInt();

        boolean multiplo = num1 % num2 == 0;
        System.out.println("¿El primer número es múltiplo del segundo? " + multiplo);

        sc.close();


    }
}
