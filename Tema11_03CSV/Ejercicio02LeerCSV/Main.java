package Tema11_03CSV.Ejercicio02LeerCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 02 — Leer y parsear un fichero CSV de productos.
 *
 * <p>El programa abre {@code productos.csv}, salta la cabecera, parsea
 * cada línea y muestra los productos en formato tabla usando {@code printf}.</p>
 *
 * <p><b>[APRENDE] — Parsing con split()</b><br>
 * Parsear un CSV en Java es sorprendentemente sencillo con
 * {@link String#split(String)}. El método divide la cadena por el
 * separador y devuelve un array de Strings. Luego convertimos cada
 * elemento al tipo que necesitamos ({@code Integer.parseInt()},
 * {@code Double.parseDouble()}, etc.).<br>
 * <strong>Limitación:</strong> Este enfoque simple falla si un campo
 * contiene el separador dentro de comillas (e.g., {@code "precio;iva"}).
 * Para esos casos existen librerías como <em>OpenCSV</em> o
 * <em>Apache Commons CSV</em>.</p>
 *
 * <p><b>[APRENDE] — BufferedReader</b><br>
 * {@link BufferedReader} añade un búfer interno al {@link FileReader}.
 * En lugar de ir al disco byte a byte, lee bloques grandes y los guarda
 * en memoria. Es entre 5x y 10x más rápido que leer sin búfer para
 * ficheros de texto grandes.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del fichero CSV a leer. */
    private static final String FICHERO_CSV = "data/productos.csv";

    /** Separador de campos del CSV. Debe coincidir con el usado al escribir. */
    private static final String SEPARADOR = ";";

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        leerCSV();
    }

    /**
     * Lee el fichero CSV línea a línea, parsea cada registro y lo muestra
     * en formato tabla.
     *
     * <p><b>[APRENDE] — Saltar la cabecera</b><br>
     * La cabecera es solo para humanos y programas que no conocen el esquema.
     * Cuando ya sabes el formato, la primera línea se descarta con un
     * {@code readLine()} antes del bucle. Si la olvidaras incluirías la
     * cabecera como si fuera un dato, causando un {@link NumberFormatException}
     * al intentar parsear "id" como entero.</p>
     */
    private static void leerCSV() {
        System.out.println("=== LEYENDO FICHERO CSV ===");
        System.out.println("Fichero: " + FICHERO_CSV);
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_CSV))) {

            // [APRENDE] — Primer readLine() descarta la cabecera.
            // La guardamos en una variable por si queremos mostrarla o validarla.
            String cabecera = br.readLine();
            System.out.println("Cabecera detectada: [" + cabecera + "]");
            System.out.println();

            // Cabecera de la tabla de salida
            System.out.printf("%-5s %-20s %10s %8s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
            System.out.println("-".repeat(47));

            String linea;
            int contadorProductos = 0;

            // Leemos línea a línea hasta el final del fichero
            while ((linea = br.readLine()) != null) {

                // Saltamos líneas vacías (pueden aparecer al final del fichero)
                if (linea.isBlank()) continue;

                // [APRENDE] — split(";") divide por el separador y devuelve String[].
                // Cada índice corresponde a una columna: [0]=id, [1]=nombre, [2]=precio, [3]=stock
                String[] campos = linea.split(SEPARADOR);

                // Validación defensiva: si el número de campos no es 4, la línea está corrupta
                if (campos.length != 4) {
                    System.err.println("Línea malformada ignorada: " + linea);
                    continue;
                }

                // Conversión de tipos: del String crudo al tipo Java correspondiente
                int    id     = Integer.parseInt(campos[0].trim());
                String nombre = campos[1].trim();
                double precio = Double.parseDouble(campos[2].trim());
                int    stock  = Integer.parseInt(campos[3].trim());

                // Mostramos en formato tabla con printf para alinear columnas
                // %.2f → dos decimales; el símbolo € se añade al final del campo precio
                System.out.printf("%-5d %-20s %9.2f€ %7d ud%n",
                        id, nombre, precio, stock);

                contadorProductos++;
            }

            System.out.println("-".repeat(47));
            System.out.printf("Total de productos leídos: %d%n", contadorProductos);

        } catch (IOException e) {
            System.err.println("Error al leer el CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear un número: " + e.getMessage());
            System.err.println("Comprueba que el fichero usa el separador correcto: '" + SEPARADOR + "'");
        }
    }
}
