package Tema05_01Tablas;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Ejercicio12CamaraSecreta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la longitud de la contraseña:");
        int longitud = sc.nextInt();

        // Generamos la combinación secreta aleatoria
        int[] combSecreta = combinacion(longitud);

        // Activamos el descifrador que pedirá intentos al jugador
        descifrador(combSecreta, longitud);
    }

    // Genera una combinación secreta de números aleatorios entre 0 y 9
    private static int[] combinacion(int longitud) {
        Random aleatorio = new Random();
        int[] combSecreta = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            combSecreta[i] = aleatorio.nextInt(10); // Números de 0 a 9
        }

        return combSecreta;
    }

    // Permite al jugador adivinar cada dígito por separado, no toda la cadena a la vez
    private static int[] descifrador(int[] combSecreta, int longitud) {
        Scanner sc = new Scanner(System.in);
        int[] combJugador = new int[longitud];

        System.out.println("\n🔐 Intenta adivinar la combinación:");

        // Se recorre cada dígito de la combinación
        for (int i = 0; i < longitud; i++) {
            boolean acertado = false;

            // Mientras no acierte el número en la posición actual, se repite
            do {
                System.out.print("👉 Introduce el número en la posición " + (i + 1) + ": ");
                combJugador[i] = sc.nextInt();

                if (combJugador[i] < combSecreta[i]) {
                    System.out.println("📉 Te has quedado corto");
                } else if (combJugador[i] > combSecreta[i]) {
                    System.out.println("📈 Te pasaste");
                } else {
                    System.out.println("✅ ¡Correcto!");
                    acertado = true; // Solo saldrá del bucle si acierta el número
                }
            } while (!acertado);
        }

        System.out.println("\n🎉 ¡Felicidades! Has abierto la cámara secreta.");
        return combJugador;
    }
}
