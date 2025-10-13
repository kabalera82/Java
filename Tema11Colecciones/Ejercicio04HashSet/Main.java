package Tema11Colecciones.Ejercicio04HashSet;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Ejercicio de uso de la colección {@link HashSet} en Java.
 *
 * <p>Este programa gestiona un conjunto de países y permite realizar
 * diversas operaciones básicas mediante un menú por consola:</p>
 * <ul>
 *   <li>Insertar países (sin duplicados).</li>
 *   <li>Mostrar todos los países.</li>
 *   <li>Comprobar si un país existe.</li>
 *   <li>Eliminar un país.</li>
 *   <li>Vaciar el conjunto.</li>
 * </ul>
 *
 * <p>Características de {@link HashSet}:</p>
 * <ul>
 *   <li>No permite elementos duplicados.</li>
 *   <li>No mantiene ningún orden específico.</li>
 *   <li>Permite operaciones rápidas de inserción y búsqueda.</li>
 * </ul>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /** Conjunto que almacena los nombres de países sin duplicados. */
    private static final HashSet<String> paises = new HashSet<>();

    /** Escáner para leer la entrada del usuario por consola. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que ejecuta el menú del programa.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> insertarPais();
                case 2 -> mostrarPaises();
                case 3 -> buscarPais();
                case 4 -> eliminarPais();
                case 5 -> vaciarConjunto();
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
        System.out.println("\n--- MENÚ GESTIÓN DE PAÍSES (HashSet) ---");
        System.out.println("1. Insertar país");
        System.out.println("2. Mostrar países");
        System.out.println("3. Buscar país");
        System.out.println("4. Eliminar país");
        System.out.println("5. Vaciar conjunto");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un país en el conjunto. No se permiten duplicados.
     */
    private static void insertarPais() {
        System.out.print("Nombre del país a insertar: ");
        String pais = scanner.nextLine().trim();
        if (pais.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        if (paises.add(pais)) {
            System.out.println("País insertado correctamente.");
        } else {
            System.out.println("El país ya existe en el conjunto.");
        }
    }

    /**
     * Muestra todos los países almacenados en el conjunto.
     */
    private static void mostrarPaises() {
        if (paises.isEmpty()) {
            System.out.println("No hay países registrados.");
            return;
        }
        System.out.println("\nListado de países:");
        for (String pais : paises) {
            System.out.println("- " + pais);
        }
    }

    /**
     * Busca un país en el conjunto usando {@code contains()}.
     */
    private static void buscarPais() {
        System.out.print("Nombre del país a buscar: ");
        String pais = scanner.nextLine().trim();
        if (paises.contains(pais)) {
            System.out.println("El país '" + pais + "' está en el conjunto.");
        } else {
            System.out.println("El país '" + pais + "' no existe.");
        }
    }

    /**
     * Elimina un país del conjunto si existe.
     */
    private static void eliminarPais() {
        System.out.print("Nombre del país a eliminar: ");
        String pais = scanner.nextLine().trim();
        if (paises.remove(pais)) {
            System.out.println("País eliminado correctamente.");
        } else {
            System.out.println("El país no existe en el conjunto.");
        }
    }

    /**
     * Vacía todo el conjunto de países.
     */
    private static void vaciarConjunto() {
        if (paises.isEmpty()) {
            System.out.println("El conjunto ya está vacío.");
            return;
        }
        paises.clear();
        System.out.println("Conjunto vaciado correctamente.");
    }

    /**
     * Lee un número entero desde teclado de forma segura.
     *
     * @param mensaje texto mostrado antes de la lectura
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
}
