package Tema04Metodos;

import java.util.Scanner;

public class Ejercicio12MostrarRango {


    /**
     * Escribir una función a la que se le pasen dos enteros y muestre todos los
     * números comprendidos entre ellos.
     */

    //Creamos la función que se nos pide
    static void mostrarNumeros(int numero1, int numero2) {
        //ordenamos los números con ternarios.
        //asignamos el mayor
        int mayor = numero1 > numero2 ? numero1 : numero2;
        //asignamos el menor
        int menor = numero1 < numero2 ? numero1 : numero2;
        //creamos el bucle que nos imprimirá los numeros
        for (int i = menor; i <= mayor; i++) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero:");
        int numero1 = sc.nextInt();
        System.out.println("Introduce un número");
        int numero2 = sc.nextInt();
        mostrarNumeros(numero1, numero2);
    }
}
