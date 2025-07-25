package Tema04_01Metodos;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio07GeneradorId {

    static void generadorIdUnico() {

    }


    public static void main(String[] args) {
        generadorIdUnico();
        System.out.println("***Generador de ID único iniciado.***");
        var consola = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        // Capturamos el nombre del usuario
        // Cogemos solo los dos primeros caracteres del nombre
        //Los ponemos en mayúsculas
        var nombre = consola.nextLine().substring(0, 2).toUpperCase();
        System.out.println("Introduce tu apellido: ");
        var apellido = consola.nextLine().substring(0, 2).toUpperCase();
        System.out.println("Año de nacimiento (YYYY)? ");
        var ano = consola.nextLine().substring(2, 4);
        // Ahora generamos un número aleatorio entre 0 y 9999
        var numeroAleatorio = new Random().nextInt(0, 9999);
        // Formateamos el número aleatorio para que tenga 4 dígitos
        var numeroFormateado = new DecimalFormat("####").format(numeroAleatorio);
        // Concatenamos todo para formar el ID único
        var idUnico = nombre + apellido + ano + numeroFormateado;
        // Mostramos el ID único generado
        System.out.println("Tu ID único es: " + idUnico);
    }
}
