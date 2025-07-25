package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio23Fibonacci {

    /**
     * Diseñar una función recursiva que calcule el enésimo término de la serie de Fibonacci.
     * En esta serie el enésimo valor se calcula sumando los dos valores anteriores de la serie.
     * Es decir:
     * Este será el caso general: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
     * Tendremos dos casos Base:
     * - Fibonacci(0) = 1
     * - Fibonacci(1) = 1
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a calcular fibonacci(n)");
        System.out.println("Introduzca n ( se recomienda n<40): ");
        int num = sc.nextInt();
        int resultado = fibo(num); // si n es muy grande esto puede tardar bastante
        System.out.println("\nfibonacci(" + num + ") = " + resultado);
    }


    //Funcion recursiva
    static int fibo(int num) {
        int res;
        if (num == 0 || num == 1) { //Primer caso base
            res = 1;
        } else {
            res = fibo(num - 1) + fibo(num - 2); // caso general recursivo;; //Segundo caso base

        }

        return (res);
    }
}
