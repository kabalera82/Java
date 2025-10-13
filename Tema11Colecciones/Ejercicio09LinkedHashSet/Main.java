package Tema11Colecciones.Ejercicio09LinkedHashSet;


import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * Ejercicio completo de uso de {@link LinkedHashSet} en Java.
 *
 * <p>Se gestiona un conjunto de productos, manteniendo el orden de inserción
 * y evitando duplicados automáticamente gracias a la implementación de
 * {@link #equals(Object)} y {@link #hashCode()} en la clase Producto.</p>
 *
 * <p>Operaciones disponibles mediante menú:</p>
 * <ul>
 *     <li>Insertar producto</li>
 *     <li>Listar productos</li>
 *     <li>Buscar producto por nombre</li>
 *     <li>Actualizar precio</li>
 *     <li>Eliminar producto</li>
 *     <li>Vaciar conjunto</li>
 * </ul>
 *
 * <p>{@link LinkedHashSet} combina:</p>
 * <ul>
 *     <li>Evitar duplicados (como {@link java.util.HashSet})</li>
 *     <li>Mantener el orden de inserción (a diferencia de HashSet)</li>
 * </ul>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /**
     * Clase interna que representa un producto.
     *
     * <p>Se sobrescriben equals() y hashCode() para que
     * dos productos se consideren iguales si tienen el mismo nombre,
     * evitando así duplicados en el LinkedHashSet.</p>
     */
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
                case 6 -> vaciarConjunto();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Producto)) return false;
            Producto producto = (Producto) o;
            return nombre.equalsIgnoreCase(producto.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre.toLowerCase());
        }
    }

    /** Conjunto de productos que mantiene el orden de inserción y evita duplicados. */
    private static final LinkedHashSet<Producto> productos = new LinkedHashSet<>();

    /** Escáner para entrada por teclado. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- GESTOR DE PRODUCTOS (LinkedHashSet) ---");
        System.out.println("1. Insertar producto");
        System.out.println("2. Listar productos (orden de inserción)");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Vaciar conjunto");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo producto en el conjunto.
     * No se permiten duplicados: si ya existe uno con el mismo nombre,
     * no se inserta.
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

        boolean insertado = productos.add(nuevo);
        if (insertado) {
            System.out.println("Producto insertado correctamente.");
        } else {
            System.out.println("Ya existe un producto con ese nombre.");
        }
    }

    /**
     * Muestra todos los productos en el orden de inserción.
     */
    private static void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nListado de productos:");
        for (Producto p : productos) {
            System.out.println("- " + p);
        }
    }

    /**
     * Busca un producto por nombre.
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
     * Para actualizar, se elimina y se vuelve a insertar, ya que los Sets no tienen índices.
     */
    private static void actualizarPrecio() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine().trim();
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                productos.remove(p); // quitamos el antiguo
                productos.add(new Producto(nombre, nuevoPrecio)); // insertamos el nuevo
                System.out.println("Precio actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún producto con ese nombre.");
    }

    /**
     * Elimina un producto del conjunto si existe.
     */
    private static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine().trim();
        Producto aEliminar = null;
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                aEliminar = p;
                break;
            }
        }
        if (aEliminar != null) {
            productos.remove(aEliminar);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún producto con ese nombre.");
        }
    }

    /**
     * Vacía completamente el conjunto.
     */
    private static void vaciarConjunto() {
        if (productos.isEmpty()) {
            System.out.println("El conjunto ya está vacío.");
            return;
        }
        productos.clear();
        System.out.println("Conjunto vaciado correctamente.");
    }

    /**
     * Lee un número entero de consola con control de errores.
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
     * Lee un número decimal de consola con control de errores.
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
