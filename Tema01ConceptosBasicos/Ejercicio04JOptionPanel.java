package Tema01ConceptosBasicos;

import javax.swing.*;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 04: [JOptionPanel]
 *
 * @author kabadev
 */

public class Ejercicio04JOptionPanel {

    public static void main(String[] args) {

        // Pedimos la Edad.
        String anos = JOptionPane.showInputDialog("Introduce tu edad: ");
        int edad = Integer.parseInt(anos);
        JOptionPane.showMessageDialog(null, "Tu edad el próximo año sera de: " + (edad + 1));

        //Indica según la un boolean si será mayor de edad.
        boolean mayoriaEdad = edad >= 18;
        JOptionPane.showMessageDialog(null, "Será mayor de edad? " + mayoriaEdad);


        // Pedir al usuario 4 notas y mostrar la media
        int nota1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota 1:"));
        int nota2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota 2:"));
        int nota3 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota 3:"));
        int nota4 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota 4:"));

        double media = (nota1 + nota2 + nota3 + nota4) / 4.0;
        JOptionPane.showMessageDialog(null, "La nota media es: " + media);
    }
}
