package Tema02Condicionales;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio19JuegoSumas {

    public static void main(String[] args) {
        /*
         * Realiza el «juego de la suma», consiste en que aparezcan dos números aleatorios (comprendidos entre 1 y 99)
         * que el usuario tiene que sumar. La aplicación debe indicar si el resultado de la operación es correcto o incorrecto.
         * Además de los dos números aleatorios, también aparezca la operación que debe realizar el jugador: suma, resta o multiplicación.
         */

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int num1 = rand.nextInt(99) + 1; // Número aleatorio entre 1 y 99
        int num2 = rand.nextInt(99) + 1; // Número aleatorio entre 1 y 99
        int operacion = rand.nextInt(3); // 0 para suma, 1 para resta, 2 para multiplicación

        int resultadoCorrecto = 0;
        String operacionStr = "";

        switch (operacion) {
            case 0:
                operacionStr = "suma";
                resultadoCorrecto = num1 + num2;
                break;
            case 1:
                operacionStr = "resta";
                resultadoCorrecto = num1 - num2;
                break;
            case 2:
                operacionStr = "multiplicación";
                resultadoCorrecto = num1 * num2;
                break;
        }

        System.out.println("Realiza la siguiente operación: " + num1 + " " + operacionStr + " " + num2);
        int respuestaUsuario = sc.nextInt();

        if (respuestaUsuario == resultadoCorrecto) {
            System.out.println("¡Correcto!");
        } else {
            System.out.println("Incorrecto. La respuesta correcta es " + resultadoCorrecto);
        }

        sc.close();
    }
}
