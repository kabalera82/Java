package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio25Numeros {

    /**
     * Escribe una aplicación que pida al usuario dos números enteros y muestre:
     * true, si ambos números son distintos entre sí o alguno de ellos es cero;
     * y false en caso contrario.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = sc.nextInt();
        boolean resultado = num1 == 0 || num2 == 0 || num1 == num2;
        System.out.println("¿Alguno de los números es cero o ambos son iguales? " + resultado);
        sc.close();

    }
}
