package Tema13Streams;

public class Ejercicio01Hola {
    public static void main(String[] args) {

    ISaludo <String> saludoNombres = s -> "Hola Mundo " + s + "!";
        System.out.println(saludoNombres.saludar("Claudia"));
        System.out.println(saludoNombres.saludar("Marcos"));
    }
}
