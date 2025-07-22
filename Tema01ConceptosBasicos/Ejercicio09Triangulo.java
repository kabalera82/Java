package Tema01ConceptosBasicos;

import java.util.Scanner;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 09: [Triángulo]
 *
 * @author kabadev
 */
public class Ejercicio09Triangulo {
    /*
     * Crea un programa que pida la base y la altura de un triángulo y muestre su área
     * Area = (base*altura)/2
     */
    public static void main(String[] args) {
        //declaramos las variables
        double base;
        double altura;
        double area;
        //abrimos el scanner
        Scanner sc = new Scanner(System.in);
        //pedimos la base por consola y la altura y la detectamos
        System.out.println("Introduce el valor de la base: ");
        base = sc.nextDouble();
        System.out.println("Introduce el valor de la altura: ");
        altura = sc.nextDouble();
        //calculamos el área y sacamos el resultado por consola.
        //tambien se puede hacer directamente
        area = (base * altura) / 2;
        System.out.println("El área del triángulo es: " + area);
        System.out.println("El área del triágulo es: " + (base * altura) / 2);

        sc.close();
    }
}
