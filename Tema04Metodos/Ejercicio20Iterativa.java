package Tema04Metodos;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio20Iterativa {

    /**
     * Diseñar una función que calcule a, donde a es real y n es entero no negativo.
     * Realizar una version iterativa y otra recursiva.
     */
    static double aElevadoN(double a, int n) {
        double resultado = 1; // el resultado se inicializa a 1, ya que mnultiplicamos
        for (int i = 1; i <= n; i++) { // bucle que se repite n veces
            resultado = resultado * a;// multiplicamos a por si mismo n veces
        }
        return resultado;
    }
    //programa pincipal para probar la funcion

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // para poder leer números con punto en los decimales.
        System.out.println("Introduce un número base (real): ");
        double base = sc.nextDouble();
        System.out.println("Introduce un número exponente (entero no negativo): ");
        int exponente = sc.nextInt();
        double resultado = aElevadoN(base, exponente);
        System.out.println(base + " elevado a " + exponente + " es igual a " + resultado);
        sc.close();
    }
}
