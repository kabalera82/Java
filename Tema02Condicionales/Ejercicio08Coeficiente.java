package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio08Coeficiente {

    public static void main(String[] args) {
        /* Pedir coeficientes de  una ecuación de 2º grado y mostrar sus soluciones. Si no existen, habrá que indicarlo.
         * Hay que tener en cuenta que la fórmula para resolver la ecuación de segundo grado es:
         * x = (-b ± √(b^2-4ac)) / 2a
         */

        double a, b, c, x1, x2, discriminante;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el coeficiente a: ");
        a = sc.nextDouble();
        System.out.println("Introduce el coeficiente b: ");
        b = sc.nextDouble();
        System.out.println("Introduce el coeficiente c: ");
        c = sc.nextDouble();

        discriminante = (b * b - 4 * a * c);
        // *** discriminante = Math.pow(b, 2) - 4 * a * c; ***

        if (discriminante < 0) {
            System.out.println("No existen soluciones reales.");
        } else if (discriminante == 0) {
            x1 = -b / (2 * a);
            System.out.println("La solución es: " + x1);
        } else {
            x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: " + x1 + " y " + x2);
        }
        sc.close();

    }
}
