package Tema11Colecciones.Ejercicio07TreeSet;


import java.util.Scanner;
import java.util.TreeSet;

/**
 * Ejercicio completo de uso de {@link TreeSet} en Java.
 *
 * <p>Se gestiona un conjunto de productos que se mantienen automáticamente
 * ordenados alfabéticamente por nombre gracias a la implementación de
 * {@link Comparable} en la clase interna {@link Producto}.</p>
 *
 * <p>{@link TreeSet}:</p>
 * <ul>
 *     <li>No permite duplicados (según equals/compareTo)</li>
 *     <li>Ordena automáticamente los elementos (no mantiene orden de inserción)</li>
 *     <li>Permite búsquedas rápidas y recorridos ordenados</li>
 * </ul>
 *
 * <p>El programa permite insertar, listar, buscar, actualizar, eliminar y vaciar productos.</p>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /**
     * Clase interna que representa un producto.
     *
     * <p>Implementa {@link Comparable} para que {@link TreeSet}
     * pueda ordenar automáticamente los productos por nombre.</p>
     */
    static class Producto implements Comparable<Producto> {
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

        /**
         * Dos productos se consideran iguales si tienen el mismo nombre (ignorando mayúsculas).
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Producto)) return false;
            Producto other = (Producto) obj;
            return this.nombre.equalsIgnoreCase(other.nombre);
        }

        @Override
        public int hashCode() {
            return nombre.toLowerCase().hashCode();
        }

        /**
         * Orden natural: alfabético por nombre, ignorando mayúsculas.
         */
        @Override
        public int compareTo(Producto o) {
            return this.nombre.compareToIgnoreCase(o.nombre);
        }
    }

    /** Conjunto ordenado automáticamente de productos. */
    private static final TreeSet<Producto> productos = new TreeSet<>();

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
                case 6 -> vaciarConjunto();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }



    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- GESTOR DE PRODUCTOS (TreeSet) ---");
        System.out.println("1. Insertar producto");
        System.out.println("2. Listar productos (orden alfabético)");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Vaciar conjunto");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo producto en el TreeSet.
     * Si ya existe uno con el mismo nombre, no se inserta.
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
     * Muestra todos los productos en orden alfabético (automático).
     */
    private static void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("""
        \n-- LISTADOS --
        1. Ascendente (A..Z)
        2. Descendente (Z..A)
        3. Por rango [desde..hasta] (ambos inclusive)
        4. Por prefijo (ej.: "man" -> manzana, mango)
        5. Con Iterator (ejemplo clásico)
        0. Volver
        """);

        int op = leerEntero("Elija: ");
        switch (op) {
            case 1 -> { // Ascendente (orden natural del TreeSet)
                productos.forEach(p -> System.out.println("- " + p));
            }
            case 2 -> { // Descendente
                productos.descendingSet().forEach(p -> System.out.println("- " + p));
            }
            case 3 -> { // Rango [desde..hasta], inclusivo
                String desde = pedirNoVacio("Desde (nombre): ");
                String hasta = pedirNoVacio("Hasta (nombre): ");

                // Usamos compareTo por nombre (tu orden natural).
                java.util.NavigableSet<Producto> rango =
                        productos.subSet(new Producto(desde, 0), true,
                                new Producto(hasta, 0), true);

                if (rango.isEmpty()) System.out.println("Sin resultados en ese rango.");
                else rango.forEach(p -> System.out.println("- " + p));
            }
            case 4 -> { // Prefijo
                String prefijo = pedirNoVacio("Prefijo: ");
                // Truco: [prefijo .. prefijo + U+FFFF] cubre todas las cadenas que comienzan por ese prefijo
                String to = prefijo + "\uffff";

                java.util.NavigableSet<Producto> pref =
                        productos.subSet(new Producto(prefijo, 0), true,
                                new Producto(to, 0), true);

                if (pref.isEmpty()) System.out.println("Sin resultados con ese prefijo.");
                else pref.forEach(p -> System.out.println("- " + p));
            }
            case 5 -> { // Iterator "a la antigua"
                java.util.Iterator<Producto> it = productos.iterator();
                while (it.hasNext()) System.out.println("- " + it.next());
            }
            case 0 -> { /* volver al menú principal */ }
            default -> System.out.println("Opción no válida.");
        }
    }

    // Helper para pedir cadenas no vacías (reutiliza tu Scanner)
    private static String pedirNoVacio(String msg) {
        String s;
        do {
            System.out.print(msg);
            s = scanner.nextLine().trim();
        } while (s.isEmpty());
        return s;
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
     * Como TreeSet no tiene índices, se elimina el producto antiguo y se inserta el actualizado.
     */
    private static void actualizarPrecio() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine().trim();
        Producto encontrado = null;
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }
        if (encontrado != null) {
            double nuevoPrecio = leerDouble("Nuevo precio: ");
            productos.remove(encontrado);
            productos.add(new Producto(nombre, nuevoPrecio));
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún producto con ese nombre.");
        }
    }

    /**
     * Elimina un producto por su nombre.
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
     * Vacía el conjunto completo.
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
