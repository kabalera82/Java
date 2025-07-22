package Tema09Interfaces.Ejercicio02Lista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista cola = new Lista();

        System.out.println("Introduce números enteros (negativo para terminar):");

        int numero = sc.nextInt();

        while (numero >= 0) {
            cola.encolar(numero);
            System.out.print("Otro número: ");
            numero = sc.nextInt();
        }

        System.out.println("\n📤 Números en orden de llegada:");
        while (!cola.estaVacia()) {
            System.out.print(cola.desencolar() + " ");
        }

        System.out.println("\n✅ Fin del programa.");
    }
}
