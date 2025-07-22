package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio02FuncAlumn {
    /*
     * Implementar una aplicación para calcular datos estadísticos de las edades de los alumnos de un centro educativo.
     * Se introducirán datos hasta que uno de ellos sea negativo, y se mostrará:
     * la suma de todas las edades introducidas,
     * la media, el número de alumnos y cuántos son mayores de edad.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        int sumaEdades = 0;
        int numeroAlumnos = 0;
        int mayoresDeEdad = 0;

        // Solicitar al usuario que introduzca las edades
        System.out.println("Introduce la edad de los alumnos (introduce un número negativo para terminar):");

        while (true) {
            edad = sc.nextInt();
            if (edad < 0) {
                break;
            }
            sumaEdades += edad;
            numeroAlumnos++;
            if (edad >= 18) {
                mayoresDeEdad++;
            }
        }

        // Calcular la media de las edades
        double mediaEdades = (numeroAlumnos > 0) ? (double) sumaEdades / numeroAlumnos : 0;

        // Mostrar los resultados
        System.out.println("Suma de todas las edades: " + sumaEdades);
        System.out.println("Media de las edades: " + mediaEdades);
        System.out.println("Número de alumnos: " + numeroAlumnos);
        System.out.println("Número de alumnos mayores de edad: " + mayoresDeEdad);

        // Cerrar el escáner
        sc.close();
    }
}

