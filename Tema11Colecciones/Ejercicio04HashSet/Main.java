package Tema11Colecciones.Ejercicio04HashSet;

import java.util.HashSet;

/**
 * Clase principal de ejemplo para trabajar con la colección {@link HashSet}.
 *
 * <p>Este programa crea un conjunto de países y demuestra las siguientes
 * operaciones básicas:</p>
 * <ul>
 *   <li>Creación de un {@link HashSet}.</li>
 *   <li>Inserción de elementos con {@code add()}.</li>
 *   <li>Visualización del contenido del conjunto.</li>
 *   <li>Búsqueda de un elemento con {@code contains()}.</li>
 * </ul>
 *
 * <p>Nota: {@link HashSet} no garantiza orden en los elementos,
 * y tampoco permite duplicados.</p>
 *
 * @author Marcos
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de línea de comandos (no se usan en este ejemplo).
     */
    public static void main(String[] args) {

        // Creamos un HashSet de tipo String.
        // HashSet es una colección que no admite duplicados y no mantiene un orden definido.
        HashSet<String> paises = new HashSet<>();

        // Agregamos elementos a la colección usando el método add().
        paises.add("España");
        paises.add("Italia");
        paises.add("Portugal");

        // Mostramos el contenido del HashSet.
        // El orden de los elementos puede variar porque HashSet no mantiene posiciones.
        System.out.println("Listado: " + paises);

        // Buscamos un elemento específico dentro del conjunto.
        // contains() devuelve true si el elemento existe, false en caso contrario.
        Boolean comprobacion = paises.contains("España");

        // Imprimimos el resultado de la comprobación.
        System.out.println("¿Está España en el conjunto?: " + comprobacion);
    }
}
