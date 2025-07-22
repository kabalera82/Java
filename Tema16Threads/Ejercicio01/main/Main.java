package Tema16Threads.Ejercicio01.main;

import Tema16Threads.Ejercicio01.logica.Hilo;
import Tema16Threads.Ejercicio01.logica.HiloRunnable;

public class Main {
    public static void main(String[] args) {


        Hilo proces = new Hilo();
        Thread proceso2 = new Thread(new HiloRunnable());


        //hay que llamamr al metodo run
        proces.start();
        // Runnable no tiene metodo star
        proceso2.start();

        //Las diferencias tienen que ver con el concepto de herencia
        //La clase runnable le permite implementar varias metododss

    }
}
