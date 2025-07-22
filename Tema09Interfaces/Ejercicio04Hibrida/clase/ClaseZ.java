package Tema09Interfaces.Ejercicio04Hibrida.clase;


public class ClaseZ implements Tema09Interfaces.Ejercicio04Hibrida.interfaz.InterfazC {

    @Override
    public void saludarC() {
        System.out.println("Hola desde doble CC");
    }

    @Override
    public void saludarA() {
        System.out.println("Hola desde doble AA");
    }
}
