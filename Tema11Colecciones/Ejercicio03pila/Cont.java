package Tema11Colecciones.Ejercicio03pila;

import java.util.Arrays;

public class Cont<T> implements IPila<T> {

    //Atributos
    private T [] objetos;
    public Cont(T[] objetos) {
        this.objetos = objetos;
    }

    //==================================================================================================================
    T extraerDelPrincipio () {
        T extraido = this.objetos[0]; // Guardamos el primer elemento
        T [] nuevoArray = Arrays.copyOfRange(this.objetos, 1, this.objetos.length);
        this.objetos = nuevoArray;
        return extraido;
    }
    //==================================================================================================================
    void insertarAlPrincipio(T nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        System.arraycopy(objetos, 0, objetos, 1, objetos.length -1);
        objetos[0] = nuevo;
    }
    // Implementamos la pila ===================================================================================

    @Override
    public void apilar (T nuevo){
        this.insertarAlPrincipio(nuevo);
    }
    public T desapilar () {
        return this.extraerDelPrincipio();
    }
}
