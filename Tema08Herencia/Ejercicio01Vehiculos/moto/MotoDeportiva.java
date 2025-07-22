package Tema08Herencia.Ejercicio01Vehiculos.moto;

public class MotoDeportiva extends Moto {
    //Atributos
    int velocidadPunta;

    //Metodos
    public int getVelocidadPunta() {
        return velocidadPunta;
    }

    public void setVelocidadPunta(int velocidadPunta) {
        this.velocidadPunta = velocidadPunta;
    }

    @Override
    public String toString() {
        return "MotoDeportiva{" +
                "velocidadPunta=" + velocidadPunta +
                ", marchas=" + marchas +
                '}';
    }
}
