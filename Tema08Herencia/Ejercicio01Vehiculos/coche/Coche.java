package Tema08Herencia.Ejercicio01Vehiculos.coche;


import Tema08Herencia.Ejercicio01Vehiculos.vehiculos.Vehiculo;

public class Coche extends Vehiculo {
    //Atributos
    String modelo;
    int velocidadMaxima;

    public Coche() {
        velocidadMaxima = 180;
    }

    //Metodos
    public void acelerar() {
        System.out.println("acelerando");
    }

    public void frenar() {
        System.out.println("frenando");
    }

    public void ajustarAsientos() {
        System.out.println("Asientos ajustados");
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                '}';
    }
}
