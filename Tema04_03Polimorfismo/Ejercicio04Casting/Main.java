package Tema04_03Polimorfismo.Ejercicio04Casting;

/**
 * Ejercicio 04 - Casting entre clases y instanceof
 *
 * Upcasting  — subclase → superclase. Siempre seguro, implicito.
 * Downcasting — superclase → subclase. Puede fallar: usar instanceof antes.
 *
 * Java 16+ permite Pattern Matching con instanceof:
 *   if (obj instanceof Circulo c) { c.getRadio(); }
 */

abstract class Forma {
    public abstract double area();
}

class Cuadrado extends Forma {
    private double lado;
    public Cuadrado(double lado) { this.lado = lado; }
    public double getLado() { return lado; }
    @Override
    public double area() { return lado * lado; }
}

class CirculoForma extends Forma {
    private double radio;
    public CirculoForma(double radio) { this.radio = radio; }
    public double getRadio() { return radio; }
    @Override
    public double area() { return Math.PI * radio * radio; }
}

public class Main {

    public static void main(String[] args) {

        // Upcasting implicito — siempre funciona
        Forma f1 = new Cuadrado(5);
        Forma f2 = new CirculoForma(3);

        System.out.println("Area f1: " + f1.area());
        System.out.println("Area f2: " + f2.area());

        // Downcasting con instanceof — forma clasica (Java < 16)
        Forma[] formas = { new Cuadrado(4), new CirculoForma(2), new Cuadrado(7) };

        for (Forma f : formas) {
            if (f instanceof Cuadrado) {
                Cuadrado c = (Cuadrado) f;
                System.out.println("Cuadrado con lado " + c.getLado());
            } else if (f instanceof CirculoForma) {
                CirculoForma c = (CirculoForma) f;
                System.out.println("Circulo con radio " + c.getRadio());
            }
        }

        System.out.println();

        // Pattern Matching con instanceof (Java 16+) — mas conciso
        for (Forma f : formas) {
            if (f instanceof Cuadrado c) {
                System.out.println("Pattern matching — lado: " + c.getLado());
            } else if (f instanceof CirculoForma c) {
                System.out.println("Pattern matching — radio: " + c.getRadio());
            }
        }

        // ClassCastException — lo que pasa sin instanceof
        try {
            Forma forma = new CirculoForma(1);
            Cuadrado mal = (Cuadrado) forma; // ClassCastException
        } catch (ClassCastException e) {
            System.out.println("\nClassCastException: " + e.getMessage());
            System.out.println("Por eso siempre comprueba con instanceof antes de hacer downcast.");
        }
    }
}
