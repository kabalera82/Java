package Tema01ConceptosBasicos;

import java.util.Scanner;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 14: [Ejercicio sobre cálculos básicos]
 *
 * @author kabadev
 */
public class Ejercicio14Calculos {

    /**
     * @author kabalera
     */
    public class Main {

        /*
         * Una empresa que gestiona un parque acuático te solicita una aplicación
         * que les ayude a calcular el importe que hay que cobrar en la taquilla
         * por la compra de una serie de entra-das (cuyo número será introducido por el usuario).
         * Existen dos tipos de entrada: infanti-les, que cuestan 15,50 €;
         * y de adultos, que cuestan 20 €.
         * En el caso de que el importe total sea igual o superior a 100 €
         * , se aplicará automática-mente un bono descuento del 5 %.
         */
        public static void main(String[] args) {

            // Declaración de variables
            int numEntradasInfantiles, numEntradasAdultos;
            double precioInfantil = 15.50;
            double precioAdulto = 20.00;
            double importeTotal, importeConDescuento;

            // Crear una instancia de Scanner para leer la entrada del usuario
            Scanner sc = new Scanner(System.in);

            // Solicitar al usuario que introduzca el número de entradas infantiles
            System.out.println("Introduce el número de entradas infantiles: ");
            numEntradasInfantiles = sc.nextInt();

            // Solicitar al usuario que introduzca el número de entradas de adultos
            System.out.println("Introduce el número de entradas de adultos: ");
            numEntradasAdultos = sc.nextInt();

            // Calcular el importe total
            importeTotal = (numEntradasInfantiles * precioInfantil) + (numEntradasAdultos * precioAdulto);

            // Calcular el importe con descuento aplicando una fórmula matemática
            // Si el importeTotal es mayor o igual a 100, se aplica un descuento del 5%
            // Si no, el descuento es 0
            importeConDescuento = importeTotal * (1 - 0.05 * (importeTotal >= 100 ? 1 : 0));

            // Mostrar el resultado
            System.out.println("El importe total a cobrar es: " + importeConDescuento + " €");

            // Cerrar el Scanner
            sc.close();
        }
    }

}
