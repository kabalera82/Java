package Tema04_03Polimorfismo.Ejercicio01;

public class Main {
    public static void main(String[] args) {

        Animal perro = new Perro();
        Animal gato = new Gato();

        Animal x = new Perro();
        Animal y = new Gato();

        perro.hacerSonido();
        gato.hacerSonido();
        x.hacerSonido();
        y.hacerSonido();
    }
}
