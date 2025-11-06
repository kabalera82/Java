package src.main.java.csv;

import java.util.*;

public class CsvTabla {

    // Se usa 'final' porque la referencia nunca cambia (aunque su contenido sí puede)
    private final List<String> cabeceras = new ArrayList<>();

    // También es 'final' por la misma razón: el objeto se mantiene, aunque se modifique.
    private final List<Map<String, String>> filas = new ArrayList<>();

    public List<String> getCabeceras () {
        return Collections.unmodifiableList(cabeceras);
    }


    //  Cada fila es un mapa donde las claves son las cabeceras y los valores son los datos.
    public List<Map<String, String>> getFilas() {
        return Collections.unmodifiableList(filas);
    }


    // Reemplaza las cabeceras actuales por una nueva lista.
    public void setCabeceras (List<String> cabecerasActuales) {
        cabeceras.clear();      // Eliminamos cualquier cabecera previa.
        cabeceras.addAll(cabecerasActuales); // Añadimos todas las nuevas cabeceras.
    }

    public void addFilas(List<String> valores) {

        // Creamos una fila vacía clave = cabecera, valor = dato.
        // Se usa LinkedHashMap para mantener el orden de las columnas.
        Map<String, String> fila = new LinkedHashMap<>();

        // Guardamos el número de cabeceras para iterar.
        int c = cabeceras.size();

        // Recorremos cada columna esperada según la lista de cabeceras.
        for (int i = 0; i < c; i++) {

            // Obtenemos la cabecera actual (nombre de la columna).
            String key = cabeceras.get(i);

            // Si hay un valor correspondiente en la lista, lo usamos.
            // Si no (lista de valores más corta), se guarda una cadena vacía.
            String vals = (i < valores.size()) ? valores.get(i) : "";

            // Insertamos el par clave-valor en la fila.
           fila.put(key, vals);
        }

        // Finalmente, añadimos la fila completa a la lista de filas de la tabla.
        filas.add(fila);
    }

    public int tamanho() {
        return filas.size();
    }

}
