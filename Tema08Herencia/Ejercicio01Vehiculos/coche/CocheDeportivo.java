package Tema08Herencia.Ejercicio01Vehiculos.coche;

public class CocheDeportivo extends Coche {
    //Atributos
    int velocidadPunta;

    //metodos


    //Getters y Setters
    public int getVelocidadPunta() {
        return velocidadPunta;
    }

    public void setVelocidadPunta(int velocidadPunta) {
        this.velocidadPunta = velocidadPunta;
    }

    @Override
    public String toString() {
        return "CocheDeportivo{" +
                "modelo='" + modelo + '\'' +
                ", velocidadPunta=" + velocidadPunta +
                '}';
    }
}
