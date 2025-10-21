package Tema99EjerciciosMultiples.Alumnos;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Curso {

    private static final List<Alumno> alumnos = new ArrayList<>(List.of(
            new Alumno("María", "Pérez López", "56566759R", 8.05),
            new Alumno("Carlos", "García Ruiz", "23894412M", 6.75),
            new Alumno("Lucía", "Fernández Soto", "77451233A", 9.20),
            new Alumno("Laura", "Jiménez Díaz", "88766345C", 9.85),
            new Alumno("Ana", "Suarez Perez", "66545613L", 6.10),
            new Alumno("Pablo", "Martínez Gómez", "11234589T", 4.80),
            new Alumno("Ana", "Rodríguez León", "66549213L", 7.10),
            new Alumno("David", "Sánchez Ortega", "99831572J", 5.30),
            new Alumno("Jorge", "Navarro Torres", "22984577V", 3.95),
            new Alumno("Claudia", "Morales Vega", "33214599B", 6.40),
            new Alumno("Sergio", "López Martín", "77123384K", 7.90)
    ));

    //Métodos
    public static void listarAlumnos() {
        alumnos.forEach(System.out::println);
    }


    public static void addAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Inserte los apellidos : ");
        String apellidos = sc.nextLine();
        System.out.println("Inserte el DNI: ");
        String DNI = sc.nextLine();
        System.out.println("Inserte la nota: ");
        double notaNum = sc.nextDouble();
        String notaStr;
        if (notaNum < 5) {
            notaStr = "Suspenso";
        } else if (notaNum < 7) {
            notaStr = "Aprobado";
        } else if (notaNum < 8) {
            notaStr = "Bien";
        } else if (notaNum < 9) {
            notaStr = "Notable";
        } else if (notaNum < 10) {
            notaStr = "Sobresaliente";
        } else {
            notaStr = "Matricula Honor";
        }
        alumnos.add(new Alumno(nombre, apellidos, DNI, notaNum));
    }

    public static void deleteAlunmno() {
        System.out.println("Inserte el DNI: ");
        Scanner sc = new Scanner(System.in);
        String DNI = sc.nextLine();
        for (Alumno a : alumnos) {
            if (a.getDNI().equalsIgnoreCase(DNI)) {
                alumnos.remove(a);
                System.out.println("Alumno: " + DNI + " eliminado.");
                return;
            }
        }
    }


    public static void modifiAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el DNI del alumno que deseas modificar: ");
        String dniBuscado = sc.nextLine();

        Alumno alumnoEncontrado = null;

        for (Alumno a : alumnos) {
            if (a.getDNI().equalsIgnoreCase(dniBuscado)) {
                alumnoEncontrado = a;
                break;
            }
        }

        if (alumnoEncontrado == null) {
            System.out.println("No se encontró ningún alumno con ese DNI.");
            return;
        }

        boolean salir = false;
        do {
            try {
                System.out.println("""
                    ========== MENÚ MODIFICAR ALUMNO ==========
                    1. Cambiar Nombre
                    2. Cambiar Apellidos
                    3. Cambiar DNI
                    4. Cambiar Nota
                    5. Salir
                    ============================================
                    """);
                System.out.print("Selecciona una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Introduce el nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        alumnoEncontrado.setNombre(nuevoNombre);
                        System.out.println(" Nombre cambiado correctamente.");
                    }
                    case 2 -> {
                        System.out.print("Introduce los nuevos apellidos: ");
                        String nuevosApellidos = sc.nextLine();
                        alumnoEncontrado.setApellidos(nuevosApellidos);
                        System.out.println(" Apellidos cambiados correctamente.");
                    }
                    case 3 -> {
                        System.out.print("Introduce el nuevo DNI: ");
                        String nuevoDni = sc.nextLine();
                        alumnoEncontrado.setDNI(nuevoDni);
                        System.out.println(" DNI cambiado correctamente.");
                    }
                    case 4 -> {
                        System.out.print("Introduce la nueva nota: ");
                        double nuevaNota = sc.nextDouble();
                        sc.nextLine(); // limpiar buffer
                        alumnoEncontrado.setNotaNum(nuevaNota); //  recalcula notaStr automáticamente
                        System.out.println(" Nota actualizada a " + alumnoEncontrado.getNotaNum()
                                + " (" + alumnoEncontrado.getNotaStr() + ")");
                    }
                    case 5 -> {
                        salir = true;
                        System.out.println("Salir");
                    }
                    default -> System.out.println(" Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        } while (!salir);
    }


    public static void estadisticas() {
        System.out.println("=== ESTADÍSTICAS DE NOTAS ===");

        int totalAlumnos = alumnos.size();
        int totalPresentados = 0;

        // Contadores
        int noPresentado = 0, suspensos = 0, aprobados = 0, notables = 0, sobresalientes = 0, matriculas = 0;

        // Recorremos la lista
        for (Alumno a : alumnos) {
            String nota = a.getNotaStr();

            switch (nota.toLowerCase()) {
                case "no presentado" -> noPresentado++;
                case "suspenso" -> {
                    suspensos++;
                    totalPresentados++;
                }
                case "aprobado" -> {
                    aprobados++;
                    totalPresentados++;
                }
                case "notable" -> {
                    notables++;
                    totalPresentados++;
                }
                case "sobresaliente" -> {
                    sobresalientes++;
                    totalPresentados++;
                }
                case "matrícula de honor" -> {
                    matriculas++;
                    totalPresentados++;
                }
            }
        }

        // Mostrar resultados
        System.out.println("No presentado:    " + noPresentado);
        System.out.println("Suspensos:        " + suspensos);
        System.out.println("Aprobados:        " + aprobados);
        System.out.println("Notables:         " + notables);
        System.out.println("Sobresalientes:   " + sobresalientes);
        System.out.println("Matrículas:       " + matriculas);
        System.out.println("------------------------------------");
    }
}




