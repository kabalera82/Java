package Tema11Colecciones.Ejercicio01;

import java.util.Arrays;

/**
 * Implementar un método genérico estático que realice la insercion
 * de un objeto al dinal de una tabla, ambos del mismo tipo genérico, que se pasan
 * como parámetros. Devuelve una nueva tabla con el resultado de la inserción.
 */
public class Main {

    static <Objeto> Objeto [] insertaObjeto (Objeto elem, Objeto[] tabla) {
        Objeto[] nuevaTabla = Arrays.copyOf (tabla, tabla.length + 1);
        nuevaTabla[nuevaTabla.length -1] = elem;
        return nuevaTabla;
    }

    public static void main(String[] args) {
        String cadenas [] = {};
        System.out.println("Cadenas antes de insertar: " + Arrays.toString(cadenas));
        cadenas = insertaObjeto("coche", cadenas);
        cadenas = insertaObjeto("avion", cadenas);
        cadenas = insertaObjeto("moto", cadenas);
        cadenas = insertaObjeto("bicicleta",cadenas);
        System.out.println("Cadenas antes después de insertar: " + Arrays.toString(cadenas));
    }


}
