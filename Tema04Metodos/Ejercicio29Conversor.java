package Tema04Metodos;

import java.util.Scanner;

public class Ejercicio29Conversor {

    // Método para convertir libras a euros
    public static double librasToEuros(double libras, double tipoCambio) {
        return libras * tipoCambio;
    }

    // Método para convertir euros a libras
    public static double eurosToLibras(double euros, double tipoCambio) {
        return euros / tipoCambio;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("💱 Bienvenido al Conversor de Divisas (sin clases ni objetos) 💱");

        System.out.print("🔢 Introduce el tipo de cambio personalizado (por ejemplo, 0.85): ");
        double tipo = sc.nextDouble();

        double euros = 100.00;
        double libras = 100.00;

        double tipoCambioDefecto = 0.85;

        // Conversión con tipo de cambio por defecto
        System.out.println("\n📊 --- Conversor con tipo de cambio por defecto (" + tipoCambioDefecto + ") ---");
        System.out.println("💶 " + euros + " euros = " + String.format("%.2f", eurosToLibras(euros, tipoCambioDefecto)) + " libras");
        System.out.println("💷 " + libras + " libras = " + String.format("%.2f", librasToEuros(libras, tipoCambioDefecto)) + " euros");

        // Conversión con tipo de cambio introducido
        System.out.println("\n📊 --- Conversor con tipo de cambio personalizado (" + tipo + ") ---");
        System.out.println("💶 " + euros + " euros = " + String.format("%.2f", eurosToLibras(euros, tipo)) + " libras");
        System.out.println("💷 " + libras + " libras = " + String.format("%.2f", librasToEuros(libras, tipo)) + " euros");

        sc.close();
        System.out.println("\n✅ ¡Conversión completada con éxito!");
    }
}
