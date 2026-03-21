import java.util.Scanner;

/**
 * Ejercicio 02 - multiples bloques catch y multi-catch
 *
 * Un try puede tener varios catch para distintos tipos de excepcion.
 * Java 7+ permite agrupar tipos con el operador | (multi-catch).
 * El orden importa: de mas especifica a mas general.
 */
public class Ejercicio02MultipleCatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero entero: ");
        String entrada = sc.nextLine();

        // Multiples catch — cada uno atrapa un tipo distinto
        try {
            int numero = Integer.parseInt(entrada);
            int resultado = 100 / numero;
            System.out.println("100 / " + numero + " = " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Eso no es un numero entero: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero.");
        } catch (Exception e) {
            // Exception es la clase padre — siempre debe ir AL FINAL
            System.out.println("Error inesperado: " + e.getMessage());
        }

        // Multi-catch con | (Java 7+) — mismo tratamiento para dos tipos
        System.out.print("\nIntroduce otro numero: ");
        String entrada2 = sc.nextLine();
        try {
            int n = Integer.parseInt(entrada2);
            int[] arr = new int[n];
            arr[n] = 99; // siempre fuera de rango — para demostrar
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("NumberFormatException o ArrayIndexOutOfBounds: " + e.getMessage());
        }

        sc.close();
    }
}
