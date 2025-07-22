package Tema07Clases.ejercicio02coche;

public class Main {

    public static final Coche coche0 = Coche.crearCoche("1234 ABC", "Toyota", "Corolla", "Rojo", 120, 18000, 110);
    public static final Coche coche1 = Coche.crearCoche("5678 DEF", "Ford", "Focus", "Azul", 110, 17000, 105);

    public static void main(String[] args) {

        System.out.println(coche0);
        System.out.println(coche1);

    }

}
