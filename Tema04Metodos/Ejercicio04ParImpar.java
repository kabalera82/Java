package Tema04Metodos;

import javax.swing.JOptionPane;

public class Ejercicio04ParImpar {

    // Método para verificar si un número es par o impar

    static boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true; // El número es par
        } else {
            return false; // El número es impar
        }

        //return (numero % 2 == 0)?true:false; // Una forma ternaria
    }


    // Método main para ejecutar la clase (punto de entrada)
    public static void main(String[] args) {

        System.out.println("proporciona un número entero: ");
        String input = JOptionPane.showInputDialog("Proporciona un número entero: ");
        int numero = Integer.parseInt(input); // Convertir el input a entero

        if (esPar(numero)) {
            System.out.println("El número " + numero + " es par.");
            JOptionPane.showMessageDialog(null, "El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
            JOptionPane.showMessageDialog(null, "El número " + numero + " es impar.");
        }


    }


}
