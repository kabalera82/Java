package Tema99EjerciciosMultiples.SistemaGestionInventario;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static Map<String, double[]> inventario = Map.of(
            "manzanas", new double[]{50, 0.5},
            "naranjas", new double[]{30, 0.8},
            "plátanos", new double[]{20, 0.6},
            "uvas", new double[]{10, 1.2}
    );

    private static void gestionar() {
        Map<String, double[]> inventarioOrdenado = new TreeMap<>(inventario);

        for(String producto : inventarioOrdenado.keySet()){
            double[]datos = inventarioOrdenado.get(producto);
            System.out.println(producto + keySet[0] +": ");
            for (int i= 0; i<datos.length;i++){
                System.out.println("producto" + datos[0] + datos[1]);
            }

        }
    }

    public static void main(String[] args) {
        gestionar();
    }
}
