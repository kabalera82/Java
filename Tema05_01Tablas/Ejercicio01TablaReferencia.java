package Tema05_01Tablas;
/**
 * Tema 5: [Tablas]
 * <p>
 * Ejercicio 01: [Creación de tablas y registros]
 *
 * @author kabadev
 */

import java.util.Arrays;

public class Ejercicio01TablaReferencia {
    public static void main(String[] args) {

        // Inicializamos el array con valores específicos.
        int[] tablaUno = new int[5];
        tablaUno[0] = 0;
        tablaUno[1] = 1;
        tablaUno[2] = 2;
        tablaUno[3] = 3;
        tablaUno[4] = 4;
        double[] tablaDos = new double[5];
        tablaDos[4] = 4;
        tablaDos[3] = 3;
        tablaDos[2] = 2;
        tablaDos[1] = 1;
        tablaDos[0] = 0;
        boolean[] tablaTres = new boolean[5];
        tablaTres[0] = true;
        tablaTres[1] = true;
        tablaTres[2] = true;
        tablaTres[3] = true;
        tablaTres[4] = true;


        // Mostramos la referencia de la tabla.
        System.out.println("Referencia de la tablaUno: " + tablaUno);
        System.out.println("Referencia de la tablaDos: " + tablaDos);
        System.out.println("Referencia de la tablaTres: " + tablaTres);

        // Mostramos el contenido de la tabla.
        System.out.println("Contenido de la tablaUno: " + Arrays.toString(tablaUno));
        System.out.println("Contenido de la tablaDos: " + Arrays.toString(tablaDos));
        System.out.println("Contenido de la tablaTres: " + Arrays.toString(tablaTres));

        // Modificamos el contenido de la tabla.
        tablaUno[0] = 5;
        tablaUno[1] = 6;
        tablaUno[2] = 7;
        tablaUno[3] = 8;
        tablaUno[4] = 9;
        tablaDos[0] = 5;
        tablaDos[1] = 6;
        tablaDos[2] = 7;
        tablaDos[3] = 8;
        tablaDos[4] = 9;
        tablaTres[0] = false;
        tablaTres[2] = false;
        tablaTres[4] = false;

        // Mostramos el contenido de la tabla.
        System.out.println("Contenido de la tablaUno: " + Arrays.toString(tablaUno));
        System.out.println("Contenido de la tablaDos: " + Arrays.toString(tablaDos));
        System.out.println("Contenido de la tablaTres: " + Arrays.toString(tablaTres));


    }
}
