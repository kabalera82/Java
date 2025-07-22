package Tema02Condicionales;

public class Ejercicio17Animales {

    public static void main(String[] args) {
        /*
         En una granja se compra diariamente una cantidad
         (comidaDiaria) de comida para los ani-males. El número de animales que alimentar
         (todos de la misma especie) es numAnimales, y sabemos que cada animal come una media de kilosPorAnimal.
         Diseña un programa que solicite al usuario los valores anteriores y determine si dispone-mos de alimento suficiente para cada animal.
          En caso negativo, ha de calcular cuál es la ración que corresponde a cada uno de los animales.
          Nota: Evitar que la aplicación realice divisiones por cero.
         */

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Introduce la cantidad de comida diaria: ");
        double comidaDiaria = sc.nextDouble();
        System.out.println("Introduce el número de animales: ");
        int numAnimales = sc.nextInt();
        System.out.println("Introduce la cantidad de kilos que come cada animal: ");
        double kilosPorAnimal = sc.nextDouble();

        double totalComida = numAnimales * kilosPorAnimal;
        if (totalComida > 0) {
            if (comidaDiaria >= totalComida) {
                System.out.println("Hay suficiente comida para los animales.");
            } else {
                double racion = totalComida / numAnimales;
                System.out.println("No hay suficiente comida para los animales. La ración diaria es de " + racion + " kilos.");
            }
        } else {
            System.out.println("No se puede dividir por cero.");
        }

    }
}
