package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio12Calificaciones {

    public static void main(String[] args) {
        /*
        Pedir 5 calificaciones y decir si hay algún suspenso
         */
        Scanner sc = new Scanner(System.in);
        boolean suspensos = false;
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduzca nota (de 0 a 10): ");
            int notas = sc.nextInt();
            if (notas < 5) {
                suspensos = true;
            }
        }
        if (suspensos) {
            System.out.println("hay alumnos suspensos");
        } else {
            System.out.println("no hay alumnos suspensos");
        }
    }
}
