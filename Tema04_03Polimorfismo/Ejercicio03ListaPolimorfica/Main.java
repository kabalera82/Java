package Tema04_03Polimorfismo.Ejercicio03ListaPolimorfica;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 03 - Lista polimorfica
 *
 * Una lista de tipo Vehiculo puede contener Coche, Moto y Barco.
 * Al iterar, Java ejecuta el metodo correcto de cada subclase.
 * Eso es polimorfismo — mismo codigo, comportamiento distinto.
 */
public class Main {

    public static void main(String[] args) {

        List<Vehiculo> flota = new ArrayList<>();
        flota.add(new Coche("Toyota", 180, 4));
        flota.add(new Moto("Honda", 220));
        flota.add(new Barco("Sunseeker", 60));
        flota.add(new Coche("Ford", 160, 2));
        flota.add(new Moto("Yamaha", 200));

        System.out.println("=== Flota de vehiculos ===");
        for (Vehiculo v : flota) {
            System.out.println(v.info());
        }

        // Estadisticas
        int totalVehiculos = flota.size();
        int coches = 0;
        int velocidadMax = 0;

        for (Vehiculo v : flota) {
            if (v instanceof Coche) coches++;
            if (v.velocidadMaxima > velocidadMax) velocidadMax = v.velocidadMaxima;
        }

        System.out.println("\nTotal vehiculos: " + totalVehiculos);
        System.out.println("Coches: " + coches);
        System.out.println("Velocidad maxima de la flota: " + velocidadMax + " km/h");
    }
}
