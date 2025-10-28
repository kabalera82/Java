package Tema12AcesoDatos.ejercicio03.src.main.java;

import java.util.Scanner;

import static Tema12AcesoDatos.ejercicio03.src.main.java.LeyendoCsv.*;


public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        boolean salir = false;
        do {
            try {
                System.out.println("""
                        ========== MENÚ FRUTAS ==========
                        1. Escribiendo.
                        2. Leyendo.
                        3. Modificar Alumno.
                        4. Listar Alumnos.
                        5. Listar Alumnos por Nota.
                        6. Salir.
                        =================================
                        """);
                System.out.print("Selecciona una opción: ");
                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> archivos();
                    case 2 -> leyendo();
                    case 6 -> {
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