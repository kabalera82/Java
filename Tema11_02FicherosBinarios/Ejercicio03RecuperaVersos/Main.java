package Tema10_02FicherosBinarios.Ejercicio03RecuperaVersos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


/**
 * Recupera la estrofa del archivo cancionPirata.dat
 * Y muestrala por consola
 */

public class Main {


    public static String ExtraerFile() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("./Tema10_02FicherosBinarios/cancionPirata.dat"))) {
            String versos = (String) entrada.readObject();
            return versos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        // Llamada al metdod EtraerFile
        ExtraerFile();
        String versos = ExtraerFile();
        System.out.println(versos);
    }
}
