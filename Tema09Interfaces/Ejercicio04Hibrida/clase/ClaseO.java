package Tema09Interfaces.Ejercicio04Hibrida.clase;


import Tema09Interfaces.Ejercicio04Hibrida.interfaz.*;

public class ClaseO implements
        // cuando comparta nombre alguna interfaz para no declarar como abstracto se dará la ruta completa
        Tema09Interfaces.Ejercicio04Hibrida.interfaz.InterfazA,
        Tema09Interfaces.Ejercicio04Hibrida.interfaz.InterfazB,
        Tema09Interfaces.Ejercicio04Hibrida.interfaz.InterfazC {

    @Override
    public void saludarB() {
        System.out.println("Hola desde B");
    }

    @Override
    public void saludarC() {
        System.out.println("Hola desde C");
    }

    @Override
    public void saludarA() {
        System.out.println("Hola desde A");
    }
}
