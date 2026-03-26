package Tema11_03CSV.Ejercicio01EscribirCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ejercicio 01 — Crear y escribir un fichero CSV de productos.
 *
 * <p>El programa crea {@code productos.csv} con 5 productos hardcodeados
 * y muestra por consola que el fichero se generó correctamente.</p>
 *
 * <p><b>[APRENDE] — ¿Qué es un fichero CSV?</b><br>
 * CSV = <em>Comma-Separated Values</em> (Valores Separados por Comas).
 * Es un formato de texto plano para almacenar datos tabulares. Cada línea
 * es una fila y cada campo dentro de la fila se separa con un delimitador.<br>
 * Es el formato más universal para intercambio de datos: Excel lo entiende,
 * Python lo lee, bases de datos lo importan, APIs lo exportan.</p>
 *
 * <p><b>[APRENDE] — ¿Por qué usamos ";" en lugar de ","?</b><br>
 * El estándar original usa coma, pero en países de habla hispana la coma
 * se usa como separador decimal (1,5 euros). Si el dato es "1,5" y el
 * separador es también ",", el parser no sabe si es un separador de campo
 * o un decimal. Por eso en España y Latinoamérica se usa ";" como
 * separador. Es más robusto y evita ambigüedades.</p>
 *
 * <p><b>[APRENDE] — ¿Por qué una cabecera?</b><br>
 * La primera línea del CSV es la <em>cabecera</em>: los nombres de las
 * columnas. Sirve para que cualquier lector (humano o programa) sepa qué
 * representa cada campo sin necesidad de documentación extra. Es una
 * convención ampliamente adoptada, no una obligación técnica.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del fichero CSV que se va a crear. */
    private static final String FICHERO_CSV = "data/productos.csv";

    /** Separador de campos. Usamos ";" en lugar de "," por robustez con decimales. */
    private static final String SEPARADOR = ";";

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        crearCSV();
    }

    /**
     * Crea el fichero CSV con la cabecera y 5 productos hardcodeados.
     *
     * <p><b>[APRENDE] — PrintWriter con FileWriter</b><br>
     * {@link PrintWriter} nos da el cómodo método {@code printf()} para
     * formatear texto. Lo envolvemos con {@link FileWriter} que es el que
     * realmente escribe bytes en disco.<br>
     * El segundo parámetro de {@code FileWriter(ruta, append)} controla si
     * se sobreescribe ({@code false}) o se añade al final ({@code true}).</p>
     */
    private static void crearCSV() {
        System.out.println("=== CREANDO FICHERO CSV ===");

        // [APRENDE] — try-with-resources: el PrintWriter se cierra automáticamente
        // al salir del bloque, haciendo flush() primero para vaciar el buffer.
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_CSV, false))) {

            // Escribimos la cabecera — SIEMPRE en la primera línea
            pw.println("id" + SEPARADOR + "nombre" + SEPARADOR + "precio" + SEPARADOR + "stock");

            // Datos de los 5 productos
            // Formato: id;nombre;precio;stock
            // [APRENDE] — Los decimales se escriben con punto (.) aunque luego
            // al mostrarlos podemos formatearlos con coma. El CSV usa siempre punto.
            pw.println("1" + SEPARADOR + "Manzana Fuji"     + SEPARADOR + "1.99"  + SEPARADOR + "150");
            pw.println("2" + SEPARADOR + "Leche Entera"     + SEPARADOR + "0.89"  + SEPARADOR + "300");
            pw.println("3" + SEPARADOR + "Pan de Molde"     + SEPARADOR + "1.35"  + SEPARADOR + "80");
            pw.println("4" + SEPARADOR + "Aceite de Oliva"  + SEPARADOR + "6.50"  + SEPARADOR + "45");
            pw.println("5" + SEPARADOR + "Queso Manchego"   + SEPARADOR + "12.90" + SEPARADOR + "20");

            System.out.println("Fichero '" + FICHERO_CSV + "' creado correctamente.");
            System.out.println("Productos escritos: 5");
            System.out.println("Separador usado: '" + SEPARADOR + "'");
            System.out.println();
            System.out.println("Contenido generado:");
            System.out.println("  id;nombre;precio;stock");
            System.out.println("  1;Manzana Fuji;1.99;150");
            System.out.println("  2;Leche Entera;0.89;300");
            System.out.println("  3;Pan de Molde;1.35;80");
            System.out.println("  4;Aceite de Oliva;6.50;45");
            System.out.println("  5;Queso Manchego;12.90;20");

        } catch (IOException e) {
            System.err.println("Error al crear el CSV: " + e.getMessage());
        }
    }
}
