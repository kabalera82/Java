package Tema07Clases.ejercicio06Geometria.figuras;

public abstract class Figuras {
    //Atributos
    double base;
    double altura;
    String nombre;

    // Contructor por defecto de la clase abstracta
    public Figuras(double base, double altura, String nombre) {
        this.base = base;
        this.altura = altura;
        this.nombre = nombre;
    }


    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public abstract double calcularArea(double base, double altura);

}