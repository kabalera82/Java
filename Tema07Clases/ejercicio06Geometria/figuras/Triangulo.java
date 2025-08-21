package Tema07Clases.ejercicio06Geometria.figuras;

public class Triangulo extends Figuras {
    //Atributos
    String tipo;

    public Triangulo(double base, double altura, String nombre, String tipo) {
        super(base, altura, nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public double calcularArea(double base, double altura) {
        double area = (base * altura) / 2;
        return area;
    }

}
