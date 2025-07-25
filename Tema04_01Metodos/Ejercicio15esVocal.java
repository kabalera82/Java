package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio15esVocal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un carácter:");
        char caracter = sc.next().charAt(0);

        if (esVocal(caracter)) {
            System.out.println("El carácter es una vocal.");
        } else {
            System.out.println("El carácter no es una vocal.");
        }

        sc.close();
    }

    static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
