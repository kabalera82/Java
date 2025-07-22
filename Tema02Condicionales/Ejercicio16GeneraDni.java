package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio16GeneraDni {

    public static void main(String[] args) {
        /*
        Realizar un programa que solicite al usuario un número de DNI sin letra y muestre la letra que le corresponde.
        Para calcular la letra se debe tomar el número del DNI y calcular el resto de dividirlo por 23.
        El resultado nos indicará la posición de la letra en el siguiente array:
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de DNI sin letra: ");
        int dni = sc.nextInt();
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = dni % 23;
        System.out.println("La letra que corresponde al DNI " + dni + " es: " + letras[resto]);
        sc.close();

    }
}
