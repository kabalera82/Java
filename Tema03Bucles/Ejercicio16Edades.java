package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio16Edades {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxima = Integer.MIN_VALUE;
        int minima = Integer.MAX_VALUE;
        int edad;
        boolean hayDatos = false;

        System.out.println("Introduce las edades de los alumnos. Escribe -1 para terminar.");

        do {
            System.out.print("Edad: ");

            // Validar que la entrada sea un número entero
            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                sc.next(); // Limpiar la entrada no válida
                System.out.print("Edad: ");
            }

            edad = sc.nextInt();

            if (edad != -1) {
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Inténtalo de nuevo.");
                } else {
                    hayDatos = true;

                    // Actualizar la edad mínima
                    if (edad < minima) {
                        minima = edad;
                    }

                    // Actualizar la edad máxima
                    if (edad > maxima) {
                        maxima = edad;
                    }
                }
            }

        } while (edad != -1); // Continuar el bucle hasta que se introduzca -1

        if (hayDatos) {
            System.out.println("\nResultados:");
            System.out.println("Edad mínima: " + minima);
            System.out.println("Edad máxima: " + maxima);
        } else {
            System.out.println("No se han introducido edades válidas.");
        }

        System.out.println("Adiós");
        sc.close();
    }
}
