package Tema04_02VarArgs;

import Tema04_02VarArgs.utils.Utilidades;

public class Ejercicio01ArgumentosVariables {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        //en el primer metodo se adaptaría automaticamente
        utilidades.calcular(1, 2, 723, 4, 5, 6, 1000);
    }
}
