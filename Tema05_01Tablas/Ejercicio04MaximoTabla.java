package Tema05_01Tablas;

/**
 * Tema 5: [Conceptos Básicos]
 * <p>
 * Ejercicio 04: [Valor Maximo de tabla]
 *
 * @author kabadev
 */
public class Ejercicio04MaximoTabla {
    /*
     * Diseñar la función: int maximo(int t[]), que devuelva el máximo valor contenido en la tabla t
     */


    public static void main(String[] args) {
        // Definir un array de enteros con algunos valores
        int[] t = {1, 2, 3, 4, 5, 66, 7, 8, 9, 10};

        // Llamar a la función maximo para encontrar el valor máximo en el array
        int max = maximo(t);

        // Imprimir el valor máximo encontrado
        System.out.println("El valor máximo de la tabla es: " + max);
    }

    /*
     * Función que devuelve el valor máximo contenido en un array de enteros
     * Array de enteros
     * El valor máximo en el array
     */
    public static int maximo(int[] t) {
        // Inicializar la variable max con el primer elemento del array
        int max = t[0];

        // Recorrer todos los elementos del array
        for (int e : t) {
            // Si el elemento actual es mayor que max, actualizar max
            if (e > max) {
                max = e;
            }
        }

        // Devolver el valor máximo encontrado
        return max;
    }
}
