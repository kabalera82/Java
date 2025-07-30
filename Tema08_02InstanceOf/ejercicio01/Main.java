package Tema08_02InstanceOf.ejercicio01;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        perro = null; // estamos haciendo la referencia de perro nula por lo que no hereda por lo que la salida false

        Gato gato = new Gato ();
        Robot robot = new Robot();

        System.out.println(perro instanceof Animal); // Retorno será true porque si es una clase hija
        System.out.println(gato instanceof Animal);
        // System.out.println(robot instanceof Animal): esto daría error no hereda de
        // System.out.println(perro instanceof gato); esto da error no hereda de





    }
}
