package Tema04_03Polimorfismo.Ejercicio02ClasesAbstractas;

/**
 * Ejercicio 02 - Clases abstractas
 *
 * Figura es abstracta — no se puede hacer new Figura().
 * Pero una variable de tipo Figura puede apuntar a cualquier subclase.
 * Al llamar a area() o perimetro(), Java ejecuta la version de la subclase
 * real — eso es polimorfismo en tiempo de ejecucion.
 */
public class Main {

    public static void main(String[] args) {

        // Variable de tipo abstracto — apunta a subclases concretas
        Figura[] figuras = {
            new Circulo("rojo", 5),
            new Rectangulo("azul", 4, 6),
            new Triangulo("verde", 3, 4, 5, 5)
        };

        System.out.println("=== Figuras ===");
        for (Figura f : figuras) {
            f.describir(); // polimorfismo — llama al metodo correcto segun el tipo real
        }

        // Calcular area total
        double areaTotal = 0;
        for (Figura f : figuras) {
            areaTotal += f.area();
        }
        System.out.printf("%nArea total de todas las figuras: %.2f%n", areaTotal);

        // Esto NO compila — Figura es abstracta
        // Figura f = new Figura("negro"); // ERROR
    }
}
