package Tema11Colecciones.Ejercicio08ArrayList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**s
 * Ejercicio completo de uso de {@link ArrayList} en Java.
 *
 * <p>Se gestiona una lista de productos mediante un menú de consola. Se permite
 * insertar, listar, buscar, actualizar, eliminar y ordenar los elementos.</p>
 *
 * <p>Este ejercicio permite practicar los métodos básicos de {@link ArrayList}
 * y la manipulación de objetos almacenados en listas.</p>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /**
     * Clase interna que representa un producto con nombre y precio.
     */
    static class Producto {
        String nombre;
        double precio;

        Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return nombre + " (" + precio + " €)";
        }
    }

    /** Lista dinámica que almacena productos. */
    private static final ArrayList<Producto> productos = new ArrayList<>();

    /** Escáner para entrada por teclado. */
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> insertarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarProducto();
                case 4 -> actualizarPrecio();
                case 5 -> eliminarProducto();
                case 6 -> ordenarPorNombre();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- GESTOR DE PRODUCTOS (ArrayList) ---");
        System.out.println("1. Insertar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Ordenar por nombre");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo producto en la lista.
     */
    private static void insertarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        double precio = leerDouble("Precio: ");
        productos.add(new Producto(nombre, precio));
        System.out.println("Producto insertado correctamente.");
    }

    /**
     * Muestra todos los productos de la lista.
     */
    private static void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nListado de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    /**
     * Busca un producto por nombre e imprime su información si lo encuentra.
     */
    private static void buscarProducto() {
        System.out.print("Nombre del producto a buscar: ");
        String nombre = scanner.nextLine().trim();
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("No se encontró ningún producto con ese nombre.");
    }

    /**
     * Actualiza el precio de un producto existente.
     */
    private static void actualizarPrecio() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine().trim();
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                p.precio = nuevoPrecio;
                System.out.println("Precio actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún producto con ese nombre.");
    }

    /**
     * Elimina un producto de la lista por su nombre.
     */
    private static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine().trim();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).nombre.equalsIgnoreCase(nombre)) {
                productos.remove(i);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún producto con ese nombre.");
    }

    /**
     * Ordena la lista de productos alfabéticamente por nombre.
     */
    private static void ordenarPorNombre() {
        if (productos.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Collections.sort(productos, Comparator.comparing(p -> p.nombre.toLowerCase()));
        System.out.println("Productos ordenados por nombre.");
    }

    /**
     * Lee un número entero desde teclado con control de errores.
     *
     * @param mensaje mensaje a mostrar
     * @return número entero válido
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduzca un número entero.");
            }
        }
    }

    /**
     * Lee un número decimal desde teclado con control de errores.
     *
     * @param mensaje mensaje a mostrar
     * @return número decimal válido
     */
    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduzca un número válido.");
            }
        }
    }
}
