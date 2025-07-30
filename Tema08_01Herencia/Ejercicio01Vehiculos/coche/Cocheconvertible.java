package Tema08_01Herencia.Ejercicio01Vehiculos.coche;

public class Cocheconvertible extends CocheTurismo {
    //Atributos

    //metodos
    public void quitarTecho() {
        System.out.println("Quitando el techo");
    }

    @Override
    public String toString() {
        return "Cocheconvertible{" +
                "modelo='" + modelo + '\'' +
                '}';
    }
}
