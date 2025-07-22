package Tema04Metodos;

import java.util.Scanner;

public class Ejercicio14RetornaMaximo {

    /**
     * Diseñar una función que recibe como parámetros dos números enteros y devuelve el máximo de ambos.
     * Repite el ejercicio haciendo que calcule el máximo de 3 números
     */

    // Compara los parámetros, a y b, y devuelve el mayor de ambos
    static int maximo(int a, int b) {
        int max = a > b ? a : b;
        return max;
    }

    static int tercerMaximo(int a, int b, int c) {
        int numMax = a;
        if (b > numMax) {
            numMax = b;
        }
        if (c > numMax) {
            numMax = c;
        }
        return numMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el primer número: ");
        int a = sc.nextInt(); // Leer el primer número
        System.out.println("Introduzca el segundo número: ");
        int b = sc.nextInt(); // Leer el segundo número
        System.out.println("Introduzca el tercer número: ");
        int c = sc.nextInt(); // Leer el tercer número
        System.out.println("El número mayor de los dos primeros es: " + maximo(a, b));
        System.out.println("El número mayor de los tres es: " + tercerMaximo(a, b, c));
        sc.close(); // Cerrar el Scanner
    }
}
