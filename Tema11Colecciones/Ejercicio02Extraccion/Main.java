package Tema11Colecciones.Ejercicio02Extraccion;

/**
 * Clase principal para probar la funcionalidad de la clase {@link Contenedor}.
 *
 * <p>Se realizan operaciones de inserción, extracción y ordenación sobre un
 * contenedor de cadenas.</p>
 */
public class Main {

    public static void main(String[] args) {

        // Creamos un contenedor de Strings
        Contenedor<String> contenedor = new Contenedor<>(new String[0]);

        System.out.println("Estado inicial: " + contenedor);

        // Insertar al final
        contenedor.insertarAlFinal("perro");
        contenedor.insertarAlFinal("gato");
        contenedor.insertarAlFinal("caballo");
        System.out.println("Después de insertar al final: " + contenedor);

        // Insertar al principio
        contenedor.insertarAlPrincipio("tigre");
        contenedor.insertarAlPrincipio("león");
        System.out.println("Después de insertar al principio: " + contenedor);

        // Extraer del final
        String ultimo = contenedor.extraerDatosFinal();
        System.out.println("Extraído del final: " + ultimo);
        System.out.println("Después de extracción final: " + contenedor);

        // Extraer del principio
        String primero = contenedor.extraerDatosInicio();
        System.out.println("Extraído del principio: " + primero);
        System.out.println("Después de extracción inicial: " + contenedor);

        // Ordenar
        contenedor.ordenar();
        System.out.println("Después de ordenar: " + contenedor);
    }
}
