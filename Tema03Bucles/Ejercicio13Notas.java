package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio13Notas {
    public static void main(String[] args) {
        /*
        Dadas 6 Notas, escribe la cantidad de alumnos aprobados, condicionados (nota = 4) y suspensos.
         */
        Scanner sc = new Scanner(System.in);
        int aprobados = 0;
        int suspensos = 0;
        int condicionados = 0;
        for (int i = 1; i <= 6; i++) {
            System.out.println("Nota del alumno número " + i + ": ");
            int nota = sc.nextInt();
            if (nota == 4) {
                condicionados++;
            } else if (nota >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }
        }
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Suspensos: " + suspensos);
        System.out.println("Condicionados: " + condicionados);
    }
}
