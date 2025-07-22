package Tema09Interfaces.Ejercicio01.clases;

import Tema09Interfaces.Ejercicio01.interfaces.Modificacion;

public class Acumulador implements Modificacion {

    //Variuables
    int valor;

    //constructor
    public Acumulador(int valor) {
        this.valor = valor;
    }

    //Metodos
    @Override
    public void incremento(int a) {
        this.valor += a;
    }

    public int getValor() {
        return valor;
    }
}
