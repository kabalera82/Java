package Tema11Colecciones.Ejercicio02ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Gestor de productos usando {@link ArrayList}.
 *
 * <p>Permite insertar, listar, buscar, actualizar, eliminar y ordenar productos
 * desde un menú de consola. Cada producto tiene un nombre y un precio.</p>
 *
 * <p>Ejercicio práctico de manejo de colecciones dinámicas y objetos en Java.</p>
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

        /**
         * Constructor del producto.
         *
         * @param nombre nombre del producto
         * @param precio precio del producto
         */
        Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        /**
         * Representación textual del producto.
         *
         * @return cadena con el nombre y el precio del producto
         */
        @Override
        public String toString() {
            return "Artículo: " + nombre + " [ " + precio + " € ]";
        }
    }

    /** Lista dinámica que almacena los productos. */
    private static final ArrayList<Producto> productos = new ArrayList<>();

    /** Escáner global para entrada por teclado. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia el programa.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        mostrarMenu();
    }

    /**
     * Muestra el menú principal del gestor y procesa las opciones del usuario.
     */
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("""
                    --- GESTOR DE PRODUCTOS (ArrayList) ---
                    1. Insertar producto
                    2. Listar productos
                    3. Buscar producto
                    4. Actualizar precio
                    5. Eliminar producto
                    6. Ordenar por nombre
                    0. Salir
                    - - - - - - - - - - - - - - - - - - - - - - - -
                    """);

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
     * Inserta un nuevo producto en la lista.
     * Solicita el nombre y precio por teclado.
     */
    private static void insertarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine().trim();
        vacio();
        double precio = leerDouble("Precio: ");
        productos.add(new Producto(nombre, precio));
        System.out.println("Producto insertado correctamente.");
    }

    /**
     * Muestra todos los productos almacenados en la lista.
     */
    private static void listarProductos() {
        vacio();
        productos.forEach(System.out::println);
    }

    /**
     * Busca un producto por su nombre.
     *
     * @return el producto encontrado o {@code null} si no existe
     */
    private static Producto buscarProducto() {
        System.out.print("Nombre del producto a buscar: ");
        String nombre = scanner.nextLine().trim().toLowerCase();

        for (Producto p : productos) {
            if (p.nombre.toLowerCase().contains(nombre)) {
                System.out.println("Encontrado: " + p);
                return p;
            }
        }

        System.out.println("No se encontró ningún producto con ese nombre.");
        return null;
    }

    /**
     * Actualiza el precio de un producto existente.
     *
     * @return {@code true} si se actualizó correctamente, {@code false} en caso contrario
     */
    private static boolean actualizarPrecio() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine().trim();

        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                p.precio = nuevoPrecio;
                System.out.println("Precio actualizado correctamente.");
                return true;
            }
        }

        System.out.println("No se encontró ningún producto con ese nombre.");
        return false;
    }

    /**
     * Elimina un producto existente tras confirmación del usuario.
     * Reutiliza el método {@link #buscarProducto()}.
     */
    private static void eliminarProducto() {
        Producto productoEliminar = buscarProducto();

        if (productoEliminar != null) {
            System.out.print("¿Seguro que deseas eliminarlo? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                productos.remove(productoEliminar);
                System.out.println("Producto eliminado: " + productoEliminar.nombre);
            } else {
                System.out.println("Operación cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún producto con ese nombre.");
        }
    }

    /**
     * Ordena la lista de productos alfabéticamente por nombre.
     */
    private static void ordenarPorNombre() {
        vacio();
        Collections.sort(productos, Comparator.comparing(p -> p.nombre.toLowerCase()));
        System.out.println("Productos ordenados por nombre.");
    }

    /**
     * Lee un número entero con control de errores.
     *
     * @param mensaje texto que se muestra al usuario
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
     * Lee un número decimal con control de errores.
     *
     * @param mensaje texto que se muestra al usuario
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

    /**
     * Comprueba si la lista de productos está vacía.
     * Muestra un mensaje informativo si no hay elementos.
     */
    private static void vacio() {
        if (productos.isEmpty()) {
            System.out.println("La lista está vacía.");
        }
    }
}
