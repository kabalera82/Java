package Tema11Colecciones.Ejercicio01Arrays.Ejercicio01Inicializar;

import java.util.Arrays;
import java.util.List;

/**
 * Inicializa y manipula Arrays
 *
 * Clase del paquete java.util utilizada para almacenar elementos de tipo homogéneo en estructuras de tamaño fijo.
 *
 * Tamaño Fijo: Su tamaño se define al crear el array y no puede cambiar durante la ejecución.
 * Homogeneidad: Todos los elementos deben ser del mismo tipo de dato.
 * Indexación: Cada elemento se identifica por su posición (índice) que comienza en 0.
 *
 * <p>
 *     <h3>Métodos y propiedades más comunes de Arrays</h3>
 *     <ul>
 *         <li>
 *             length -> Propiedad (no método) que devuelve el tamaño del array.<br>
 *             Ej: <code>num.length</code>
 *         </li>
 *         <li>
 *             Arrays.toString(array) -> Convierte el array en una cadena legible.<br>
 *             Ej: <code>Arrays.toString(num)</code>
 *         </li>
 *         <li>
 *             Arrays.sort(array) -> Ordena el array en orden ascendente.<br>
 *             Ej: <code>Arrays.sort(num)</code>
 *         </li>
 *         <li>
 *             Arrays.copyOf(array, nuevoTamaño) -> Crea una copia con nuevo tamaño.<br>
 *             Ej: <code>Arrays.copyOf(num, num.length + 1)</code>
 *         </li>
 *         <li>
 *             Arrays.equals(array1, array2) -> Compara si dos arrays son iguales en tamaño y contenido.<br>
 *             Ej: <code>Arrays.equals(num, numeros)</code>
 *         </li>
 *         <li>
 *             Arrays.fill(array, valor) -> Rellena todo el array con un mismo valor.<br>
 *             Ej: <code>Arrays.fill(num, 5)</code>
 *         </li>
 *         <li>
 *             Arrays.binarySearch(array, valor) -> Busca un valor en un array ORDENADO y devuelve su índice (o negativo si no está).<br>
 *             Ej: <code>Arrays.binarySearch(num, 5)</code>
 *         </li>
 *         <li>
 *             Arrays.asList(array) -> Convierte un array de objetos en una lista (List).<br>
 *             Ej: <code>Arrays.asList(nombres)</code>
 *         </li>
 *         <li>
 *             Arrays.stream(array) -> Crea un flujo (Stream) del array, útil para recorrerlo o aplicar operaciones funcionales.<br>
 *             Ej: <code>Arrays.stream(num).forEach(System.out::println)</code>
 *         </li>
 *     </ul>
 * </p>
 */

public class Inicializar {
    public static void main(String[] args) {

        int [] num = {1,2,3,4,5,6,7,8,9};
        String [] abc = {"abril", "bebe","babosa", "caracol", "xataka", "biberon","mama","mimar", "l"};

        /**
         * - - - Bucle for Clasico - - -
         */
        int[] pares = new int[10];
        for (int i = 0; i < pares.length; i++) {
            System.out.println("for" + pares[i]);
        }

        /**
         * - - - Bucle for-each - - -
         */
        for (int p : pares) {
            System.out.println("for-each:" + p);
        }

        /**
         * - - - While - - -
         */
        int i = 0;
        while (i < pares.length) {
            System.out.println(i++);
        }

        /**
         * Bucle con Streams
         */
        Arrays.stream(pares).forEach(numero -> System.out.println("Streams: "));

        /**
         * Arrays.toString(array)
         */
        System.out.println(Arrays.toString(num));

        /**
         * Arrays.sort(array)
         */
        Arrays.sort(num);
        Arrays.sort(abc);
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(abc));

        /**
         * Arrays.copyOf(a,10)
         */
        int [] numeros = Arrays.copyOf(num, num.length+1);
        numeros[numeros.length - 1] = 10;
        System.out.println(Arrays.toString(numeros));

        /**
         * Arrays.equals(a,b)
         */
        System.out.println("¿son iguales?: " + Arrays.equals(num,numeros));

        /**
         * Arrays.fill(array, valor)
         */
        int [] numeros2 = numeros;
        System.out.println(Arrays.toString(numeros2));
        Arrays.fill(numeros2, 5);
        System.out.println(Arrays.toString(numeros2));

        /**
         * Arrays.binarySearch(array, valor)
         */
        int posicion = Arrays.binarySearch(num, 5);
        System.out.println(Arrays.toString(num));
        System.out.println("Posicion: " + posicion);

        /**
         * Arrays.asList(array)
         */
        String[] nombres = { "Ana", "Luis", "Eva"};
        List<String> lista = Arrays.asList(nombres);
        System.out.println(lista);
    }
}
