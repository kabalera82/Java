package Tema11Colecciones.Ejercicio04Map;


import java.util.HashMap;
import java.util.Map;

/**
 * Ejemplo práctico de uso de Map en Java:
 * ----------------------------------------
 * Gestión básica de un inventario de productos, donde cada clave es un nombre de producto
 * y cada valor es un array con cantidad y precio unitario.
 */
public class Main {

    public static void main(String[] args) {

        // 1️⃣ Crear el Map
        // Usamos HashMap porque no necesitamos mantener orden específico
        Map<String, double[]> inventario = new HashMap<>();

        // 2️⃣ Insertar productos en el inventario
        // Cada valor es un array: [cantidad, precio]
        inventario.put("Manzanas", new double[]{50, 0.5});
        inventario.put("Naranjas", new double[]{30, 0.8});
        inventario.put("Plátanos", new double[]{20, 1.2});
        inventario.put("Peras", new double[]{15, 1.0});

        // 3️⃣ Mostrar inventario inicial
        System.out.println("=== Inventario inicial ===");
        mostrarInventario(inventario);

        // 4️⃣ Actualizar el precio de un producto
        System.out.println("\nActualizando precio de 'Plátanos' a 1.5€...");
        if (inventario.containsKey("Plátanos")) {
            inventario.get("Plátanos")[1] = 1.5;  // modificamos la posición [1] (precio)
        }

        // 5️⃣ Eliminar un producto
        System.out.println("Eliminando 'Peras' del inventario...");
        inventario.remove("Peras");

        // 6️⃣ Mostrar inventario actualizado
        System.out.println("\n=== Inventario actualizado ===");
        mostrarInventario(inventario);

        // 7️⃣ Calcular el valor total del inventario
        double valorTotal = calcularValorTotal(inventario);
        System.out.println("\n💰 Valor total del inventario: " + valorTotal + " €");
    }

    /**
     * Muestra por consola el contenido del inventario de forma tabulada.
     *
     * @param inventario Mapa con productos y sus datos [cantidad, precio]
     */
    private static void mostrarInventario(Map<String, double[]> inventario) {
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Producto", "Cantidad", "Precio", "Total (€)");
        System.out.println("----------------------------------------------------");

        // Recorremos el mapa con for-each + entrySet
        for (Map.Entry<String, double[]> entry : inventario.entrySet()) {
            String nombre = entry.getKey();
            double[] datos = entry.getValue();
            double cantidad = datos[0];
            double precio = datos[1];
            double total = cantidad * precio;

            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f%n", nombre, cantidad, precio, total);
        }
    }

    /**
     * Calcula el valor total del inventario sumando cantidad × precio de cada producto.
     *
     * @param inventario Mapa de productos
     * @return valor total en euros
     */
    private static double calcularValorTotal(Map<String, double[]> inventario) {
        double total = 0.0;
        for (Map.Entry<String, double[]> entry : inventario.entrySet()) {
            double[] datos = entry.getValue();
            total += datos[0] * datos[1];
        }
        return total;
    }
}
