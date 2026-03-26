package Tema11_04PDF.Ejercicio02LeerPDF;

// ============================================================================
// [APRENDE] — DEPENDENCIA NECESARIA: iText 7
//
// Además de kernel y layout, la extracción de texto requiere el módulo:
//   <dependency>
//       <groupId>com.itextpdf</groupId>
//       <artifactId>pdftotext</artifactId>   <!-- parte de itext7-core pom -->
//       <version>7.2.5</version>
//   </dependency>
//
// Si usas el BOM itext7-core como pom dependency, ya lo incluye todo.
// ============================================================================

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.IOException;

/**
 * Ejercicio 02 — Leer y extraer texto de un PDF existente con iText 7.
 *
 * <p>El programa abre {@code hola_mundo.pdf} (generado en el ejercicio anterior),
 * itera por sus páginas y extrae el texto de cada una usando
 * {@link PdfTextExtractor}.</p>
 *
 * <p><b>[APRENDE] — ¿Por qué PDF es un formato complejo?</b><br>
 * Un fichero PDF no almacena texto como un fichero .txt. Almacena
 * instrucciones de dibujado: "dibuja este glifo en la posición (x, y)".
 * No hay concepto de "frase" ni "párrafo" a nivel bajo. Por eso extraer
 * texto de un PDF es difícil: hay que reconstruir el orden lógico a partir
 * de posiciones absolutas en el lienzo.<br>
 * {@code PdfTextExtractor} hace ese trabajo por nosotros, pero no es
 * perfecto: PDFs con columnas, tablas o texto rotado pueden extraerse
 * con el orden equivocado.</p>
 *
 * <p><b>[APRENDE] — PdfReader (solo lectura) vs PdfWriter</b><br>
 * {@link PdfReader} abre un PDF existente en modo solo lectura: no modifica
 * el fichero original. {@code PdfWriter} crea o sobreescribe. Si necesitas
 * ambos a la vez (leer y modificar), iText usa el patrón <em>stamper</em>:
 * {@code new PdfDocument(reader, writer)}.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del PDF a leer. Debe existir previamente (créalo con Ejercicio01). */
    private static final String FICHERO_PDF = "data/hola_mundo.pdf";

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        leerPDF();
    }

    /**
     * Abre el PDF, itera por sus páginas y extrae el texto de cada una.
     *
     * <p><b>[APRENDE] — getNumberOfPages()</b><br>
     * Un {@link PdfDocument} puede tener múltiples páginas. Las páginas
     * se indexan desde 1 (no desde 0 como los arrays). Siempre iteramos
     * con {@code for (int i = 1; i <= pdf.getNumberOfPages(); i++)} para
     * cubrir todos los casos.</p>
     */
    private static void leerPDF() {
        System.out.println("=== LEYENDO PDF ===");
        System.out.println("Fichero: " + FICHERO_PDF);
        System.out.println();

        // [APRENDE] — PdfReader solo necesita la ruta. PdfDocument en modo lectura
        // solo requiere el PdfReader (sin PdfWriter).
        try (PdfReader   reader = new PdfReader(FICHERO_PDF);
             PdfDocument pdf    = new PdfDocument(reader)) {

            int numPaginas = pdf.getNumberOfPages();
            System.out.println("Número de páginas: " + numPaginas);
            System.out.println("-".repeat(50));

            // Iteramos desde la página 1 (iText no usa índice 0)
            for (int i = 1; i <= numPaginas; i++) {
                PdfPage pagina = pdf.getPage(i);

                // [APRENDE] — PdfTextExtractor.getTextFromPage() reconstruye
                // el texto de la página respetando el orden de lectura natural.
                // Internamente usa LocationTextExtractionStrategy que ordena
                // los glifos por posición en la página.
                String texto = PdfTextExtractor.getTextFromPage(pagina);

                System.out.println("--- Página " + i + " ---");
                System.out.println(texto);
                System.out.println();
            }

            System.out.println("-".repeat(50));
            System.out.println("Lectura completada.");

        } catch (IOException e) {
            System.err.println("Error al leer el PDF: " + e.getMessage());
            System.err.println("Asegúrate de ejecutar primero el Ejercicio01 para generar el PDF.");
        }
    }
}
