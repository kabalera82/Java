package Tema99EjerciciosMultiples.Alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Tema99EjerciciosMultiples.Alumnos.Curso.*;

/**
 * Implementar un programa para gestión de una clase sin suponer ningún número de alumnos máximo.
 * Para ello se utilizará una lista.
 * <p>
 * Para cada alumno se almacenará la siguiente información: Nombre, Apellidos, DNI, Nota en número, y Nota en letra.
 * Crea la clase Alumno.
 * Implementa la clase Curso cuyo atributo es una lista de tipo Alumno.
 * <p>
 * El programa permitirá las siguientes operaciones, en un menú de opciones:
 * <p>
 * Añadir nuevo alumno.
 * Borrar alumno ya existente (dando su posición en la lista y/o su nombre, como se prefiera).ELIJO DNI mas cómodo
 * Cambiar algún dato de algún alumno: Modificar sus notas...
 * Mostrar todos los datos de todos los alumnos (uno a uno, por ejemplo).
 * Cambiar la nota en letra de cada alumno según su nota numérica: No presentado (<0), Suspenso (<5), Aprobado (<7), Notable (<9), Sobresaliente (<10) y Matrícula de Honor (10).
 * Mostrar el total de alumnos de cada nota (Suspenso, Aprobado...) y el porcentaje que suponen respecto al total de alumnos en la lista y respecto al total de alumnos presentados (excluyendo los No Presentados).
 */
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
                        1. Añadir nuevo Alumno.
                        2. Borrar alumno ya existente por DNI.
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
                    case 1 -> addAlumno();
                    case 2 -> deleteAlunmno();
                    case 3 -> modifiAlumno();
                    case 4 -> listarAlumnos();
                    case 5-> estadisticas();
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
