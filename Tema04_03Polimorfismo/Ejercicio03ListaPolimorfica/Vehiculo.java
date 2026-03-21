package Tema04_03Polimorfismo.Ejercicio03ListaPolimorfica;

public abstract class Vehiculo {

    protected String marca;
    protected int velocidadMaxima;

    public Vehiculo(String marca, int velocidadMaxima) {
        this.marca = marca;
        this.velocidadMaxima = velocidadMaxima;
    }

    public abstract String tipoMovimiento();

    public String info() {
        return marca + " (" + tipoMovimiento() + ") — max " + velocidadMaxima + " km/h";
    }
}
