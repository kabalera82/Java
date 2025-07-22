package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio15Triangulo {

    public static void main(String[] args) {
        /*
        Pedir un número "n" y dibujar un triángulo de n elementos utilizando (*). Ejemplo n=4
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe n: ");
        int n = sc.nextInt();

        for (int fila = 1; fila <= n; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
}
