package Tema03Bucles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio24ComprobacionTipo {
    /*
     * Escribir el método Integer leerEntero(),
     * que pide un entero por consola, lo lee del teclado y lo devuelve.
     * Si la cadena introducida por consola no tiene el formato correcto,
     * muestra un mensaje de error y vuelve a pedirlo.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entero;
        boolean comprobar = false;

        do {
            try {
                System.out.println("Inserte un número entero: ");
                entero = sc.nextInt();
                System.out.println("El número insertado es: " + entero);
                comprobar = true;
            } catch (InputMismatchException ex) {
                System.out.println("Tipo erróneo");
                sc.next(); // Limpiar la entrada incorrecta para evitar bucle infinito
            }
        } while (!comprobar);

    }
}
