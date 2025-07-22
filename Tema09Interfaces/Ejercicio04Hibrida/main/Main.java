package Tema09Interfaces.Ejercicio04Hibrida.main;


import Tema09Interfaces.Ejercicio04Hibrida.clase.*;

public class Main {
    public static void main(String[] args) {

        ClaseO clase1 = new ClaseO();
        clase1.saludarA();

        ClaseO clase2 = new ClaseO();
        clase2.saludarB();

        ClaseO clase3 = new ClaseO();
        clase3.saludarC();

        ClaseZ clase4 = new ClaseZ();
        clase4.saludarA();

        ClaseZ clase5 = new ClaseZ();
        clase5.saludarC();

        /*
        ClaseZ clase6 = new ClaseZ();
        clase6.saludarB();
        */
    }
}
