package Tema07Clases.ClasesEspeciales.main;

import Tema07Clases.ClasesEspeciales.enums.Enum1;
import Tema07Clases.ClasesEspeciales.enums.Transporte;

public class Main {
    public static void main(String[] args) {

        // 🎨 Ejemplo con Enum1 (colores)
        Enum1 c1 = Enum1.ROJO;
        Enum1 c2 = Enum1.VERDE;
        Enum1 c3 = Enum1.AZUL;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        Enum1[] colores = Enum1.values();
        for (Enum1 color : colores) {
            System.out.println("Color: " + color + " | Índice: " + color.ordinal());
        }

        // 🚗 Ejemplo con Transporte
        Transporte t = Transporte.MOTO;

        // ------- IF --------
        if (t == Transporte.COCHE) {
            System.out.println("Es un coche");
        } else if (t == Transporte.AUTOBUS) {
            System.out.println("Es un autobús");
        } else if (t == Transporte.CAMION) {
            System.out.println("Es un camión");
        } else {
            System.out.println("Es una moto");
        }

        // ------- SWITCH --------
        switch (t) {
            case COCHE -> System.out.println("Es un coche");
            case AUTOBUS -> System.out.println("Es un autobús");
            case CAMION -> System.out.println("Es un camión");
            case MOTO -> System.out.println("Es una moto");
        }

        // -------- Información detallada de cada enum Transporte --------
        Transporte trans = Transporte.valueOf("MOTO");
        System.out.println("Nombre: " + trans.name());
        System.out.println("Orden: " + trans.ordinal());
        System.out.println("Velocidad: " + trans.getVelocidad());

        Transporte trans2 = Transporte.valueOf("CAMION");
        System.out.println("Nombre: " + trans2.name());
        System.out.println("Orden: " + trans2.ordinal());
        System.out.println("Velocidad: " + trans2.getVelocidad());

        // -------- Recorriendo todos los enum Transporte --------
        Transporte[] matriz = Transporte.values();
        for (Transporte y : matriz) {
            System.out.println(y + " | Índice: " + y.ordinal() + " | Velocidad: " + y.getVelocidad());
        }

        // -------- Comparaciones con compareTo() --------
        Transporte y1 = Transporte.MOTO;
        Transporte y2 = Transporte.CAMION;
        Transporte y3 = Transporte.AUTOBUS;
        //No comparamos velocidades comparamos posiciones para la velocidad hariamos metodo
        if (y1.compareTo(y2) < 0) {
            System.out.println(y1 + " llega antes que " + y2);
        }

        if (y1.compareTo(y2) > 0) {
            System.out.println(y2 + " llega antes que " + y1);
        }

        if (y1.compareTo(y3) < 0) {
            System.out.println(y1 + " llega antes que " + y3);
        }

        if (y2.compareTo(y3) > 0) {
            System.out.println(y3 + " llega antes que " + y2);
        }
    }
}
