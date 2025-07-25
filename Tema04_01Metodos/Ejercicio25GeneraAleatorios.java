package Tema04_01Metodos;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio25GeneraAleatorios {

    /**
     * Crea un programa que nos genere una cantidad de números enteros aleatorios
     * que nosotros le pasaremos por teclado.
     * Crea un método donde pasamos como parámetros entre que números queremos que los genere,
     * podemos pedirlas por teclado antes de generar los números.
     * Este método devolverá un número entero aleatorio.
     * Muestra estos números por pantalla.
     */
    public static void main(String[] args) {

        int cantidad, limiteInferior, limiteSuperior, numeroAleatorio;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //PEDIR AL USUARIO LA CANTIDAD DE NÚMEROS ALEATORIOS A GENERAR.

        System.out.println("Introduce la cantidad de números aleatorios a generar: ");
        cantidad = scanner.nextInt();
        //PEDIR AL USUARIO DE NÚMEROS
        System.out.println("Introduce el límite inferior del rango: ");
        limiteInferior = scanner.nextInt();
        System.out.println("Introduce el limite superior del rango: ");
        limiteSuperior = scanner.nextInt();

        //VALIDAMOS SI LOS LIMITES SON CORRECTOS.
        if (limiteInferior <= limiteSuperior) {
            for (int i = 0; i < cantidad; i++) {
                numeroAleatorio = generarNumeroAleatorio(limiteInferior, limiteSuperior, random);
                System.out.println(numeroAleatorio);
            }
        }
        scanner.close();
    }

    public static int generarNumeroAleatorio(int min, int max, Random random) {
        return random.nextInt(max - min) + 1 + min;
    }

}
