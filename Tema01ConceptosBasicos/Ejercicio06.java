package Tema01ConceptosBasicos;

import java.util.Scanner;


/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 06: [Calcula beneficios]
 *
 * @author kabadev
 */

public class Ejercicio06 {

    /*
     Frutero necesita calcular beneficios anuales que obtiene de la
     venta de manzanas y peras. Necesita aplicación que solicite ventas en
     (kilos) de cada semestre para fruta, mostrará el importe sabiendo
     que el precio del kilo está fijado en 2,35 para manzanas y 1,95 para peras.
    */
    public static void main(String[] args) {


        final double PRECIO_MANZANAS = 2.35;
        final double PRECIO_PERAS = 1.95;

        int manzanaSemestre1, manzanaSemestre2;
        int peraSemestre1, peraSemestre2;

        double impTotalManzanas, impTotalPeras;
        Scanner sc = new Scanner(System.in);

        System.out.println("Para la manzana");
        System.out.println("Ventas en kg primer semestre manzanas:");
        manzanaSemestre1 = sc.nextInt();
        System.out.println("Ventas en kg segundo semestre manzanas:");
        manzanaSemestre2 = sc.nextInt();

        System.out.println("Para las peras");
        System.out.println("Ventas en kg primer semestre peras:");
        peraSemestre1 = sc.nextInt();
        System.out.println("Ventas en kg segundo semestre peras:");
        peraSemestre2 = sc.nextInt();

        impTotalManzanas = (manzanaSemestre1 + manzanaSemestre2) * PRECIO_MANZANAS;
        impTotalPeras = (peraSemestre1 + peraSemestre2) * PRECIO_PERAS;

        System.out.println("Importe total de manzanas: " + impTotalManzanas);
        System.out.println("Importe total de peras: " + impTotalPeras);

        sc.close();
    }
}
