package Tema04_03Polimorfismo.Ejercicio03ListaPolimorfica;

public class Moto extends Vehiculo {

    public Moto(String marca, int velocidadMaxima) {
        super(marca, velocidadMaxima);
    }

    @Override
    public String tipoMovimiento() { return "2 ruedas"; }
}
