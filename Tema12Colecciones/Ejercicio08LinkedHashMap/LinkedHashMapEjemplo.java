import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ejemplo de uso de LinkedHashMap con un menú de consola.
 *
 * Se gestiona un conjunto de productos con su precio, manteniendo
 * el orden de inserción. Permite insertar, mostrar, actualizar,
 * eliminar y recorrer productos mediante opciones de menú.
 */
public class LinkedHashMapEjemplo {

    /** Almacena los productos con su nombre como clave y el precio como valor. */
    private static final LinkedHashMap<String, Double> productos = new LinkedHashMap<>();

    /** Escáner para leer entradas por teclado. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal. Muestra un menú de opciones para gestionar el mapa de productos.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> insertarProducto();
                case 2 -> mostrarMapa();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> recorrerMapa();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra el menú principal por consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE PRODUCTOS ---");
        System.out.println("1. Insertar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Actualizar precio de un producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Recorrer mapa con for-each");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo producto en el LinkedHashMap.
     * Si el producto ya existe, se sobrescribe el precio.
     */
    private static void insertarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio = leerDouble("Precio del producto: ");
        productos.put(nombre, precio);
        System.out.println("Producto insertado correctamente.");
    }

    /**
     * Muestra todos los productos y sus precios en el orden de inserción.
     */
    private static void mostrarMapa() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\nListado de productos:");
        for (String clave : productos.keySet()) {
            System.out.println("Producto: " + clave + " → " + productos.get(clave) + " €");
        }
    }

    /**
     * Actualiza el precio de un producto existente.
     * Si no existe, informa al usuario.
     */
    private static void actualizarProducto() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();
        if (productos.containsKey(nombre)) {
            double nuevoPrecio = leerDouble("Nuevo precio: ");
            productos.put(nombre, nuevoPrecio);
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    /**
     * Elimina un producto del mapa si existe.
     */
    private static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        if (productos.remove(nombre) != null) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    /**
     * Recorre el mapa usando entrySet y muestra cada par clave-valor.
     */
    private static void recorrerMapa() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para recorrer.");
            return;
        }
        System.out.println("\nRecorrido del mapa:");
        for (Map.Entry<String, Double> entry : productos.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " | Precio: " + entry.getValue() + " €");
        }
    }

    /**
     * Lee un número entero desde teclado, mostrando un mensaje.
     *
     * @param mensaje texto que se mostrará antes de la lectura
     * @return entero introducido por el usuario
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
     * Lee un número decimal (double) desde teclado, mostrando un mensaje.
     *
     * @param mensaje texto que se mostrará antes de la lectura
     * @return número decimal introducido por el usuario
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
