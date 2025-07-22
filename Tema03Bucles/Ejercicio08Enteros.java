package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio08Enteros {

    public static void main(String[] args) {
        /*
        Pide 10 números enteros por teclado y muestra la media.
         */
        Scanner sc = new Scanner(System.in);
        int num;
        double suma = 0; // Inicializa suma a 0
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un numero: ");
            num = sc.nextInt(); // Cambié 'n' a 'num'
            suma += num; // Suma correctamente los números ingresados
        }
        double media = suma / 10; // Calcula la media correctamente
        System.out.println("La media de los números es: " + media);
    }
}
