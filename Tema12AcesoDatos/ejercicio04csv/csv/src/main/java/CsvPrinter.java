package Tema12AcesoDatos.ejercicio04csv.csv.src.main.java;

import java.util.List;
import java.util.Map;

/**
 * Clase que imprime por pantalla el contenido de una tabla CSV (CsvTable).
 * <p>
 * Imprime las columnas alineadas sin bordes ni líneas separadoras (solo espacios).
 */
public class CsvPrinter {

    private CsvPrinter() {
    }

    /**
     * Imprime la tabla CSV de manera alineada, con columnas ajustadas.
     *
     * @param table Objeto CsvTable que contiene las cabeceras y filas leídas de un CSV.
     */
    public static void print(CsvTable table) {

        List<String> headers = table.getHeaders();
        List<Map<String, String>> rows = table.getRows();

        // Creamos un array de enteros donde guardaremos el ancho máximo de cada columna
        int[] widths = new int[headers.size()];

        for (int i = 0; i < headers.size(); i++) {
            widths[i] = headers.get(i).length();
        }

        // Recorremos todas las filas para ver si algún valor es más largo que la cabecera
        for (Map<String, String> row : rows) {

            // Recorremos cada columna dentro de la fila
            for (int i = 0; i < headers.size(); i++) {

                String val = row.get(headers.get(i)); // 🔧 corregido: antes ponía headers.size(i)

                if (val != null) {
                    widths[i] = Math.max(widths[i], val.length());
                }
            }
        }

        // IMPRIMIR LAS CABECERAS
        for (int i = 0; i < headers.size(); i++) {
            System.out.print(rellenarPavo(headers.get(i), widths[i] + 2)); // "+2" margen extra
        }

        // Salto de línea tras imprimir todas las cabeceras
        System.out.println();

        // IMPRIMIR TODAS LAS FILAS DE DATOS
        for (Map<String, String> row : rows) {

            for (int i = 0; i < headers.size(); i++) {
                String val = row.get(headers.get(i));
                System.out.print(rellenarPavo(val != null ? val : "", widths[i] + 2));
            }

            System.out.println(); // salto de línea por fila
        }

        // Fin del método: la tabla ya se ha mostrado por consola.
    }

    // -------------------------------------------------------
    //  MÉTODO AUXILIAR PARA RELLENAR CON ESPACIOS
    // -------------------------------------------------------

    /**
     * Rellena un texto con espacios a la derecha hasta alcanzar el ancho indicado.
     *
     * @param texto Texto original (ej. "Ana")
     * @param ancho Longitud total que debe ocupar el texto (ej. 10)
     * @return Texto con espacios añadidos al final (ej. "Ana       ")
     */
    private static String rellenarPavo(String texto, int ancho) {

        if (texto == null) {
            texto = "";
        }

        if (texto.length() >= ancho) {
            return texto;
        }

        return texto + " ".repeat(ancho - texto.length());
    }
}
