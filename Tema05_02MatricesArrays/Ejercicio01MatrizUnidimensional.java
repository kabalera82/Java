package Tema05_02MatricesArrays;

/**
 * Tema 5, 2 [Tablas]
 * <p>
 * Ejercicio 01: [Matriz unidimensional]
 *
 * @author kabadev
 */
public class Ejercicio01MatrizUnidimensional {

    public static void main(String[] args) {

        //creamos la matriz
        int[] listaNumeros = new int[10];

        //Accedemos a la matriz
        listaNumeros[0] = 10;
        listaNumeros[1] = 0;
        listaNumeros[2] = 1;
        listaNumeros[3] = 12;
        listaNumeros[4] = 5;
        listaNumeros[5] = 10;
        listaNumeros[6] = 6;
        listaNumeros[7] = 5;
        listaNumeros[8] = 23;
        listaNumeros[9] = 9;

        //Mostramos el tamaño de la matriz
        System.out.println("tamaño de la matriz: " + listaNumeros.length);

        //Mostramos elementos de la matriz
        System.out.println("valor " + listaNumeros[0]);

        // Recorremos la matriz
        for (int i = 0; i < listaNumeros.length; i++) {
            System.out.println("valor " + listaNumeros[i]);
        }

        //Vamos a crear una matriz asignandole dinámicamente los valores
        int[] listaDinamica = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println("Tamaño de la matriz: " + listaDinamica.length);
        for (int i = 0; i < listaDinamica.length; i++) {
            System.out.println("valor " + listaDinamica[i]);
        }

        //Modificamos los valores de una matriz
        listaDinamica[3] = 0;
        listaDinamica[4] = 0;
        listaDinamica[5] = 0;
        for (int i = 0; i < listaDinamica.length; i++) {
            System.out.println("valor " + listaDinamica[i]);
        }


    }
}
