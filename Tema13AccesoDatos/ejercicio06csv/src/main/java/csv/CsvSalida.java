package src.main.java.csv;

import src.main.java.csv.CsvTabla;

import java.util.List;
import java.util.Map;

/**
 *  Esta clase permite agrupar todas las clases relacionadas con el manejo de archivos CSV.
 *
 *  imprime por pantalla el contenido de una tabla CSV.
 */



public class CsvSalida {

    // Privado para impedir instancias de esta clase
    private CsvSalida () {};

    public static void imprime (CsvTabla tabla) {

        List <String> cabeceras = tabla.getCabeceras();
        List <Map<String, String>> filas = tabla.getFilas();

        // Creamos un array de enteros donde guardaremos el ancho máximo de cada columna.
        int[] anchos = new int[cabeceras.size()];
        
        for(int i = 0; i < cabeceras.size(); i++){
            anchos[i] = cabeceras.get(i).length();
        }

        // Recorremos todas las filas para ver si algún valor es más largo que la cabecera.
        for (Map<String, String> fila : filas) {

            // Recorremos cada columna dentro de la fila
            for (int i = 0; i < cabeceras.size(); i++) {

                // Obtenemos el valor de esa columna según el nombre de cabecera
                String val = fila.get(cabeceras.get(i));

                // Si el valor no es nulo, comprobamos si su longitud es mayor que la actual
                if (val != null) {
                    // Math.max() se queda con el número mayor entre el ancho actual y el nuevo valor
                    anchos[i] = Math.max(anchos[i], val.length());
                }
            }
        }


    }
    /**
     * Rellena un texto con espacios a la derecha hasta alcanzar el ancho indicado.
     *
     * @param texto Texto original (ej. "Ana")
     * @param ancho Longitud total que debe ocupar el texto (ej. 10)
     * @return Texto con espacios añadidos al final (ej. "Ana       ")
     */
    private static String rellenarPavo(String texto, int ancho) {

        // Si el texto ya tiene el tamaño igual o mayor al ancho pedido,
        // lo devolvemos tal cual (no necesita relleno).
        if (texto.length() >= ancho) {
            return texto;
        }

        // En caso contrario, añadimos los espacios necesarios a la derecha.
        // " ".repeat(n) crea una cadena de n espacios.
        return texto + " ".repeat(ancho - texto.length());
    }
 }
