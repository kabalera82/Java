package Tema01ConceptosBasicos;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 15 [Ejercicio sobre cálculos básicos]
 *
 * @author kabadev
 */
public class Ejercicio15Calculos {
    /*
     * Solicita al usuario un número real y calcula su raíz cuadrada.
     * Implementa el programa uti-lizando el nombre cualificado de las clases,
     * en lugar de utilizar ninguna importación.
     */

    public static void main(String[] args) {
        // Crear una instancia de Scanner para leer la entrada del usuario
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Solicitar al usuario que introduzca un número real
        System.out.println("Introduce un número real: ");
        double numero = sc.nextDouble();

        // Calcular la raíz cuadrada del número
        double raizCuadrada = java.lang.Math.sqrt(numero);

        // Mostrar el resultado
        System.out.println("La raíz cuadrada de " + numero + " es: " + raizCuadrada);

        // Cerrar el Scanner
        sc.close();
    }
}
