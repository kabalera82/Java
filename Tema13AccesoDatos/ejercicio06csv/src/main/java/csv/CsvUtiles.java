package src.main.java.csv;

import java.util.ArrayList;
import java.util.List;

public class CsvUtiles {

    // Privado para evitar crear instancias de esta clase, ya que solo contiene métodos esticos.
    private CsvUtiles() { }

    public static List<String> parseCSVLineas(String linea) {

        // Lista donde guardaremos cada columna del CSV.
        List<String> salida = new ArrayList<>();

        // Acumulador para ir construyendo el campo actual.
        StringBuilder sb = new StringBuilder();

        // Bandera para saber si estamos dentro de comillas.
        boolean enComillas = false;

        // Recorremos la línea carácter por carácter.
        for (int i = 0; i < linea.length(); i++) {

            // Obtenemos el carácter actual.
            char ch = linea.charAt(i);

            // Si el carácter es una comilla doble:
            if (ch == '"') {

                // Si estamos dentro de comillas y la siguiente comilla es otra comilla (doble comilla):
                if (enComillas && i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
                    sb.append('"'); // añadimos una comilla literal al campo
                    i++;            // saltamos la segunda comilla
                }
                // No es comilla escapada → alternamos el estado "dentro o fuera de comillas".
                else {
                    enComillas = !enComillas;
                }
            }

            // Si es una coma y NO estamos dentro de comillas, significa que termina un campo.
            else if (ch == ';' && !enComillas) {
                // Añadimos el campo acumulado a la lista de salida
                salida.add(sb.toString());
                // Vaciamos el acumulador para el siguiente campo
                sb.setLength(0);
            }

            // Para cualquier otro carácter, lo agregamos al campo actual
            else {
                sb.append(ch);
            }
        }

        // Al finalizar el bucle, añadimos el último campo que haya quedado en sb.
        // Esto es necesario porque el último campo no termina en coma.
        salida.add(sb.toString());

        // Devolvemos la lista con los campos parseados
        return salida;
    }

}