package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio06AprenderContar {

    public static void main(String[] args) {
        /*
        Escribir una aplicación para aprender a contar, que pedirá un número n y mostrará todos los números
        del 1 al n.
        Como sabemos el nº de iteraciones usamos el bucle for
         */

        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que introduzca un número
        System.out.println("Introduce un número: ");
        int n = sc.nextInt();

        // Mostrar todos los números del 1 al n usando un bucle for
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

        // Cerrar el escáner
        sc.close();
    }
}
