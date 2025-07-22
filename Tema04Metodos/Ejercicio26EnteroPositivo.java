package Tema04Metodos;

import java.util.Scanner;

public class Ejercicio26EnteroPositivo {

    /**
     * Crea una aplicación que nos cuente el número de cifras de un número entero positivo
     * (hay que controlarlo) pedido por teclado.
     * Crea un método que realice esta acción, pasando el número por parámetro, devolverá el número de cifras.
     */

    public static void main(String[] args) {
        int numero, cifras;
        Scanner sc = new Scanner(System.in);
        //PEDIMOS AL USUARIO UN NÚMERO ENTERO POSITIVO
        System.out.println("Introduce un número entero positivo.");
        numero = sc.nextInt();
        //Verificamos que es positivo
        if (numero <= 0) {
            System.out.println("El número debe ser un entero positivo.");
        } else {

            cifras = contarCifras(numero);
            System.out.println("El número " + numero + " tiene " + cifras + " cifras.");
        }
        sc.close();
    }

    public static int contarCifras(int numero) {
        return String.valueOf(numero).length();
    }
}
