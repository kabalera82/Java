package Tema04Metodos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio28Vector {

    /**
     * Dado un número n introducido por consola.
     * Sumar ese número a un vector pedido al usuario.
     * Mostrar el Vector antes y después de sumarle n.
     */
    private static int n;
    private static int[] vector;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el valor para n");
        n = sc.nextInt();
        System.out.println("el valor de n es: " + n);
        vector = creoVector(sc);
        muestroVector(vector); // Mostrar el vector original
        int[] vectorNuevo = sumaAlVector(); // Guardar el resultado de sumaAlVector en vectorNuevo
        muestroVector(vectorNuevo); // Mostrar el vector nuevo
        sc.close();
    }

    public static int[] creoVector(Scanner sc) {
        System.out.println("Introduce el tamaño del vector");
        int size = sc.nextInt();
        vector = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Introduce un elemento: ");
            vector[i] = sc.nextInt();
        }

        System.out.println("Vector creado: " + Arrays.toString(vector));

        return vector;
    }

    public static void muestroVector(int[] vector) {
        System.out.println("""
                El vector: 
                """ + Arrays.toString(vector));
    }

    public static int[] sumaAlVector() {
        int[] vectorNuevo = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vectorNuevo[i] = vector[i] + n; // Asignar la suma al nuevo vector
        }
        return vectorNuevo;
    }
}
