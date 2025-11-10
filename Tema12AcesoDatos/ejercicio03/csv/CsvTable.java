package Tema12AcesoDatos.ejercicio03.csv;

import java.util.*;

public class CsvTable {

    // Lista que contiene las cabeceras
    private final List<String> headers = new ArrayList<>();

    // Lista de filas, donde cada fila es un Map<nombreColumna, valor>.
    private final List<Map<String, String>> rows = new ArrayList<>();

    //  Devuelve una vista de solo lectura (inmodificable) de las cabeceras.
    public List<String> getHeaders() {
        return Collections.unmodifiableList(headers);
    }

    // Devuelve una vista inmodificable de las filas.
    public List<Map<String, String>> getRows() {
        return Collections.unmodifiableList(rows);
    }

    // Reemplaza las cabeceras por una nueva lista
    public void setHeaders(List<String> hdrs) {
        headers.clear();
        headers.addAll(hdrs);
    }

    // Añade una fila de datos a la tabla.
    public void addRow(List<String> valores) {

        // Creamos una fila vacía (mapa ordenado) donde clave = cabecera, valor = dato.
        // Se usa LinkedHashMap para mantener el orden de las columnas.
        Map<String, String> row = new LinkedHashMap<>();

        // Guardamos el número de cabeceras para iterar.
        int n = headers.size();

        // Recorremos cada columna esperada según la lista de cabeceras.
        for (int i = 0; i < n; i++) {

            // Obtenemos la cabecera actual (nombre de la columna).
            String key = headers.get(i);

            // Si hay un valor correspondiente en la lista, lo usamos.
            // Si no (lista de valores más corta), se guarda una cadena vacía.
            String value = (i < valores.size()) ? valores.get(i) : "";

            // Insertamos el par clave-valor en la fila.
            row.put(key, value);
        }
        rows.add(row);
    }

    // Devuelve el número total de filas almacenadas en la tabla.
    public int size() {
        return rows.size();
    }

}
