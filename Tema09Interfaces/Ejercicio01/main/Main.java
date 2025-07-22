package Tema09Interfaces.Ejercicio01.main;

import Tema09Interfaces.Ejercicio01.clases.Acumulador;

public class Main {
    public static void main(String[] args) {

        Acumulador acumulador = new Acumulador(25);

        acumulador.incremento(21);
        System.out.println(acumulador.getValor());
    }
}
