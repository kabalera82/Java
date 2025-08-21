package Tema07Clases.ejercicio06Geometria.main;


import Tema07Clases.ejercicio06Geometria.figuras.Rectangulo;
import Tema07Clases.ejercicio06Geometria.figuras.Triangulo;

public class Main {
    public static void main(String[] args) {


        Rectangulo rectangulo = new Rectangulo(10, 10, "rectangulo");

        Triangulo triangulo = new Triangulo(10, 10, "triangulo", "equilatero");

        double areaRectuangulo = rectangulo.calcularArea(10, 5);
        System.out.println("Area rectangulo: " + areaRectuangulo);

        double areaTriangulo = triangulo.calcularArea(10, 5);
        System.out.println("Area triangulo: " + areaTriangulo);

        System.out.println(rectangulo.getAltura());
    }
}
