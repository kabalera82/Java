package Tema09Interfaces.Ejercicio03Jerarquia.main;

import Tema09Interfaces.Ejercicio03Jerarquia.clase.ClaseX;

public class Main {
    public static void main(String[] args) {
        ClaseX claseX = new ClaseX();

        claseX.saludarDesdeA();

        ClaseX claseY = new ClaseX();
        claseY.saludarDesdeB();
    }
}
