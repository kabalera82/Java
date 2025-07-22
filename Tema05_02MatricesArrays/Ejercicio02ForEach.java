package Tema05_02MatricesArrays;

/**
 * Tema 5, 2 [Tablas]
 * <p>
 * Ejercicio 03: [ForEach]
 *
 * @author kabadev
 */
public class Ejercicio02ForEach {

    public static void main(String[] args) {
        //No es apropiado cuando queremos modificar el array

        int[] listaNumeros = new int[10];
        for (int i = 0; i < listaNumeros.length; i++) {
            listaNumeros[i] = i + 1;
        }

        //Para recorrer toda la matriz
        for (int numeroActual : listaNumeros) {
            System.out.println("numero Actual: " + numeroActual);
        }


    }
}
