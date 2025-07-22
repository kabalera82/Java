package Tema04Metodos;

import javax.swing.*;
import java.util.stream.IntStream;

public class Ejercicio32Password {

    public static void main(String[] args) {
        String pass = savePass(); //Creamos un String pass inicializado con la funcion savePass();
        boolean check = checkPass(pass); //Boolean para comprobación

        if (!check) { //Si es distinto de check
            JOptionPane.showMessageDialog( //Joption muestra Mensaje dialogo
                    null, //No hay ventana padre
                    "Too many failed attempts.\n" +
                            "System Blocked", "Error",
                    JOptionPane.ERROR_MESSAGE); //mIcono de error
        } else {
            JOptionPane.showMessageDialog(
                    null, // No hay ventana padre
                    "System unlocked",
                    "Éxito",  // Parámetro del título que faltaba
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }
// Funcion guardarClave ============================================================================================
    private static String savePass() {
        return JOptionPane.showInputDialog("Save your pass");
    }

    // Funcion Comprobación ============================================================================================
    private static boolean checkPass(String pass) {
        int contador = 0;
        do {
            String temporalPass = JOptionPane.showInputDialog("Insert your password");
            if (pass.equals(temporalPass)) { // equals para comprobar que son identicos objetos de distinta referencia
                return true;
            }
            contador++;
        } while (contador < 3);
        return false;
    }

}