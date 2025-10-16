package Tema99EjerciciosMultiples.inventario;


import java.util.Map;
import java.util.TreeMap;

/**
 * Sistema de Gestión de Inventario
 * --------------------------------
 * Escribe un método que reciba un mapa (Map) que represente el inventario de productos.
 * Las claves del mapa serán los nombres de los productos (String),
 * y los valores serán arreglos de tipo double[] con dos elementos:
 * El primer elemento representa la cantidad disponible.
 * El segundo elemento representa el precio unitario del producto.
 *
 * El método debe devolver una lista de tuplas (pares) que contenga
 * el nombre del producto y el valor total de su inventario
 * (cantidad * precio_unitario), ordenados de mayor a menor
 * según dicho valor total.*
 * Ejemplo:
 * ----------
 * Entrada:
 * Map<String, double[]> inventario = Map.of(
 * "manzanas", new double[]{50, 0.5},
 * "naranjas", new double[]{30, 0.8},
 * "plátanos", new double[]{20, 0.6},
 * "uvas", new double[]{10, 1.2}
 * );
 * Salida esperada:
 * [(manzanas, 25.0), (naranjas, 24.0), (plátanos, 12.0), (uvas, 12.0)]
 */
public class GestionInventario {



    public static void main (String[] args){

        System.out.println("Hola");
    }
}
