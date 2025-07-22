package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio19Decimales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número decimal:");
        String binario = "";
        int numero;

        numero = sc.nextInt();
        if (numero > 0) {
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = " 0 " + binario;
                } else {
                    binario = " 1 " + binario;
                }
                numero = numero / 2;
            }
            System.out.println(binario);
        } else if (numero < 0) {
            numero = numero * -1;
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = " 0 " + binario;
                } else {
                    binario = " 1 " + binario;
                }
                numero = numero / 2;
            }
            System.out.println(" 1 " + binario);
        } else {
            System.out.println(" 0 ");
        }

    }
}
