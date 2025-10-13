package Tema11Colecciones.Ejercicio01Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio completo de gestión de productos usando arrays en Java.
 *
 * <p>Se utilizan arrays estáticos que se amplían manualmente al insertar nuevos productos.
 * No se emplean colecciones como ArrayList.</p>
 *
 * <p>Operaciones disponibles mediante menú:</p>
 * <ul>
 *     <li>Insertar producto</li>
 *     <li>Listar productos</li>
 *     <li>Buscar producto por nombre</li>
 *     <li>Actualizar precio</li>
 *     <li>Eliminar producto</li>
 *     <li>Salir</li>
 * </ul>
 *
 * <p>Este ejercicio permite practicar manipulación de arrays: inserción, ampliación,
 * eliminación y recorrido.</p>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /** Clase interna para representar un producto con nombre y precio. */
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

    /** Array dinámico de productos (sin usar colecciones). */
    private static Producto[] productos = new Producto[0];

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
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú principal por consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- GESTOR DE PRODUCTOS (Arrays) ---");
        System.out.println("1. Insertar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo producto al final del array, ampliando el tamaño si es necesario.
     */
    private static void insertarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        double precio = leerDouble("Precio: ");

        Producto nuevo = new Producto(nombre, precio);

        // Ampliar array en +1 posición
        productos = Arrays.copyOf(productos, productos.length + 1);
        productos[productos.length - 1] = nuevo;

        System.out.println("Producto insertado correctamente.");
    }

    /**
     * Muestra todos los productos del array.
     */
    private static void listarProductos() {
        if (productos.length == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nListado de productos:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i]);
        }
    }

    /**
     * Busca un producto por nombre y muestra su información.
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
     * Elimina un producto del array desplazando el resto de elementos.
     */
    private static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine().trim();

        int index = -1;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].nombre.equalsIgnoreCase(nombre)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("No se encontró ningún producto con ese nombre.");
            return;
        }

        // Desplazar elementos a la izquierda desde el índice eliminado
        for (int i = index; i < productos.length - 1; i++) {
            productos[i] = productos[i + 1];
        }

        // Redimensionar el array a length - 1
        productos = Arrays.copyOf(productos, productos.length - 1);
        System.out.println("Producto eliminado correctamente.");
    }

    /**
     * Lee un número entero de consola con control de errores.
     *
     * @param mensaje mensaje a mostrar
     * @return entero introducido
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
     * Lee un número decimal de consola con control de errores.
     *
     * @param mensaje mensaje a mostrar
     * @return número decimal introducido
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
