package Tema09Interfaces.Ejercicio03Jerarquia.clase;

import Tema09Interfaces.Ejercicio03Jerarquia.interfaces.*;

public class ClaseX implements InterfaceA, InterfaceB {

    @Override
    public void saludarDesdeA() {
        System.out.println("Hola AAA");
    }

    @Override
    public void saludarDesdeB() {
        System.out.println("Hola BBB");
    }
}
