package Tema07Clases.Ejercicio00Modificadores;

import Tema07Clases.Ejercicio00Modificadores.Ejemplo;

public class Main {

    public static void main(String[] args) {

        Ejemplo ejemplo = new Ejemplo();

        ejemplo.setAtributo(1);
        ejemplo.setAtributo(1);
        ejemplo.setAtributo(1);
        ejemplo.setAtributo(1);
        ejemplo.setAtributo(1);
        //Estamos accediendo 5 veces a Atributo y contador nos lo indica
        System.out.println(ejemplo.getContador());

        //-----------------------

        Ejemplo ejemplo1 = new Ejemplo();


    }
}
