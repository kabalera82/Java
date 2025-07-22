package Tema07Clases.Ejercicio06Geometria.figuras;

public class Rectangulo extends Figuras {

    public Rectangulo(double base, double altura, String nombre) {
        super(base, altura, nombre);
    }

    @Override
    public double calcularArea(double base, double altura) {
        double area = base * altura;
        return area;
    }


}

