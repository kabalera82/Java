package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio14Tablas {
    public static void main(String[] args) {


        for (int tabla = 1; tabla <= 10; tabla++) {
            System.out.println("\n\nTabla del " + tabla);
            for (int i = 1; i <= 10; i++) {
                System.out.println(tabla + " x " + i + " = " + (tabla * i));
            }
        }

    }
}
