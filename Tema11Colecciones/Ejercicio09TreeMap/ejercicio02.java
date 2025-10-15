package Tema11Colecciones.Ejercicio09TreeMap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Ejercicio de uso de TreeMap en Java.
 *
 * Se gestiona un ranking de jugadores ordenado automáticamente por puntuación.
 *
 * - La clave del TreeMap es la puntuación (Integer).
 * - El valor es el nombre del jugador (String).
 * - Al insertar jugadores, el TreeMap los mantiene ordenados de menor a mayor puntuación.
 *
 * El programa permite mediante un menú:
 *  1. Insertar jugador y puntuación.
 *  2. Mostrar ranking de menor a mayor.
 *  3. Mostrar ranking de mayor a menor.
 *  4. Buscar jugador por puntuación.
 *  5. Eliminar jugador por puntuación.
 *  0. Salir.
 */
public class ejercicio02 {

    /** Mapa ordenado automáticamente por puntuación (clave). */
    private static final TreeMap<Integer, String> ranking = new TreeMap<>();

    /** Escáner para leer entradas por teclado. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que muestra el menú y gestiona las opciones del usuario.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> insertarJugador();
                case 2 -> mostrarRankingAscendente();
                case 3 -> mostrarRankingDescendente();
                case 4 -> buscarPorPuntuacion();
                case 5 -> eliminarPorPuntuacion();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra el menú principal por consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- RANKING DE JUGADORES (TreeMap) ---");
        System.out.println("1. Insertar jugador");
        System.out.println("2. Mostrar ranking (menor a mayor)");
        System.out.println("3. Mostrar ranking (mayor a menor)");
        System.out.println("4. Buscar jugador por puntuación");
        System.out.println("5. Eliminar jugador por puntuación");
        System.out.println("0. Salir");
    }

    /**
     * Inserta un nuevo jugador con su puntuación en el ranking.
     * Si la puntuación ya existe, se sobrescribe el nombre del jugador.
     */
    private static void insertarJugador() {
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        int puntuacion = leerEntero("Puntuación: ");
        ranking.put(puntuacion, nombre);
        System.out.println("Jugador insertado correctamente.");
    }

    /**
     * Muestra el ranking ordenado de menor a mayor puntuación.
     */
    private static void mostrarRankingAscendente() {
        if (ranking.isEmpty()) {
            System.out.println("No hay jugadores en el ranking.");
            return;
        }
        System.out.println("\n--- Ranking Ascendente ---");
        for (Map.Entry<Integer, String> entry : ranking.entrySet()) {
            System.out.println(entry.getKey() + " puntos → " + entry.getValue());
        }
    }

    /**
     * Muestra el ranking ordenado de mayor a menor puntuación.
     */
    private static void mostrarRankingDescendente() {
        if (ranking.isEmpty()) {
            System.out.println("No hay jugadores en el ranking.");
            return;
        }
        System.out.println("\n--- Ranking Descendente ---");
        for (Map.Entry<Integer, String> entry : ranking.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " puntos → " + entry.getValue());
        }
    }

    /**
     * Busca un jugador por puntuación.
     * Si la puntuación existe, muestra el jugador asociado.
     */
    private static void buscarPorPuntuacion() {
        int puntuacion = leerEntero("Introduzca la puntuación a buscar: ");
        if (ranking.containsKey(puntuacion)) {
            System.out.println("Puntuación " + puntuacion + " → " + ranking.get(puntuacion));
        } else {
            System.out.println("No hay ningún jugador con esa puntuación.");
        }
    }

    /**
     * Elimina un jugador por puntuación si existe en el ranking.
     */
    private static void eliminarPorPuntuacion() {
        int puntuacion = leerEntero("Introduzca la puntuación a eliminar: ");
        if (ranking.remove(puntuacion) != null) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("No existe ningún jugador con esa puntuación.");
        }
    }

    /**
     * Lee un número entero desde teclado de forma segura.
     *
     * @param mensaje texto que se mostrará antes de la lectura
     * @return número entero válido introducido por el usuario
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

