package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio31Bisiesto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el año a comprobar: ");
        int ano = sc.nextInt();
        System.out.println("El año" + ano + " es bisiesto: " + esBisiesto(ano));

    }

    private static boolean esBisiesto (int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }



}
