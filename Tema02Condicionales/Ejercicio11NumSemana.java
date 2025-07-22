package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio11NumSemana {
    public static void main(String[] args) {

        /*
     Idear un programa que solicite al usuario un número comprendido entre 1 y 7,
     correspon-diente a un día de la semana. Se debe mostrar el nombre del día de la semana al que corresponde.
     Por ejemplo, el número 1 corresponde a «lunes» y el 6 a «sábado».
         */
        int dia;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número del 1 al 7: ");
        dia = sc.nextInt();

        switch (dia) {
            case 1 -> System.out.println("Lunes");
            case 2 -> System.out.println("Martes");
            case 3 -> System.out.println("Miércoles");
            case 4 -> System.out.println("Jueves");
            case 5 -> System.out.println("Viernes");
            case 6 -> System.out.println("Sábado");
            case 7 -> System.out.println("Domingo");
            default -> System.out.println("Número no válido");
        }
        sc.close();

    }
}
