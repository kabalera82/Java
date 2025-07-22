package Tema01ConceptosBasicos;

import java.util.Scanner;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 08: [Ejercicios Multiplos]
 *
 * @author kabadev
 */

public class Ejercicio08Multiplos {
    public static void main(String[] args) {
        /*
         * Escribe un programa que tome como entrada un número entero
         * indique qué cantidad hay que sumarle para que el resultado sea múltiplo de 7.
         * Ejemplo:  A 2 hay que sumarle 5 para que el resultado (2 + 5 = 7) sea múltiplo de 7.
         * A 13 hay que sumarle 1 para que el resultado (13 + 1 = 14) sea múltiplo de 7.
         * Si proporcionas el número 2 o el 13, la salida de la aplicación debe ser 5 o 1, respectivamente.
         * Pista: El operador módulo puede ser muy útil para solucionar esta actividad.
         */

        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que introduzca un número entero
        System.out.println("Introduce un número entero: ");
        int numero = sc.nextInt();

        /*
         *Calcular la cantidad que hay que sumarle para que sea múltiplo de 7
         * recordar que el resto es lo que sobra de la división.
         * por ejemplo 13%7= 6 (porque sobra 6)
         */
        int resto = numero % 7;
        int cantidadASumar = (resto == 0) ? 0 : 7 - resto;

        // Mostrar el resultado
        System.out.println("A " + numero + " hay que sumarle " + cantidadASumar + " para que el resultado sea múltiplo de 7.");
        sc.close();
    }
}
