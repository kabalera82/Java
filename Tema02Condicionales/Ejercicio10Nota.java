package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio10Nota {

    public static void main(String[] args) {
        /* Pedir una nota entera de 0 a 10 y mostrarla de la siguiente forma: insuficiente (de 0 a 4)
        , suficiente (5), bien (6), notable (7 y 8) y sobresaliente (9 y 10). */

        int nota;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una nota: ");
        nota = sc.nextInt();

        switch (nota) {
            case 0, 1, 2, 3, 4 -> System.out.println("Insuficiente");
            case 5 -> System.out.println("Suficiente");
            case 6 -> System.out.println("Bien");
            case 7, 8 -> System.out.println("Notable");
            case 9, 10 -> System.out.println("Sobresaliente");
            default -> System.out.println("Nota no válida");
        }
        sc.close();
    }
}
