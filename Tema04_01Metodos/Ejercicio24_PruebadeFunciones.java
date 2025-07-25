package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio24_PruebadeFunciones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;

        //PROBAMOS esPrimo()
        System.out.println("Introduzca un número entero positivo: ");
        n = teclado.nextInt();

        if (Ejercicio24_Matematicas.esPrimo(n)) {
            System.out.println("El número " + n + " es primo");
        } else {
            System.out.println("El número " + n + " no es primo");
        }

        //PROBAMOS digitos()
        System.out.println("Introduzca un número entero positivo: ");
        n = teclado.nextInt();

        System.out.println(n + " tiene " + Ejercicio24_Matematicas.digitos(n) + " dígitos.");

        //PROBAMOS volumenCilindro()

        double radio, altura;
        System.out.println("""
                Cálculo del volumen de un cilindro
                Introduzca el radio en metros: 
                """);
        radio = teclado.nextDouble();
        System.out.println("Introduzca la altura en metros: ");
        altura = teclado.nextDouble();
        System.out.println("""
                El volumen del cilindro es 
                """
                + Ejercicio24_Geometria.volumenCilindro(radio, altura) + """ 
                 m3
                """);
    }
}
