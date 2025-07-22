package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio26Recaudacion {


    /**
     * Escribir un programa que calcule el dinero recaudado en un concierto. La
     * aplicación solicitará el aforo máximo del local, el precio por entrada
     * (suponemos que todas las entradas tienen el mismo precio) y el número de
     * entradas vendidas. Hay que tener en cuenta que si el número de entradas
     * vendidas no supera el 20 % del aforo del local, se cancela el concierto.
     * Si el número de entradas vendidas no supera el 50 % del aforo del local,
     * se realiza una rebaja del 25 % del precio de la entrada.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que introduzca el aforo máximo del local
        System.out.println("Introduzca el aforo máximo del local: ");
        int aforo = sc.nextInt();

        // Solicitar al usuario que introduzca el precio de las entradas
        System.out.println("Introduzca el precio de las entradas: ");
        double precio = sc.nextDouble();

        // Solicitar al usuario que introduzca la cantidad de entradas vendidas
        System.out.println("Introduzca la cantidad de entradas vendidas: ");
        int entradasVendidas = sc.nextInt();

        // Evaluar las condiciones y calcular la recaudación
        if (entradasVendidas < (aforo * 20) / 100) {
            System.out.println("Concierto Cancelado");
        } else if (entradasVendidas < (aforo * 50) / 100) {
            double recaudacion = entradasVendidas * precio * 0.75;
            System.out.println("La recaudación es: " + recaudacion);
        } else {
            double recaudacion = entradasVendidas * precio;
            System.out.println("La recaudación es: " + recaudacion);
        }

        // Cerrar el escáner
        sc.close();
    }
}
