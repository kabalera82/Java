package Tema07Clases.ejercicio02coche;

/**
 * Tema 7: [Clases]
 * <p>
 * Ejercicio 02: [Creación de la Clase Coche]
 *
 * @author kabadev
 */

public class Coche {

    private final String matricula;

    private String marca;
    private String modelo;
    private String color;
    private int velocidad;
    private int precio;
    private int potencia;

    private Coche(String matricula, String marca, String modelo, String color, int velocidad, int precio, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidad = velocidad;
        this.precio = precio;
        this.potencia = potencia;
    }

    // Método factory
    public static Coche crearCoche(String matricula, String marca, String modelo, String color, int velocidad, int precio, int potencia) {
        return new Coche(matricula, marca, modelo, color, velocidad, precio, potencia);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "matricula: '" + matricula + '\'' +
                ", marca: '" + marca + '\'' +
                ", modelo: '" + modelo + '\'' +
                ", color: '" + color + '\'' +
                ", velocidad: " + velocidad +
                ", precio: " + precio +
                ", potencia: " + potencia;
    }


}
