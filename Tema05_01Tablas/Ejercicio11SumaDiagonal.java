package Tema05_01Tablas;

import java.util.Scanner;

public class Ejercicio11SumaDiagonal {
    /* Sumar la diagonal de una matriz
- Para ello tenemos que tener en cuenta que los valores de la fila y la columna
- tienen que tener el mismo valor.
*/
    public static void main(String[] args) {
        //Introducir los valores de la matriz dinamicamente
        int filas, columnas;
        var sc = new Scanner(System.in);
        //definimos la matriz
        System.out.println("proporciona la filas: ");
        filas = Integer.parseInt(sc.nextLine());
        System.out.println("proporciona las columnas: ");
        columnas = Integer.parseInt(sc.nextLine());

        //Vamos a definir la matriz
        int[][] matriz = new int[filas][columnas]; //acuerdate del tipado

        //Definimos la variable que almacenará el resultado de la suma.
        int sumaDiagonal = 0;

        //Ahora pediremos los valores y los iremos almacenando en su posicion
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.println("Valor de [" + fila + "][" + columna + "] = ");
                matriz[fila][columna] = Integer.parseInt(sc.nextLine());
            }
        }

        //Ahora mostraremos la matriz y la suma de su diagonal
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (columna == fila) {
                    sumaDiagonal += matriz[fila][columna];
                }
                System.out.println(" Matriz [ " + fila + " ] [ " + columna + " ] = " + matriz[fila][columna]);

            }
        }
        System.out.println(sumaDiagonal);

    }
}
