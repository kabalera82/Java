package Tema04Metodos;

import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
