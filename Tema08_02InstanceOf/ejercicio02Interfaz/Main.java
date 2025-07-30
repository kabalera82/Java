package Tema08_02InstanceOf.ejercicio02Interfaz;

public class Main {

    public static void main(String[] args) {

        Robot robot = new Soldado();
        System.out.println(robot instanceof Armadura);

        robot = new Soldado();
        System.out.println(robot instanceof Armadura);

    MicroOndas microOndas = new MicroOndas();
    System.out.println(microOndas instanceof Armadura);

    }
}
