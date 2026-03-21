package Tema04_03Polimorfismo.Ejercicio03ListaPolimorfica;

public class Coche extends Vehiculo {

    private int numPuertas;

    public Coche(String marca, int velocidadMaxima, int numPuertas) {
        super(marca, velocidadMaxima);
        this.numPuertas = numPuertas;
    }

    @Override
    public String tipoMovimiento() { return "ruedas"; }

    public int getNumPuertas() { return numPuertas; }
}
