package Tema04_01Metodos;

public class Ejercicio06LongitudCadena {

    // Método para obtener el largo de una cadena de texto
    static void mostrarLargo(String cadena) {
        System.out.println("Largo de la cadena: " + cadena.length());
    }

    //Método para recorrer la cadena de texto
    static void recorrerCadena(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println("Caracter en la posición " + i + ": " + cadena.charAt(i));
        }
    }

    // Subcadenas en Java
    //Substring(indice inicio, indice fin)
    static void subcadena(String cadena, int inicio, int fin) {
        if (inicio < 0 || fin > cadena.length() || inicio >= fin) {
            System.out.println("Índices inválidos para la subcadena.");
            return;
        }
        String subcadena = cadena.substring(inicio, fin);
        System.out.println("Subcadena: " + subcadena);
    }

    public static void main(String[] args) {
        String cadena = "Hola Mundo desde Java";
        String cadena2 = "¡Bienvenido a la programación!";
        mostrarLargo(cadena);
        mostrarLargo(cadena2);
        mostrarLargo(cadena + cadena2);
        recorrerCadena(cadena);
        recorrerCadena(cadena2);
        subcadena(cadena, 0, 4); // "Hola"
        subcadena(cadena2, 0, 11); // "¡Bienvenido"
    }
}
