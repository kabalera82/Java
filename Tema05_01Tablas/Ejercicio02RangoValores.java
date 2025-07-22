package Tema05_01Tablas;

/**
 * Tema 1: [Conceptos Básicos]
 * <p>
 * Ejercicio 02: [Entrada y Salida de datos por Consola]
 *
 * @author kabadev
 */
public class Ejercicio02RangoValores {

    /*
     * Crea una tabla de longitud 10 que se inicializará con valores aleatorios entre 1 y 100.
     * Mostrar la suma de todos los números que se guardan en la tabla.
     *
     */
    public static void main(String[] args) {
        int[] valores; // DECLARO EL ARRAY
        valores = new int[10]; // LE ASIGNO SU TAMAÑO EN MEMORIA

        // VAMOS A RECORRER LA TABLA PARA INICIALIZAR CON VALORES ALEATORIOS.
        //CUANDO SE MODIFICAN LOS ELEMENTOS DE UNA TABLA NO PODEMOS USAR UN FOR-EACH.

        for (int i = 0; i < valores.length; i++) {
            valores[i] = (int) (Math.random() * 100); // Genera un número aleatorio entre 0 y 99
        }

        //AHORA RECORREMOS LA TABLA PARA CALCULAR LA SUMA DE SUS ELEMENTOS.

        int suma = 0;

        // Utiliza un bucle for-each para iterar sobre cada elemento en el array 'valores'
        for (int valor : valores) {
            // Suma el valor actual al total acumulado en 'suma'
            suma += valor;
        }

        System.out.println("La suma de los valores es: " + suma);
    }
}
