package Tema08_01Herencia.Ejercicio01Vehiculos.coche;

public class CocheTodoterreno extends CocheTurismo {
    //Atributos

    //metodos
    public void usar4x4() {
        System.out.println("Usando el 4x4");
    }

    @Override
    public String toString() {
        return "CocheTodoterreno{" +
                "modelo='" + modelo + '\'' +
                ", nivelComodidad=" + nivelComodidad +
                '}';
    }
}
