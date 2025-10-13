package Tema11Colecciones.Ejercicio02Extraccion;

import java.util.Arrays;

/**
 * Clase genérica que actúa como contenedor de un array.
 *
 * <p>Permite realizar operaciones de inserción al principio y al final,
 * extracción al principio y al final, y ordenación si los elementos
 * son comparables.</p>
 *
 * <p>La clase está parametrizada con un tipo genérico {@code Tabla}
 * que debe implementar {@link Comparable}, lo que permite ordenar
 * los elementos internamente mediante {@link Arrays#sort(Object[])}.</p>
 *
 * @param <Tabla> tipo de los elementos almacenados, debe ser comparable
 */
public class Contenedor<Tabla extends Comparable<Tabla>> {

    /** Array interno que almacena los objetos. */
    private Tabla[] objetos;

    /**
     * Constructor que recibe el array inicial.
     *
     * @param objetos array de elementos iniciales
     */
    public Contenedor(Tabla[] objetos) {
        this.objetos = objetos;
    }

    /**
     * Inserta un elemento al final del array.
     *
     * @param nuevo elemento a insertar
     */
    public void insertarAlFinal(Tabla nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        objetos[objetos.length - 1] = nuevo;
    }

    /**
     * Inserta un elemento al principio del array.
     *
     * @param nuevo elemento a insertar
     */
    public void insertarAlPrincipio(Tabla nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        System.arraycopy(objetos, 0, objetos, 1, objetos.length - 1);
        objetos[0] = nuevo;
    }

    /**
     * Extrae y devuelve el último elemento del array, reduciendo su tamaño.
     *
     * @return elemento extraído del final
     */
    public Tabla extraerDatosFinal() {
        Tabla extraido = objetos[objetos.length - 1];
        objetos = Arrays.copyOf(objetos, objetos.length - 1);
        return extraido;
    }

    /**
     * Extrae y devuelve el primer elemento del array, reduciendo su tamaño.
     *
     * @return elemento extraído del inicio
     */
    public Tabla extraerDatosInicio() {
        Tabla extraido = objetos[0];
        objetos = Arrays.copyOfRange(objetos, 1, objetos.length);
        return extraido;
    }

    /**
     * Ordena el array internamente usando {@link Arrays#sort(Object[])}.
     */
    public void ordenar() {
        Arrays.sort(objetos);
    }

    /**
     * Devuelve una representación en cadena del array interno.
     *
     * @return representación en cadena de los elementos
     */
    @Override
    public String toString() {
        return Arrays.toString(objetos);
    }
}
