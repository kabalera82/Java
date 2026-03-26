package Tema11_02FicherosBinarios.Ejercicio04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ejercicio 04 — Ficheros binarios con DataOutputStream y DataInputStream.
 *
 * <p>El programa pide al usuario que introduzca números enteros no negativos
 * por teclado. Cuando escribe -1 se detiene la entrada. Los números se guardan
 * en {@code numeros.dat}. Después el archivo se abre en modo lectura, se leen
 * todos los enteros y se muestran por pantalla, copiándolos además en un
 * segundo fichero {@code numerosCopia.dat}.</p>
 *
 * <p><b>[APRENDE] — DataOutputStream vs ObjectOutputStream</b><br>
 * {@link DataOutputStream} escribe tipos primitivos de Java en formato binario
 * raw: {@code int}, {@code double}, {@code boolean}, {@code String UTF-8}…<br>
 * {@link java.io.ObjectOutputStream} serializa <em>objetos completos</em> junto
 * con su metainformación de clase.<br>
 * Usa {@code DataOutputStream} cuando sabes exactamente qué tipos vas a
 * escribir/leer y quieres control total y eficiencia sobre el formato binario.
 * Usa {@code ObjectOutputStream} cuando necesitas serializar grafos de objetos
 * complejos.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del fichero principal donde se guardan los números. */
    private static final String FICHERO_NUMEROS = "data/numeros.dat";

    /** Ruta del fichero copia generado al leer. */
    private static final String FICHERO_COPIA   = "data/numerosCopia.dat";

    /**
     * Punto de entrada principal.
     *
     * <p>Orquesta los tres pasos: entrada de datos, lectura y copia.</p>
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        escribirNumeros();
        leerYCopiarNumeros();
    }

    // =========================================================================
    // PASO 1 — Escritura
    // =========================================================================

    /**
     * Lee números enteros del teclado hasta que el usuario introduce -1
     * y los escribe en {@value #FICHERO_NUMEROS} usando {@link DataOutputStream}.
     *
     * <p><b>[APRENDE] — Centinela (sentinel value)</b><br>
     * Un centinela es un valor especial que indica "fin de datos". Aquí usamos
     * -1 porque el enunciado pide números <em>no negativos</em>, así que -1
     * nunca puede ser un dato válido. Es una técnica clásica en lugar de pedir
     * al usuario que diga cuántos números va a introducir de antemano.</p>
     *
     * <p><b>[APRENDE] — try-with-resources</b><br>
     * La sintaxis {@code try (DataOutputStream dos = ...)} cierra el stream
     * automáticamente al salir del bloque, aunque ocurra una excepción.
     * Equivale al clásico bloque {@code finally} con {@code close()}, pero
     * mucho más limpio y seguro.</p>
     */
    private static void escribirNumeros() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ESCRITURA EN BINARIO ===");
        System.out.println("Introduce números enteros no negativos.");
        System.out.println("Escribe -1 para terminar.");
        System.out.println();

        // [APRENDE] — DataOutputStream envuelve un FileOutputStream.
        // FileOutputStream abre (o crea) el fichero en modo escritura.
        // DataOutputStream añade métodos como writeInt(), writeDouble(), etc.
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(FICHERO_NUMEROS))) {

            int numero;
            int contador = 0;

            do {
                System.out.print("Número: ");
                numero = sc.nextInt();

                // Solo guardamos si NO es el centinela
                if (numero != -1) {
                    // [APRENDE] — writeInt() escribe exactamente 4 bytes en el fichero.
                    // No escribe texto, sino la representación binaria del entero.
                    // Eso significa que 1000 ocupa 4 bytes, igual que 0 o Integer.MAX_VALUE.
                    dos.writeInt(numero);
                    contador++;
                }

            } while (numero != -1);

            System.out.printf("%nSe han guardado %d número(s) en '%s'.%n%n",
                    contador, FICHERO_NUMEROS);

        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    // =========================================================================
    // PASO 2 — Lectura y copia
    // =========================================================================

    /**
     * Lee todos los enteros de {@value #FICHERO_NUMEROS}, los muestra por
     * pantalla y los copia en {@value #FICHERO_COPIA}.
     *
     * <p><b>[APRENDE] — Detectar el fin de un fichero binario</b><br>
     * Con ficheros de texto usamos {@code readLine() != null}. Con binario
     * la técnica estándar es capturar {@link EOFException}: cuando
     * {@code DataInputStream} intenta leer más allá del fin del fichero lanza
     * esa excepción. La capturamos para terminar el bucle de forma limpia.<br>
     * <em>No es un error real</em>, es la señal de "no hay más datos".</p>
     *
     * <p><b>[APRENDE] — Simetría escritura/lectura</b><br>
     * Si escribiste con {@code writeInt()}, DEBES leer con {@code readInt()}.
     * Si mezclas tipos (escribiste {@code writeDouble()} pero lees con
     * {@code readInt()}), el resultado será basura o lanzará una excepción.
     * El formato binario no tiene etiquetas: TÚ eres el responsable del orden.</p>
     */
    private static void leerYCopiarNumeros() {
        System.out.println("=== LECTURA Y COPIA ===");

        // Abrimos ambos streams en el mismo try-with-resources.
        // Si cualquiera falla, ambos se cierran de forma segura.
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(FICHERO_NUMEROS));
             DataOutputStream dosCopia = new DataOutputStream(
                new FileOutputStream(FICHERO_COPIA))) {

            System.out.println("Números leídos de '" + FICHERO_NUMEROS + "':");

            int total = 0;

            // [APRENDE] — Bucle infinito controlado por EOFException.
            // Es el patrón idiomático para leer ficheros binarios de tamaño desconocido.
            while (true) {
                try {
                    int numero = dis.readInt();   // lanza EOFException al acabar
                    System.out.println("  -> " + numero);
                    dosCopia.writeInt(numero);    // copiamos al segundo fichero
                    total++;
                } catch (EOFException eof) {
                    // Fin de fichero: salimos del bucle de forma limpia
                    break;
                }
            }

            System.out.printf("%nTotal: %d número(s). Copia guardada en '%s'.%n",
                    total, FICHERO_COPIA);

        } catch (IOException e) {
            System.err.println("Error al leer/copiar el fichero: " + e.getMessage());
        }
    }
}
