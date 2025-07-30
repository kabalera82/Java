package Tema08_01Herencia.Ejercicio01Vehiculos.moto;

public class MotoTurismo extends Moto {
    //Atributos
    int nivelComodidad;

    //Metodos


    public int getNivelComodidad() {
        return nivelComodidad;
    }

    public void setNivelComodidad(int nivelComodidad) {
        this.nivelComodidad = nivelComodidad;
    }

    @Override
    public String toString() {
        return "MotoTurismo{" +
                "nivelComodidad=" + nivelComodidad +
                ", marchas=" + marchas +
                '}';
    }
}
