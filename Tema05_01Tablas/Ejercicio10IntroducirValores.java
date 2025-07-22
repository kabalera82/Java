package Tema05_01Tablas;

import java.util.Scanner;

public class Ejercicio10IntroducirValores {

    public static void main(String[] args) {
        //Introducir dinamicamente valores en una matriz
        int filas, columnas;
        var consola = new Scanner(System.in);
        //definimos la matriz
        System.out.print("proporciona las filas: ");
        filas = Integer.parseInt(consola.nextLine());
        System.out.print("Introduce las columnas");
        columnas = Integer.parseInt(consola.nextLine());
        //Vamos a definir la matriz

        int[][] matriz = new int[filas][columnas];

        //Solicitar los valores
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.println(" Valor [ " + fila + " ] [ " + columna + " ] = ");
                matriz[fila][columna] = Integer.parseInt(consola.nextLine());
            }
        }
        //Iteramos los valores de la matriz para mostrar las posiciones y su valor
        System.out.println();
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                System.out.println(" Matriz [ " + fila + " ] [ " + columna + " ] = " + matriz[fila][columna]);
            }
        }
        consola.close();
    }
}
