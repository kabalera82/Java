package Tema99EjerciciosMultiples.Billetes;

import java.util.Scanner;



/**
 * Escribir un programa descompuesto convenientemente en base a funciones que,
 * para una suma de dinero dada, indique cómo descomponerla en billetes y monedas corrientes.
 * Se debe utilizar el mínimo posible de billetes y monedas.
 * No existen limitaciones respecto al número de billetes y monedas disponibles.
 */

public class Main {

    // Billetes y monedas de mas de un €
    private static final double[] BILLETES_MONEDAS_EURO = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    //Centimos
    private static final double[] MONEDAS_CENTIMOS = {0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el importe a descomponer (€): ");
        double importe = sc.nextDouble();
        System.out.println();

        descomponer(importe);

    }

    // Metodo Princiap de descomposición de la cantidad
    public static void descomponer(double importe) {
        int parteEuros = (int) importe;
        double parteCentimos = Math.round((importe - parteEuros) * 100.0) / 100.0;

        System.out.println("=== BILLETES Y MONEDAS DE EURO ===");
        descomponerEuros(parteEuros, 0);

        System.out.println("\n=== MONEDAS DE CÉNTIMOS ===");
        descomponerCentimos(parteCentimos, 0);
    }

    //Métodos recursivos
    // Metodo que descompone euros
    public static void descomponerEuros(double importe, int indice) {
        if (importe == 0 || indice >= BILLETES_MONEDAS_EURO.length) {
            return;
        }

        double valor = BILLETES_MONEDAS_EURO[indice];
        int cantidad = (int) (importe / valor);
        double resto = importe % valor;

        if (cantidad > 0) {
            System.out.println("Número de " + (valor >= 5 ? "billetes" : "monedas")
                    + " de " + (valor >= 1 ? (int) valor + "€" : (valor * 100) + "c") + ": " + cantidad);
        }

        descomponerEuros(resto, indice + 1);
    }

    //Metodo que decompone centimos
    public static void descomponerCentimos(double importe, int indice) {
        if (importe < 0.01 || indice >= MONEDAS_CENTIMOS.length) {
            return;
        }

        double valor = MONEDAS_CENTIMOS[indice];
        int cantidad = (int) (importe / valor);
        double resto = Math.round((importe - cantidad * valor) * 100.0) / 100.0;

        if (cantidad > 0) {
            System.out.println("Número de monedas de " + (int) (valor * 100) + "c: " + cantidad);
        }

        descomponerCentimos(resto, indice + 1);
    }

}
