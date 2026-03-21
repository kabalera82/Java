package Tema04_03Polimorfismo.Ejercicio02ClasesAbstractas;

/**
 * Clase abstracta — no se puede instanciar directamente.
 * Define la estructura comun de todas las figuras.
 * Las subclases DEBEN implementar area() y perimetro().
 */
public abstract class Figura {

    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    // Metodos abstractos — sin cuerpo, obligan a las subclases a implementarlos
    public abstract double area();
    public abstract double perimetro();

    // Metodo concreto — compartido por todas las subclases
    public void describir() {
        System.out.printf("%s [%s] — area: %.2f | perimetro: %.2f%n",
            getClass().getSimpleName(), color, area(), perimetro());
    }
}
