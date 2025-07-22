package Tema05_01Tablas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio08GestionResultados {

    /**
     * Diseñar una aplicación para gestionar un campeonato de programación,
     * donde se introduce la puntuación (enteros) obtenidos por 5 programadores,
     * conforme van terminando su prueba. La aplicación debe mostrar las puntuaciones ordenadas de los 5 participantes.
     * En ocasiones, cuando finalizan los 5 participantes anteriores, se suman al campeonato programadores de exhibición,
     * cuyos puntos se incluyen con el resto. La forma de especificar
     * que no intervienen más programadores de exhibición es introducir como puntuación un −1.
     * La aplicación debe mostrar, finalmente, los puntos ordenados de todos los participantes.
     * <p>
     * SOLUCIÓN:
     * Leeremos las puntuaciones en el orden en el que terminen los participantes y
     * las ordenaremos. A continuación, realizaremos una inserción ordenada (por
     * cada programador de exhibición). Una mala idea sería insertar al final la
     * puntuación de los programadores de exhibición y volver a ordenar, ya que
     * esto es muy costoso en tiempo. Es más eficiente una inserción ordenada.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        ArrayList<Integer> puntuaciones = new ArrayList<>(); // Crear una lista para almacenar las puntuaciones

        // Leer puntuaciones de los 5 programadores iniciales
        System.out.println("Introduce las puntuaciones de los 5 programadores:");
        for (int i = 0; i < 5; i++) { // Bucle para leer las puntuaciones de los 5 programadores
            System.out.print("Puntuación del programador " + (i + 1) + ": ");
            int puntuacion = scanner.nextInt(); // Leer la puntuación del programador
            puntuaciones.add(puntuacion); // Añadir la puntuación a la lista
        }

        // Ordenar las puntuaciones iniciales
        Collections.sort(puntuaciones); // Ordenar la lista de puntuaciones
        System.out.println("Puntuaciones ordenadas de los 5 participantes: " + puntuaciones); // Mostrar las puntuaciones ordenadas

        // Leer puntuaciones de los programadores de exhibición
        System.out.println("Introduce las puntuaciones de los programadores de exhibición (introduce -1 para finalizar):");
        while (true) { // Bucle para leer las puntuaciones de los programadores de exhibición
            System.out.print("Puntuación del programador de exhibición: ");
            int puntuacion = scanner.nextInt(); // Leer la puntuación del programador de exhibición
            if (puntuacion == -1) { // Si la puntuación es -1, salir del bucle
                break;
            }
            puntuaciones.add(puntuacion); // Añadir la puntuación a la lista
        }

        // Ordenar las puntuaciones finales
        Collections.sort(puntuaciones); // Ordenar la lista de puntuaciones finales

        // Mostrar las puntuaciones finales ordenadas
        System.out.println("Puntuaciones ordenadas de todos los participantes: " + puntuaciones); // Mostrar las puntuaciones finales ordenadas
    }
}
