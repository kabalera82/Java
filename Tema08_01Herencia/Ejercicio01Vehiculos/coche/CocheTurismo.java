package Tema08_01Herencia.Ejercicio01Vehiculos.coche;

public class CocheTurismo extends Coche {
    //Atributos
    int nivelComodidad;

    //metodos

    //Getter y Setters

    public int getNivelComodidad() {
        return nivelComodidad;
    }

    public void setNivelComodidad(int nivelComodidad) {
        this.nivelComodidad = nivelComodidad;
    }

    @Override
    public String toString() {
        return "CocheTurismo{" +
                "nivelComodidad=" + nivelComodidad +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
