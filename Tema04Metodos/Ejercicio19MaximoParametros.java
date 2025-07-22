package Tema04Metodos;

public class Ejercicio19MaximoParametros {

    /**
     * Repite la actividad 4 resutelta con una version que calcule el máximo de 3 números.
     * Diseñar una función que recibe como parámetros dos números enteros y devuelve el máximo de ambos.
     * Vamos a sobrecargar la función àra que tenga 3 parámetros: máximo (a, b, c).
     * Para implementar la funcion podemos escribir el algoritmo desde cero o reutilizar el código de la función anterior.
     */

    static int maximo(int a, int b, int c) {
        int numMax = a;
        if (b > numMax) {
            numMax = b;
        }
        if (c > numMax) {
            numMax = c;
        }
        return numMax;
    }

    static int maximo(int a, int b) {
        int max = a > b ? a : b;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("El numero mayor de los tres es: " + maximo(9, 2, 8));
        System.out.println("El numero mayor de los tres es: " + maximo(2, 8));

    }
}
