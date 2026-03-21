import java.util.Scanner;

/**
 * Ejercicio 06 - practica integradora
 *
 * Sistema de registro de alumnos con validacion completa usando excepciones.
 * Combina: excepciones personalizadas, try-catch-finally, throw/throws,
 * validacion de entrada del usuario.
 */

class NotaFueraDeRangoException extends RuntimeException {
    public NotaFueraDeRangoException(double nota) {
        super("Nota fuera de rango: " + nota + ". Debe estar entre 0 y 10.");
    }
}

class NombreVacioException extends IllegalArgumentException {
    public NombreVacioException() {
        super("El nombre no puede estar vacio.");
    }
}

class Alumno {
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        if (nombre == null || nombre.isBlank()) {
            throw new NombreVacioException();
        }
        if (nota < 0 || nota > 10) {
            throw new NotaFueraDeRangoException(nota);
        }
        this.nombre = nombre.trim();
        this.nota = nota;
    }

    public String getCalificacion() {
        if (nota >= 9)       return "Sobresaliente";
        else if (nota >= 7)  return "Notable";
        else if (nota >= 5)  return "Aprobado";
        else                 return "Suspenso";
    }

    @Override
    public String toString() {
        return nombre + " — " + nota + " (" + getCalificacion() + ")";
    }
}

public class Ejercicio06Practica {

    public static Alumno crearAlumnoDesdeConsola(Scanner sc) throws Exception {
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Nota (0-10): ");
        String notaStr = sc.nextLine();

        // Puede lanzar NumberFormatException
        double nota = Double.parseDouble(notaStr);

        // Puede lanzar NombreVacioException o NotaFueraDeRangoException
        return new Alumno(nombre, nota);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de alumno ===\n");

        Alumno alumno = null;
        boolean registrado = false;

        while (!registrado) {
            try {
                alumno = crearAlumnoDesdeConsola(sc);
                registrado = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: la nota debe ser un numero decimal. Ejemplo: 7.5\n");

            } catch (NotaFueraDeRangoException | NombreVacioException e) {
                System.out.println("Error de validacion: " + e.getMessage() + "\n");

            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage() + "\n");

            } finally {
                // Se ejecuta en cada iteracion del bucle
                if (!registrado) {
                    System.out.println("Vuelve a intentarlo.\n");
                }
            }
        }

        System.out.println("\nAlumno registrado: " + alumno);
        sc.close();
    }
}
