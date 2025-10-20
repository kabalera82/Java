package Tema07Clases.ejercicio08Clonando;

import java.math.BigInteger;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Pinguino p = new PinguinoImpl(46453, "Felix", 6);
        Pinguino p2 = p.clone();
        Pinguino p3 = p2;
        /**
         * Cabe recordar que == compara referencias
         * equals compara contenido
         */

        System.out.println(
                "p==p2: " + (p == p2) + "\n" +
                        "p==p3: " + (p == p3) + "\n" +
                        "p2==p3: " + (p2 == p3) + "\n" +
                        "p.equals(p2): " + p.equals(p2) + "\n" +
                        "p.equals(p3): " + p.equals(p3) + "\n" +
                        "p2.equals(p3): " + p2.equals(p3)
        );
    }
}