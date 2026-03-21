/**
 * Ejercicio 03 - bloque finally
 *
 * El bloque finally se ejecuta SIEMPRE, haya excepcion o no.
 * Su uso tipico es liberar recursos: cerrar ficheros, conexiones, etc.
 *
 * Orden de ejecucion:
 *   1. try
 *   2. catch (solo si hay excepcion)
 *   3. finally (siempre)
 */
public class Ejercicio03Finally {

    public static void main(String[] args) {

        System.out.println("--- Caso 1: sin excepcion ---");
        try {
            System.out.println("Dentro del try");
            int resultado = 10 / 2;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Catch (no se ejecuta)");
        } finally {
            System.out.println("Finally: esto siempre se ejecuta");
        }

        System.out.println("\n--- Caso 2: con excepcion ---");
        try {
            System.out.println("Dentro del try");
            int resultado = 10 / 0; // lanza excepcion
            System.out.println("Esta linea no se ejecuta");
        } catch (ArithmeticException e) {
            System.out.println("Catch: " + e.getMessage());
        } finally {
            System.out.println("Finally: esto siempre se ejecuta");
        }

        System.out.println("\n--- Caso 3: simular cierre de recurso ---");
        String recurso = null;
        try {
            recurso = "conexion_abierta";
            System.out.println("Usando recurso: " + recurso);
            if (recurso != null) throw new RuntimeException("Fallo durante el uso");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            recurso = null;
            System.out.println("Recurso cerrado en finally: " + recurso);
        }
    }
}
