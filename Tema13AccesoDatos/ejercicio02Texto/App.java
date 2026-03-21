package Tema12AcesoDatos.ejercicio02Texto;

import Tema12AcesoDatos.ejercicio02Texto.dao.Producto;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Tema12AcesoDatos.ejercicio02Texto.control.ControlProducto.*;


public class App {
    private static final Path RUTA = Paths.get ("data","productos.txt");
    private static final List <Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        importTxt(RUTA, productos);

        boolean salir = false;
        do {
            try {
                System.out.println("""
                        
                        ========== MENÚ FRUTAS ==========
                        1. Listar todos los Articulos.
                        2. Añadir Articulos.
                        3. Exportar Articulos.
                        4. Restaurar a Inicio.

                        0. Salir.
                        =================================
                        """);
                System.out.print("Selecciona una opción: ");
                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> listantoFruta(productos);
                    case 2 -> anhadeFruta(productos);
                    case 3 -> exportTxt(RUTA, productos);
                    case 4 -> reset(RUTA,productos);

                    case 0 -> {
                        salir = true;
                        sc.close();
                        System.out.println("¡Saliendo -----!");
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!salir);
    }

}
