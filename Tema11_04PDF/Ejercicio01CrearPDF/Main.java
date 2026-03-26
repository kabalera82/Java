package Tema11_04PDF.Ejercicio01CrearPDF;

// ============================================================================
// [APRENDE] — DEPENDENCIA NECESARIA: iText 7
//
// Este ejercicio usa la librería iText 7 para generar ficheros PDF.
// Debes añadir la siguiente dependencia al pom.xml raíz del proyecto:
//
//   <dependencies>
//       <dependency>
//           <groupId>com.itextpdf</groupId>
//           <artifactId>itext7-core</artifactId>
//           <version>7.2.5</version>
//           <type>pom</type>
//       </dependency>
//   </dependencies>
//
// O de forma mínima (solo el kernel):
//   <dependency>
//       <groupId>com.itextpdf</groupId>
//       <artifactId>kernel</artifactId>
//       <version>7.2.5</version>
//   </dependency>
//   <dependency>
//       <groupId>com.itextpdf</groupId>
//       <artifactId>layout</artifactId>
//       <version>7.2.5</version>
//   </dependency>
// ============================================================================

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.IOException;

/**
 * Ejercicio 01 — Crear un PDF simple con texto usando iText 7.
 *
 * <p>El programa genera {@code hola_mundo.pdf} con:</p>
 * <ul>
 *   <li>Un título centrado y en negrita</li>
 *   <li>Un párrafo de texto normal</li>
 *   <li>Un texto en negrita y color rojo</li>
 * </ul>
 *
 * <p><b>[APRENDE] — ¿Qué es iText?</b><br>
 * iText es la librería Java más popular para crear y manipular ficheros PDF
 * de forma programática. Permite generar facturas, informes, contratos, etc.
 * directamente desde código.<br>
 * La versión 7 (iText7) usa una API de tipo <em>fluent builder</em>:
 * encadenas configuraciones con métodos que devuelven el propio objeto.</p>
 *
 * <p><b>[APRENDE] — Las tres capas de iText 7</b><br>
 * <ul>
 *   <li>{@code PdfWriter}: escribe bytes al disco (o a un OutputStream).</li>
 *   <li>{@code PdfDocument}: representa el documento PDF a nivel bajo
 *       (páginas, metadatos, fuentes).</li>
 *   <li>{@code Document}: la capa de alto nivel con la que trabajas
 *       habitualmente: añades {@code Paragraph}, {@code Table}, {@code Image}...</li>
 * </ul>
 * Siempre hay que cerrarlos en orden inverso al de apertura.</p>
 *
 * <p><b>[APRENDE] — Crear vs modificar un PDF</b><br>
 * Crear un PDF nuevo es sencillo: escribes contenido de arriba hacia abajo.
 * Modificar un PDF existente es mucho más complejo porque el formato PDF
 * NO es un documento editable línea por línea como el texto plano: es un
 * formato binario con referencias cruzadas y compresión. Para modificar
 * PDFs existentes necesitas {@code PdfReader} + {@code PdfWriter} juntos
 * (stamper), que es otro nivel de complejidad.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del PDF que se va a generar. */
    private static final String FICHERO_PDF = "data/hola_mundo.pdf";

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        crearPDF();
    }

    /**
     * Crea el fichero PDF con título, párrafo y texto en negrita/color.
     *
     * <p><b>[APRENDE] — Orden de cierre</b><br>
     * El try-with-resources cierra en orden inverso: primero {@code Document},
     * luego {@code PdfDocument}, luego {@code PdfWriter}. Esto es importante
     * porque {@code Document.close()} finaliza el layout y escribe el contenido
     * pendiente en el {@code PdfDocument}, y {@code PdfDocument.close()} escribe
     * la tabla de referencias (xref) al {@code PdfWriter}. Si no se cierran en
     * orden, el PDF queda corrupto.</p>
     */
    private static void crearPDF() {
        System.out.println("=== CREANDO PDF ===");

        // [APRENDE] — try-with-resources gestiona el cierre automático y en orden.
        // PdfWriter -> PdfDocument -> Document: apertura
        // Document -> PdfDocument -> PdfWriter: cierre (orden inverso automático)
        try (PdfWriter  writer   = new PdfWriter(FICHERO_PDF);
             PdfDocument pdf     = new PdfDocument(writer);
             Document   document = new Document(pdf)) {

            // === TÍTULO ===
            // [APRENDE] — Paragraph es el elemento básico de texto en iText.
            // La API fluent permite encadenar configuraciones: setBold(), setFontSize(), etc.
            Paragraph titulo = new Paragraph("¡Hola Mundo desde Java y iText 7!")
                    .setBold()
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20);

            document.add(titulo);

            // === PÁRRAFO NORMAL ===
            Paragraph parrafo = new Paragraph(
                    "Este es mi primer PDF generado de forma programática con Java. " +
                    "Podemos añadir tanto texto como queramos. El documento se " +
                    "pagina automáticamente cuando el contenido supera el alto de la página.")
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setMarginBottom(15);

            document.add(parrafo);

            // === TEXTO EN NEGRITA Y COLOR ===
            // [APRENDE] — setFontColor() acepta colores predefinidos de ColorConstants
            // o colores personalizados con new DeviceRgb(r, g, b).
            Paragraph negrita = new Paragraph("Este texto está en negrita y en color rojo.")
                    .setBold()
                    .setFontColor(ColorConstants.RED)
                    .setFontSize(14);

            document.add(negrita);

            System.out.println("PDF creado correctamente: " + FICHERO_PDF);

        } catch (IOException e) {
            System.err.println("Error al crear el PDF: " + e.getMessage());
        }
    }
}
