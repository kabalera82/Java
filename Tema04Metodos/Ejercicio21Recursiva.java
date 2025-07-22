package Tema04Metodos;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio21Recursiva {

    /**
     * Diseñar una función que calcule a, donde a es real y n es entero no negativo.
     * Realizar una version iterativa y otra recursiva.
     * Las funciones recursivas suelen tener la misma estructura:
     * - Caso base: que permite terminar la recursividad.
     * - Llamada recursiva.
     * En este caso: el caso base es aElevadoN(x, 0) = 1
     * y la llamada recursiva: aElevadoN(a, n) = aElevadoN(a, n-1)*a
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner
        sc.useLocale(Locale.US); // Para poder leer números con punto en los decimales
        System.out.println("Introduce un número base (real): "); // Pedir al usuario que introduzca un número
        double base = sc.nextDouble(); // Leer el número introducido
        System.out.println("Introduce un número exponente (entero no negativo): "); // Pedir al usuario que introduzca un número
        int exponente = sc.nextInt(); // Leer el número introducido
        System.out.println("El resultado es : " + aElevadoN(base, exponente)); // Mostrar el resultado

        sc.close(); // Cerrar el Scanner
    }

    static double aElevadoN(double a, int n) {
        if (n == 0) {
            return 1; // a elevado a 0 es 1
        } else {
            return a * aElevadoN(a, n - 1); // llamada recursiva
        }
    }
}
