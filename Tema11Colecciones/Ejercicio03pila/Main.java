package Tema11Colecciones.Ejercicio03pila;

import java.util.Scanner;

/**
 * Definir la insterfaz Pila con parámetros genéricos. Acontinuación,
 * implmentar la interfaz Pila genérica en la clase Contenedor.
 * Por último, escribir un programa donde se utilice un objeto contenedor como pila.
 * En ella apilamos números enteros positivos leidos del teclado
 * hasta que se introduzca -1.
 * Después, mediante un bucle, se despilan todos los numeros
 * hasta que la pila esté vacía y los mostramos por consola.
 */
public class Main {

    public static void main(String[] args) {
        IPila <Integer> p = new Cont<>(new Integer [0]);
        Scanner sc = new Scanner (System.in);
        System.out.println("Introducir entero positivo (-1 para terminar): ");
        Integer n = sc.nextInt();
        while (n != -1) {
            p.apilar (n);
            System.out.println("Introducir entero positivo (-1 para terminar): ");
            n = sc.nextInt();
        }
        System.out.println("Desapilamos: ");
        n = p.desapilar();
        while(n != null){
            System.out.println(n+ " ");
            n = p.desapilar();
        }
        System.out.println(" ");
    }
}
