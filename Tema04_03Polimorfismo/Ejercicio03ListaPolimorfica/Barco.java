package Tema04_03Polimorfismo.Ejercicio03ListaPolimorfica;

public class Barco extends Vehiculo {

    public Barco(String marca, int velocidadMaxima) {
        super(marca, velocidadMaxima);
    }

    @Override
    public String tipoMovimiento() { return "agua"; }
}
