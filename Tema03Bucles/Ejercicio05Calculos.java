package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio05Calculos {

    public static void main(String[] args) {
        /*
        Juego  de cálculo mental de la suma.
         Introducir el resultado de la suma de dos números aleatorios comprendidos entre 1 y 100
         */
        int resultado, operando1, operando2; // variables
        int numOperaciones = 0;
        Scanner sc = new Scanner(System.in);

        do {
            operando1 = (int) (Math.random() * 100 + 1);
            operando2 = (int) (Math.random() * 100 + 1);
            System.out.print(operando1 + " + " + operando2 + " = ");
            resultado = sc.nextInt();
            numOperaciones++;
        } while (resultado == operando1 + operando2);

        // numOperaciones contabiliza cuántas operaciones se han mostrado. De ellas
        // (numOperaciones -1) son correctas y la última es errónea (si no, no hubiera
        // terminado el do-while).
        System.out.println("Has conseguido realizar: " + (numOperaciones - 1) + " sumas consecutivas");

        // Cerrar el escáner
        sc.close();
    }
}
