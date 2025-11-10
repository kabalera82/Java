package org.kabalera82.csv;

// imports
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para procesar texto con formato CSV.
 * <p>
 *     Permite dividir una línea CSV en campos individuales, respetando las comillas
 *     dobles que puedan encerrar texto con comas internas.
 * </p>
 */
public class
CsvUtils {

    /** Constructor vacío (no realiza ninguna acción), privado evita que se instancie desde fuera). */
    private CsvUtils() { }

    /**
     * Parsea una línea CSV y la convierte en una lista de campos.
     * <p>
     *     Ignora las comas dentro de comillas y gestiona correctamente las comillas dobles.
     * </p>
     * @param line línea de texto CSV a procesar
     * @return lista con los campos obtenidos
     */
    public static List<String> parseCSVLines(String line) {

        // Lista donde se guardarán los campos resultantes
        List<String> out = new ArrayList<>();

        // Acumulador temporal para construir el texto de cada campo
        StringBuilder sb = new StringBuilder();

        // Indica si estamos dentro de comillas ("texto, con, comas")
        boolean enComillas = false;

        // Recorremos cada carácter de la línea CSV
        for (int i = 0; i < line.length(); i++) {

            // Obtenemos el carácter actual
            char ch = line.charAt(i);

            // 1. Si encontramos una comilla doble (") ----------------------------------------------
            if (ch == '"') {
                // Si estamos dentro de comillas y hay otra comilla justo después
                // significa que es una comilla literal dentro del texto, por lo que se ignora
                if (enComillas && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    i++; // Avanzamos una posición para saltar la comilla duplicada
                } else {
                    // Si no, cambiamos el estado:
                    // si estábamos fuera, entramos en comillas; si estábamos dentro, salimos
                    enComillas = !enComillas;
                }
            }
            // 2. Si encontramos una coma y no estamos dentro de comillas --------------------------
            else if (ch == ',' && !enComillas) {
                // Esto indica el fin de un campo, así que lo añadimos a la lista
                out.add(sb.toString());

                // Reiniciamos el acumulador para empezar el siguiente campo
                sb.setLength(0);
            }
            // 3. En cualquier otro caso (letra, número, espacio, coma dentro de comillas ...) -----
            else {
                // Añadimos el carácter al texto del campo en construcción
                sb.append(ch);
            }
        }

        // 4. Al terminar la línea, añadimos el último campo acumulado -----------------------------
        out.add(sb.toString());

        // Devolvemos la lista completa con todos los campos separados
        return out;
    }
}
