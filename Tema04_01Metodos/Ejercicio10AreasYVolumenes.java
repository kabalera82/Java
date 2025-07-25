package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio10AreasYVolumenes {

    /**
     * Realizar una función que calcule y muestre el área o el volumen de un cilindro,
     * según se especifique. Para distinguir un caso de otro se le pasará como opción un
     * número: 1 (para el área) o 2 (para el volumen).
     * Además, hay que pasarle a la función el radio de la base y la altura.
     * Área = 2π*radio*(altura+radio)
     * volumen es π*(radio*radio)*altura
     */

    public static void areaVolumenCilindro(double radio, double altura, int opcion) {
        double volumen, area;
        switch (opcion) {
            case 1 -> {
                area = 2 * Math.PI * radio * (radio + altura);
                System.out.println("El área es de: " + area);
            }
            case 2 -> {
                volumen = Math.PI * Math.pow(radio, 2) * altura;
                System.out.println("El volumen es de: " + volumen);
            }
            default -> System.out.println("Indicador del cálculo erróneo");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca radio: ");
        double radio = sc.nextDouble();
        System.out.println("Introduzca la altura: ");
        double altura = sc.nextDouble();
        System.out.println("""
                Que desea calcular:
                1 - Área.
                2 - Volumen.
                """);
        int tipoCalculo = sc.nextInt();
        System.out.println();
        areaVolumenCilindro(radio, altura, tipoCalculo);
    }
}

