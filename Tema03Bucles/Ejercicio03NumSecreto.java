package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio03NumSecreto {
    public static void main(String[] args) {
        /*
        Codificar el juego «el número secreto», que consiste en acertar un número entre 1 y 100 (generado aleatoriamente).
        * Para ello se introduce por teclado una serie de números, para los que se indica:
        * «mayor» o «menor», según sea mayor o menor con respecto al número secreto.
        * El proceso termina cuando el usuario acierta o cuando se rinde (introducien-do un −1).
         */
        Scanner sc = new Scanner(System.in);
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        System.out.println("Introduzca un número entre el 1 y el 100: ");
        int num = sc.nextInt();
        while (numeroSecreto != num && num != -1) {
            if (num < numeroSecreto) {
                System.out.println("El numero secreto es mayor");
            } else {
                System.out.println("El numero secreto es menor");
            }
            if (num == numeroSecreto) {
                System.out.println("Has acertado");
            } else {
                System.out.println("Otra vez será: ");
            }

        }
    }
}
