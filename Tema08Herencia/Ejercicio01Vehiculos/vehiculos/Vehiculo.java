package Tema08Herencia.Ejercicio01Vehiculos.vehiculos;

public class Vehiculo {

    // CONSTANTE
    private final int CODIGO_AUTO;
    // Atributos
    private String marca;
    private String matricula;
    private int velocidadMaxima;

    // Constructor por defecto
    public Vehiculo() {
        this.velocidadMaxima = 120;
        this.CODIGO_AUTO = 5555;
    }

    // Constructor con parámetros
    public Vehiculo(String marca, String matricula) {
        this.marca = marca;
        this.matricula = matricula;
        this.velocidadMaxima = 120;
        this.CODIGO_AUTO = 5555;
    }

    //metodos
    public void acelerar() {
        System.out.println("Acelerando");
    }

    public void frenar() {
        System.out.println("Frenando");
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getCodigoAuto() {
        return CODIGO_AUTO;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                ", CODIGO_AUTO=" + CODIGO_AUTO +
                '}';
    }
}
