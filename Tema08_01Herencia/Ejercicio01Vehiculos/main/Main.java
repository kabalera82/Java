package Tema08_01Herencia.Ejercicio01Vehiculos.main;

import Tema08_01Herencia.Ejercicio01Vehiculos.coche.Coche;
import Tema08_01Herencia.Ejercicio01Vehiculos.coche.CocheTodoterreno;
import Tema08_01Herencia.Ejercicio01Vehiculos.moto.MotoDeportiva;
import Tema08_01Herencia.Ejercicio01Vehiculos.vehiculos.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.setMarca("Audi");
        vehiculo1.setMatricula("123AA");

        System.out.println("Automovil: { \n Marca " + vehiculo1.getMarca() + "\n Matricula: " + vehiculo1.getMatricula() + "\n}");
        vehiculo1.acelerar();

        // --------------------------------------

        Coche coche = new Coche();
        coche.setMarca("Audi");
        coche.setMatricula("222BBB");
        coche.setModelo("A6");
        System.out.println("Automovil: { \n Marca " + vehiculo1.getMarca() + "\n Matricula: " + vehiculo1.getMatricula() + "\n}");

        // ----------------------------------------

        CocheTodoterreno cocheTodoterreno = new CocheTodoterreno();
        cocheTodoterreno.setMarca("Suzuki");
        cocheTodoterreno.setMatricula("111BBB");
        cocheTodoterreno.setModelo("Ivara");
        cocheTodoterreno.setNivelComodidad(5);
        System.out.println(cocheTodoterreno.getMarca() + "\n" + cocheTodoterreno.getModelo() + "\n" + cocheTodoterreno.getMatricula() + "\n" + cocheTodoterreno.getNivelComodidad());
        cocheTodoterreno.usar4x4();

        // -------------------------------------------

        MotoDeportiva moto = new MotoDeportiva();
        moto.frenoDisco();

    }
}
