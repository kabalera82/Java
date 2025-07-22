package Tema06CadenasDeCaracteres;

import java.util.Scanner;

/**
 * Introducir por teclado dos frases e indicar cual de ellas es la mas corta,
 * es decir, la que contiene menos caracteres.
 */
public class Ejercicio02LongitudStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte la primera frase: ");
        String str1 = sc.nextLine();
        System.out.println("Inserte la segunda frase: ");
        String str2 = sc.nextLine();

        if (str1.length() < str2.length()) {
            System.out.println("str1 es más corta");
        } else if (str1.length() > str2.length()) {
            System.out.println("str1 es más larga");
        } else {
            System.out.println("Ambas tienen la misma longitud");
        }

    }
}
