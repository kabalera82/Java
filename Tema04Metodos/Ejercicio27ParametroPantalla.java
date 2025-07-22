package Tema04Metodos;

import java.util.Scanner;

public class Ejercicio27ParametroPantalla {
    /**
     * Queremos hacer una función que acepta un número como parámetro.
     * La función debe imprimir por pantalla la tabla de multiplicar (0 a 10) de ese número.
     */
    private static int numero; // Debe ser estática

    public static void main(String[] args) {
        System.out.println("Introduzca un numero: ");
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();
        tablaMultiplicar(numero); // Llamar al método con el parámetro
        sc.close();
    }

    public static void tablaMultiplicar(int numero) { // Debe aceptar un parámetro y tener un tipo de retorno
        for (int i = 0; i <= 10; i++) { // Usar <= en lugar de =
            System.out.println(i * numero);
        }
    }
}
