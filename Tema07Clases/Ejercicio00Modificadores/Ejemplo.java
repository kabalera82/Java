package Tema07Clases.Ejercicio00Modificadores;

public class Ejemplo {

    //Atributos
    private int atributo1;
    private int contador;

    //Constructor
    public Ejemplo() {
        contador=0;
        this.atributo1 = atributo1;
    }


    public int getAtributo() {
        return atributo1;
    }
    public void setAtributo(int atributo) {
        this.atributo1 = atributo;
        contador++;
    }
    public int getContador() {
        return contador;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }
}
