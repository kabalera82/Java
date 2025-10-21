package Tema05_01Tablas.VueltaEfectivo;

import java.util.Scanner;

/**
 * Programa que descompone una cantidad de dinero en billetes y monedas
 * utilizando recursión directa en lugar de bucles.
 */

public class Main {
    /** Denominaciones de billetes y monedas de mayor a menor */
    private static final int[] TIPO_MONEDA = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    /** Método main para ejecutar el programa. */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        do {
            try {
                System.out.println("Introduzca una cantidad: " + "\n" +
                        "introduzca 0 para salir");
                int total = sc.nextInt();
                int posicion = 0;
                if(total == 0){
                    salir = true;
                }
                System.out.println("Cantidad introducida: "+ total);
                maquinaCambios(total, posicion);

            } catch (Exception e){
                System.out.println("Introduzca un numero."+ "\n" +
                        "==========================================");
                sc.nextLine(); // Limpiamos el buffer
            }
        }while (!salir);
        sc.close();
    }

    private static void maquinaCambios(int total, int indice) {
        if (total == 0 || indice >= TIPO_MONEDA.length) {
            return;
        }

        int valor = TIPO_MONEDA[indice];
        int numUnidades = total / valor;
        int resto = total % valor;

        if (numUnidades > 0) {
            System.out.println("El número de " + (valor >= 5 ? "billetes" : "monedas") +
                    " de " + valor + "€: " + numUnidades);
        }

        maquinaCambios(resto, indice + 1);
    }


}