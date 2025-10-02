package Tema01ConceptosBasicos;

import java.util.Scanner;

public class Ejercicio02SalidaConsola {
    /**
     * Tema 1: [Conceptos Básicos]
     * <p>
     * Ejercicio 02: [Entrada y Salida de datos por Consola]
     *
     * @author kabalera82
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Pide un numero y muestralo por consola.
        int num;
        System.out.println("Dame un numero");
        num = sc.nextInt();
        System.out.println("Tu número es: " + num);

        //Pide al usuario su edad y mostrar por consola la que tenga el año siguiente
        int edad;
        System.out.println("Dame tu edad");
        edad = sc.nextInt();
        System.out.println("Tu edad el año que viene si ya has cumplido será: " + edad + 1);

        // Pide el año actual y el de nacimiento del usuario.
        // Calcula su edad si el año en curso ya ha cumplido años

        int aActual;
        int aNacimiento;
        //Observa que la variable año ya está inicializada de antes.
        System.out.println("Año de nacimiento:");
        aNacimiento = sc.nextInt();
        System.out.println("Año actual:");
        aActual = sc.nextInt();
        edad = aActual - aNacimiento;
        System.out.println("Tu edad es: " + edad);

        // Solicitar al usuario que introduzca el primer número
        System.out.println("Introduce el primer número (a): ");
        double a = sc.nextDouble();

        // Solicitar al usuario que introduzca el segundo número
        System.out.println("Introduce el segundo número (b): ");
        double b = sc.nextDouble();

        // Comparar los dos números y mostrar el resultado2

        boolean sonIguales = (a == b);
        System.out.println(sonIguales);

        // Cerrar el Scanner
        sc.close();
    }


}

