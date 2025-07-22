package Tema08Herencia.Ejercicio01Vehiculos.moto;

import Tema08Herencia.Ejercicio01Vehiculos.vehiculos.Vehiculo;

public class Moto extends Vehiculo {
    //Atributos
    int marchas;

    //Metodos
    public void frenoDisco() {
        System.out.println("Freno de disco");
    }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marchas=" + marchas +
                '}';
    }
}
