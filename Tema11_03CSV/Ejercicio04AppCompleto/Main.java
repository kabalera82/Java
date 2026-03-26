package Tema11_03CSV.Ejercicio04AppCompleto;

import java.util.List;
import java.util.Scanner;

/**
 * Ejercicio 04 — Aplicación completa de gestión de productos con menú interactivo.
 *
 * <p>Integra el modelo {@link Producto} y el DAO {@link ProductoCSVDao} en una
 * interfaz de consola que permite:</p>
 * <ol>
 *   <li>Listar todos los productos</li>
 *   <li>Buscar por nombre</li>
 *   <li>Añadir un nuevo producto</li>
 *   <li>Actualizar el precio de un producto</li>
 *   <li>Eliminar un producto por id</li>
 * </ol>
 *
 * <p><b>[APRENDE] — Arquitectura en capas (simplificada)</b><br>
 * Esta aplicación tiene tres capas bien diferenciadas:</p>
 * <ul>
 *   <li><strong>UI</strong> ({@link Main}): interacción con el usuario, Scanner, println.</li>
 *   <li><strong>Modelo</strong> ({@link Producto}): datos del dominio.</li>
 *   <li><strong>Persistencia</strong> ({@link ProductoCSVDao}): lectura/escritura en CSV.</li>
 * </ul>
 * <p>Cada capa solo conoce a la capa de debajo. La UI conoce el DAO y el modelo.
 * El DAO conoce el modelo. El modelo no conoce a nadie. Así cada capa puede
 * cambiar sin afectar a las otras.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** DAO para acceso al CSV. */
    private static final ProductoCSVDao dao = new ProductoCSVDao();

    /** Scanner compartido para leer del teclado. */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        // Inicializamos el CSV con datos de ejemplo si está vacío
        inicializarSiVacio();
        ejecutarMenu();
        sc.close();
    }

    // =========================================================================
    // Menú principal
    // =========================================================================

    /**
     * Bucle principal del menú interactivo.
     * Se repite hasta que el usuario elige "Salir".
     */
    private static void ejecutarMenu() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> listarProductos();
                case 2 -> buscarPorNombre();
                case 3 -> añadirProducto();
                case 4 -> actualizarPrecio();
                case 5 -> eliminarProducto();
                case 6 -> {
                    System.out.println("\nHasta luego!");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida. Elige entre 1 y 6.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""

                ======= GESTOR DE PRODUCTOS CSV =======
                1. Listar todos los productos
                2. Buscar por nombre
                3. Añadir nuevo producto
                4. Actualizar precio
                5. Eliminar producto
                6. Salir
                =======================================
                """);
    }

    // =========================================================================
    // Operaciones de menú
    // =========================================================================

    /** Muestra todos los productos en formato tabla. */
    private static void listarProductos() {
        List<Producto> productos = dao.listarTodos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println();
        System.out.printf("%-5s %-22s %10s %8s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("-".repeat(49));

        for (Producto p : productos) {
            System.out.printf("%-5d %-22s %9.2f€ %7d ud%n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getStock());
        }

        System.out.println("-".repeat(49));
        System.out.printf("Total: %d producto(s)%n", productos.size());
    }

    /** Busca productos por nombre (búsqueda parcial, ignora mayúsculas). */
    private static void buscarPorNombre() {
        System.out.print("\nTexto a buscar en el nombre: ");
        String texto = sc.nextLine().trim();

        List<Producto> resultados = dao.buscarPorNombre(texto);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron productos con '" + texto + "'.");
        } else {
            System.out.println("\nResultados encontrados:");
            resultados.forEach(p -> System.out.println("  " + p));
        }
    }

    /** Pide datos al usuario y añade un nuevo producto al CSV. */
    private static void añadirProducto() {
        System.out.println("\n--- AÑADIR NUEVO PRODUCTO ---");

        // Calculamos el siguiente id disponible
        List<Producto> actuales = dao.listarTodos();
        int nuevoId = actuales.stream()
                .mapToInt(Producto::getId)
                .max()
                .orElse(0) + 1;

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        double precio = leerDouble("Precio (€): ");
        int stock     = leerEntero("Stock (unidades): ");

        Producto nuevo = new Producto(nuevoId, nombre, precio, stock);
        dao.añadir(nuevo);
        System.out.println("Producto añadido con id=" + nuevoId);
    }

    /** Pide un id y un nuevo precio, y actualiza el producto en el CSV. */
    private static void actualizarPrecio() {
        System.out.println("\n--- ACTUALIZAR PRECIO ---");
        listarProductos();

        int id         = leerEntero("\nID del producto a actualizar: ");
        double precio  = leerDouble("Nuevo precio (€): ");

        boolean ok = dao.actualizarPrecio(id, precio);
        System.out.println(ok
                ? "Precio actualizado correctamente."
                : "No se encontró ningún producto con id=" + id);
    }

    /** Pide un id y elimina el producto del CSV. */
    private static void eliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        listarProductos();

        int id = leerEntero("\nID del producto a eliminar: ");

        System.out.print("¿Confirmas la eliminación? (s/n): ");
        String confirmacion = sc.nextLine().trim();

        if (!confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Eliminación cancelada.");
            return;
        }

        boolean ok = dao.eliminarPorId(id);
        System.out.println(ok
                ? "Producto eliminado correctamente."
                : "No se encontró ningún producto con id=" + id);
    }

    // =========================================================================
    // Inicialización
    // =========================================================================

    /**
     * Comprueba si el CSV está vacío y, si lo está, lo inicializa con datos
     * de ejemplo para que la app sea usable desde el primer arranque.
     */
    private static void inicializarSiVacio() {
        List<Producto> existentes = dao.listarTodos();
        if (existentes.isEmpty()) {
            System.out.println("CSV vacio detectado. Cargando datos de ejemplo...");
            dao.añadir(new Producto(1, "Manzana Fuji",    1.99,  150));
            dao.añadir(new Producto(2, "Leche Entera",    0.89,  300));
            dao.añadir(new Producto(3, "Pan de Molde",    1.35,   80));
            dao.añadir(new Producto(4, "Aceite de Oliva", 6.50,   45));
            dao.añadir(new Producto(5, "Queso Manchego",  12.90,  20));
            System.out.println("Datos de ejemplo cargados.");
        }
    }

    // =========================================================================
    // Helpers de entrada
    // =========================================================================

    /**
     * Lee un entero del teclado con reintento en caso de entrada inválida.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return el entero introducido
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    /**
     * Lee un double del teclado con reintento en caso de entrada inválida.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return el double introducido
     */
    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número decimal válido (usa punto o coma).");
            }
        }
    }
}
