package Tema12AcesoDatos.ejercicio03.csv;

import java.util.ArrayList;
import java.util.List;
/*
Clase de utilidades para trabajar con archivos CSV.
Contiene solo métodos estáticos y no puede instanciarse.
parseCSVLine() divide una línea CSV en campos, respetando comillas dobles.
*/

public class CsvUtils {

    // Constructor privado: impide crear o heredar la clase.
    // Solo se usarán métodos estáticos de utilidad.
    private CsvUtils() { }

    /*
      Divide una línea CSV en campos individuales.
      Respeta las comillas dobles y las comas internas dentro de ellas.
      Las comillas dobles duplicadas ("") se interpretan como una comilla literal.
     */
    public static List<String> parseCSVLine(String line) {

        // Lista con los campos obtenidos (cada columna del csv)
        List<String> out = new ArrayList<>();

        // Acumulador del texto del campo actual
        StringBuilder sb = new StringBuilder();

        // Controla si estamos dentro de comillas
        boolean enComillas = false;


        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);           // Carácter actual

            if (ch == '"') {
                // Si hay doble comilla dentro de comillas, añade una comilla literal
                if (enComillas && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    sb.append('"');
                    i++; // Salta la siguiente comilla
                } else {
                    enComillas = !enComillas;   // Cambia el estado dentro/fuera de comillas
                    sb.append(ch);
                }
            } else if (ch == ';' && !enComillas) {
                // Coma fuera de comillas → fin de campo
                out.add(sb.toString());
                sb.setLength(0);                // Reinicia el acumulador
            } else {
                sb.append(ch);                  // Añade el carácter al campo actual
            }
        }

        out.add(sb.toString());                 // Añade el último campo
        return out;
    }
}
