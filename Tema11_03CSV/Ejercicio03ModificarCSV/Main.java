package Tema11_03CSV.Ejercicio03ModificarCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 03 — Modificar registros en un fichero CSV.
 *
 * <p>El programa lee {@code productos.csv}, aplica una subida de precio
 * del 10% a todos los productos y reescribe el fichero con los nuevos valores.</p>
 *
 * <p><b>[APRENDE] — ¿Cómo se modifica un CSV?</b><br>
 * Los ficheros de texto (incluyendo CSV) NO soportan modificación in-place
 * de forma eficiente. No puedes "ir a la línea 3 y cambiar solo el precio"
 * porque los campos tienen longitud variable.<br>
 * La técnica estándar es:<br>
 * <ol>
 *   <li>Leer todo el fichero en memoria (como lista de objetos o de Strings).</li>
 *   <li>Modificar los datos en memoria.</li>
 *   <li>Reescribir el fichero completo desde cero.</li>
 * </ol>
 * Para ficheros grandes que no caben en memoria, se usa un fichero temporal
 * que luego reemplaza al original.</p>
 *
 * <p><b>[APRENDE] — Precisión con decimales</b><br>
 * Al operar con {@code double} pueden aparecer errores de precisión
 * (e.g., 1.99 * 1.1 = 2.1890000000000003). Al escribir de vuelta en el CSV
 * formateamos con {@code String.format("%.2f", precio)} para truncar a
 * 2 decimales y evitar guardar esos artefactos en el fichero.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del fichero CSV a modificar. */
    private static final String FICHERO_CSV = "data/productos.csv";

    /** Separador de campos del CSV. */
    private static final String SEPARADOR = ";";

    /** Porcentaje de subida de precio (10%). */
    private static final double PORCENTAJE_SUBIDA = 0.10;

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        modificarPrecios();
    }

    /**
     * Lee el CSV completo en memoria, aplica la subida del 10% a todos
     * los precios y reescribe el fichero.
     *
     * <p><b>[APRENDE] — Patrón leer-modificar-reescribir</b><br>
     * Guardamos las líneas modificadas en una {@link List} de Strings.
     * Primero leemos todo (cerramos el stream de lectura), luego
     * escribimos todo (con el stream de escritura). Nunca abrimos el mismo
     * fichero para leer y escribir al mismo tiempo: podríamos perder datos.</p>
     */
    private static void modificarPrecios() {
        System.out.println("=== MODIFICANDO PRECIOS (+10%) ===");

        // PASO 1: Leer y preparar líneas modificadas
        List<String> lineasModificadas = new ArrayList<>();
        int productosModificados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_CSV))) {

            // La cabecera se copia tal cual, sin modificar
            String cabecera = br.readLine();
            if (cabecera != null) {
                lineasModificadas.add(cabecera);
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;

                String[] campos = linea.split(SEPARADOR);

                if (campos.length != 4) {
                    // Línea malformada: la conservamos sin cambios
                    lineasModificadas.add(linea);
                    continue;
                }

                // Parseamos el precio (índice 2)
                double precioOriginal = Double.parseDouble(campos[2].trim());

                // Aplicamos la subida del 10%
                double precioNuevo = precioOriginal * (1 + PORCENTAJE_SUBIDA);

                // Mostramos el cambio por consola
                System.out.printf("  %-20s  %.2f€ -> %.2f€%n",
                        campos[1].trim(), precioOriginal, precioNuevo);

                // [APRENDE] — Reconstruimos la línea CSV con el precio formateado.
                // String.format("%.2f", ...) asegura exactamente 2 decimales, sin artefactos.
                String lineaModificada = campos[0] + SEPARADOR
                        + campos[1] + SEPARADOR
                        + String.format("%.2f", precioNuevo) + SEPARADOR
                        + campos[3];

                lineasModificadas.add(lineaModificada);
                productosModificados++;
            }

        } catch (IOException e) {
            System.err.println("Error al leer el CSV: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear precio: " + e.getMessage());
            return;
        }

        // PASO 2: Reescribir el fichero con las líneas modificadas
        // [APRENDE] — FileWriter(ruta, false) sobreescribe el fichero desde cero.
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_CSV, false))) {

            for (String linea : lineasModificadas) {
                pw.println(linea);
            }

            System.out.printf("%n%d producto(s) actualizados. Fichero reescrito: '%s'%n",
                    productosModificados, FICHERO_CSV);

        } catch (IOException e) {
            System.err.println("Error al escribir el CSV: " + e.getMessage());
        }
    }
}
