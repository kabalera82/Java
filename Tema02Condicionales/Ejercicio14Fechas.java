package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio14Fechas {

    public static void main(String[] args) {

        /*
         * Crear una aplicación que solicite al usuario una fecha (día, mes y año) y
         *  muestre la fecha correspondiente al día siguiente.
         * Similar al anterior, en el que incrementábamos la hora. En este caso
         * la dificultad es que no todos los meses tienen el mismo número de días.
         * Por eso,lo primero que haremos es ver cuántos días tiene el mes de la fecha.
         * No tendremos en cuenta los años bisiestos y suponemos correcta la fecha introducida.
         */
        Scanner sc = new Scanner(System.in);
        int diasDelMes = 0;
        System.out.println("Introduce el día: ");
        int dia = sc.nextInt();
        System.out.println("Introduce el mes: ");
        int mes = sc.nextInt();
        System.out.println("Introduce el año: ");
        int año = sc.nextInt();

        diasDelMes = switch (mes) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
        dia++;

        if (dia > diasDelMes) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                año++;
            }
        }
        if (año == 0) {
            año = 1;
        }
        System.out.println("La fecha siguiente es: " + dia + "/" + mes + "/" + año);

    }
}
