package Tema01ConceptosBasicos;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 05: [Comprobaciones Booleanas]
 *
 * @author kabadev
 */

import java.util.Scanner;

public class Ejercicio05 {
    /*
     Diseña un programa que indique si podemos salir a la calle, tener en cuenta
     si está lloviendo y si hemos terminado nuestras tareas.
     */
    public static void main(String[] args) {
        /*
              Diseña un programa que indique si podemos salir a la calle, tener en cuenta
        si está lloviendo y si hemos terminado nuestras tareas.
         */

        // usar operadores lógicos tras recibir la info.
        boolean llueve, tarea, irCalle;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Llueve? (true/false): ");
        llueve = sc.nextBoolean();
        System.out.println("¿Tarea finalizada? (true/false): ");
        tarea = sc.nextBoolean();
        irCalle = !llueve && tarea;
        System.out.println("¿Puedes ir a la calle?: " + irCalle);
        sc.close();
    }
}
