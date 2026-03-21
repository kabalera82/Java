package Tema04_03Polimorfismo.Ejercicio02ClasesAbstractas;

public class Triangulo extends Figura {

    private double base;
    private double altura;
    private double ladoA;
    private double ladoB;

    public Triangulo(String color, double base, double altura, double ladoA, double ladoB) {
        super(color);
        this.base = base;
        this.altura = altura;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        return base + ladoA + ladoB;
    }
}
