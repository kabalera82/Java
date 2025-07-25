package Tema04_01Metodos;

import java.util.Scanner;

/*
 * Escribe un programa que pida un número entero
 * y muestre en pantalla la representación de la tabla de multiplicar de ese número.
 * La tabla mostrará el resultado total de multiplicar
 * dicho número por los valores entre 1 y 10, de esta forma:
 * 5 x 1 = 5, 5 x 2 = 10, ..., 5 x 10 = 50.
 */
public class Ejercicio34TablaMultiplicar {

    public static void main(String[] args) {
        System.out.println("Inserte un numero: ");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for(int i= 1; i<= 10;i++){
            System.out.println(i + " x " + numero + " = " + numero*i);
        }
    }
}
