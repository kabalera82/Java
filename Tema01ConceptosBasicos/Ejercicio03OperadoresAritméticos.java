package Tema01ConceptosBasicos;

import java.net.StandardSocketOptions;
import java.util.Scanner;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 03: [Operadores Aritméticos]
 *
 * @author kabadev
 */
public class Ejercicio03OperadoresAritméticos {


    public static void main(String[] args) {

        // Escribe un programa que compruebe valores de tipo ciclico,
        // Compruebe que el valor siguiente al maximo es el mínimo.
        short num = 32767;
        short num2 = Short.MAX_VALUE; // Valor maximo 32767
        System.out.println("Valor máximo de short numero: " + num + " y " + num2);
        num++;
        num2++;
        System.out.println("Valor después de incrementar: " + num + " y " + num2); // -32768

        // Pide al usuario su edad y muestra por consola la que tendrá el año siguiente
        int edad;
        System.out.println("Dame tu edad");
        Scanner sc = new Scanner(System.in);
        edad = sc.nextInt();
        System.out.println("Tu edad el próximo año será: " + (edad + 1));

        // Pide al usuario cuatro notas y calcula la media
        int nota1, nota2, nota3, nota4;
        double media;
        System.out.println("Nota1: ");
        nota1 = sc.nextInt();
        System.out.println("Nota2: ");
        nota2 = sc.nextInt();
        System.out.println("Nota3: ");
        nota3 = sc.nextInt();
        System.out.println("Nota4: ");
        nota4 = sc.nextInt();
        media = (nota1 + nota2 + nota3 + nota4) / 4.0;
        System.out.println("La nota media es " + media);

        // Calcula la longitud y el área de un círculo dado su radio
        double area, circle, radio;
        System.out.println("Introduce un radio");
        radio = sc.nextDouble();
        circle = 2 * Math.PI * radio;
        System.out.println("La longitud es " + circle);
        area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área es de: " + area);

        // Realiza una actividad que solicite al usuario su edad,
        // e indica si es mayor de edad mediante un boolean
        System.out.println("Introduce tu edad: ");
        // El tipo de dato de edad ya está declarado con anterioridad solo sobrescribimos
        edad = sc.nextInt();
        boolean mayorEdad = edad >= 18;
        System.out.println("Mayoría de edad: " + mayorEdad);

        //Pedir al usuario e indique mediante un literal boolean si es par o impar.
        int numero;
        System.out.println("Introduce un numero: ");
        numero = sc.nextInt();
        boolean Par = numero % 2 == 0;
        System.out.println("El numero " + numero + " es par? " + Par);

        //Pedir numero con decimales y mostrar redondeo mas proximo.
        System.out.println("Introduce un número con decimales:");
        double redondeo = sc.nextDouble();
        long redondeado = Math.round(redondeo);
        System.out.println("El redondeo más próximo es: " + redondeado);

        // Dado un número, calcula su valor absoluto
        System.out.println("Dame un número: ");
        int n = sc.nextInt();
        int valorAbsoluto = n < 0 ? -1 * n : n;
        System.out.println("Valor absoluto de " + n + " es " + valorAbsoluto);

        // Alternativa usando Math.abs
        System.out.println("Dame otro número: ");
        n = sc.nextInt();
        valorAbsoluto = Math.abs(n);
        System.out.println("El valor absoluto de " + n + " es " + valorAbsoluto);

        sc.close();
    }
}
