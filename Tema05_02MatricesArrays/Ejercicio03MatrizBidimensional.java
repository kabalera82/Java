package Tema05_02MatricesArrays;

/**
 * Tema 5, 2 [Tablas]
 * <p>
 * Ejercicio 03: [Matriz Bidimensional]
 *
 * @author kabadev
 */
public class Ejercicio03MatrizBidimensional {

    public static void main(String[] args) {

        int[][] listaNumeros = new int[3][5];

        listaNumeros[0][0] = 1;
        listaNumeros[0][1] = 2;
        listaNumeros[0][2] = 3;
        listaNumeros[0][3] = 4;
        listaNumeros[0][4] = 5;

        listaNumeros[1][0] = 1;
        listaNumeros[1][1] = 2;
        listaNumeros[1][2] = 3;
        listaNumeros[1][3] = 4;
        listaNumeros[1][4] = 5;

        listaNumeros[2][0] = 1;
        listaNumeros[2][1] = 2;
        listaNumeros[2][2] = 3;
        listaNumeros[2][3] = 4;
        listaNumeros[2][4] = 5;

        System.out.println("tamaño filas: " + listaNumeros.length);
        System.out.println("Tamaño 1ª columna " + listaNumeros[0].length);
        System.out.println("Tamaño 1ª columna " + listaNumeros[1].length);
        System.out.println("Tamaño 1ª columna " + listaNumeros[2].length);

        for (int i = 0; i < listaNumeros.length; i++) {
            for (int j = 0; j < listaNumeros[0].length; j++) {
                System.out.print(" " + listaNumeros[i][j] + " ");
            }
        }

        int[][] listaNumeros2 = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        System.out.println("tamaño filas: " + listaNumeros2.length);
        System.out.println("Tamaño 1ª columna " + listaNumeros2[0].length);
        System.out.println("Tamaño 1ª columna " + listaNumeros2[1].length);
        System.out.println("Tamaño 1ª columna " + listaNumeros2[2].length);

        for (int i = 0; i < listaNumeros2.length; i++) {
            for (int j = 0; j < listaNumeros2[0].length; j++) {
                System.out.print(" " + listaNumeros2[i][j] + " ");
            }
        }

    }

}
