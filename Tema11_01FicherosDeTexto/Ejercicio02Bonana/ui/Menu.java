package Tema11_01FicherosDeTexto.Ejercicio02Bonana.ui;

import Tema11_01FicherosDeTexto.Ejercicio02Bonana.model.Frutas;
import Tema11_01FicherosDeTexto.Ejercicio02Bonana.persistence.FrutaFileDao;
import Tema11_01FicherosDeTexto.Ejercicio02Bonana.servicio.ServicioFrutas;

import java.util.Scanner;

/**
 * Clase de consola que gestiona la interacción con el usuario.
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final ServicioFrutas servicio = new ServicioFrutas();
    private static final FrutaFileDao dao = new FrutaFileDao();

    public static void main(String[] args) {
        frutitasJoseManuel();
    }

    /** Bucle principal del menú */
    public static void frutitasJoseManuel() {
        boolean salir = false;
        do {
            try {
                mostrarMenu();
                int opcion = leerEntero();
                switch (opcion) {
                    case 1 -> addFruta();
                    case 2 -> listFruta();
                    case 3 -> exportFruta();
                    case 4 -> importFruta();
                    case 5 -> deleteFruta();
                    case 6 -> {
                        salir = true;
                        sc.close();
                        System.out.println("👋 ¡Gracias por usar Frutitas José Manuel!");
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        } while (!salir);
    }

    private static void mostrarMenu() {
        System.out.println("""
                ========== MENÚ FRUTITAS ==========
                1. Añadir fruta
                2. Listar frutas
                3. Exportar frutas a archivo
                4. Importar frutas desde archivo
                5. Eliminar fruta por ID
                6. Salir
                ===================================
                """);
        System.out.print("Selecciona una opción: ");
    }

    private static void addFruta() {
        System.out.println("\n➕ Añadir nueva fruta:");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Precio/kg: ");
        double precio = leerDouble();

        System.out.print("Stock (kg): ");
        int stock = leerEntero();

        Frutas fruta = new Frutas(nombre, precio, stock);
        servicio.addFruta(fruta);
    }

    private static void listFruta() {
        servicio.listFruta();
    }

    private static void exportFruta() {
        dao.guardarFrutas(servicio.getFrutas());
    }

    private static void importFruta() {
        servicio.getFrutas().clear();
        servicio.getFrutas().addAll(dao.listadoFrutas());
        System.out.println("📂 Frutas importadas correctamente.");
    }

    private static void deleteFruta() {
        System.out.print("ID de la fruta a eliminar: ");
        int id = leerEntero();
        boolean eliminado = servicio.getFrutas().removeIf(f -> f.getId() == id);
        if (eliminado)
            System.out.println("🗑️ Fruta eliminada correctamente.");
        else
            System.out.println("❌ No se encontró ninguna fruta con ese ID.");
    }

    // Métodos auxiliares
    private static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❌ Introduce un número decimal válido: ");
            }
        }
    }

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❌ Introduce un número entero válido: ");
            }
        }
    }
}
