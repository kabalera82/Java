package Tema14Threads.Ejercicio01.logica;

public class Hilo extends Thread {

    //ahora Hilo se convierte en un Thread
    public void run() { //la clase tiene un metodo run que vamos a sobrescribir
        System.out.println("Hilo ejecutandose con clase Thread");
    }

}
