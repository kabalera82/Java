package Tema04_01Metodos;

import java.util.Random;

public class Ejercicio05numerosAleatorios {


    public static void main(String[] args) {

        //Método para generar un número aleatorio entro un rango
        var aleatorio = new Random();
        //Generar los valores entre 0 y 100(no se incluye el valor límite)
        int valorAleatorio = aleatorio.nextInt(0, 100 + 1);
        System.out.println("Valor aleatorio (0 y 100): " + valorAleatorio);

        //Numero aleatorio entre 100 y 200
        int min = 100;
        int max = 200;
        int valorAleatorio2 = aleatorio.nextInt(min, max + 1);
        System.out.println("Valor aleatorio (100 y 200): " + valorAleatorio2);

    }

}
