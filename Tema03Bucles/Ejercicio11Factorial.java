package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio11Factorial {
    public static void main(String[] args) {
        /*
        Diseña un programa que pida un número y calcule su factorial.
        nota: el factorial de un número es el resultado de multiplicar ese número
         por todos los números enteros positivos menores que él.
         */
        Scanner sc = new Scanner(System.in);
        double factorial;
        int num;
        System.out.println("Introduce un numero");
        num = sc.nextInt();
        factorial = 1;
        for (int i = num; i > 0; i--) {
            factorial = factorial * i;
        }
        System.out.println("El factorial " + num + "es:" + factorial);

    }
}
