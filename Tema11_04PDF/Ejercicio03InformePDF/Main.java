package Tema11_04PDF.Ejercicio03InformePDF;

// ============================================================================
// [APRENDE] — DEPENDENCIA NECESARIA: iText 7
//
// Dependencia en pom.xml:
//   <dependency>
//       <groupId>com.itextpdf</groupId>
//       <artifactId>itext7-core</artifactId>
//       <version>7.2.5</version>
//       <type>pom</type>
//   </dependency>
// ============================================================================

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Ejercicio 03 — Generar un informe PDF profesional con tabla de productos.
 *
 * <p>El programa genera {@code informe_productos.pdf} con:</p>
 * <ul>
 *   <li>Cabecera con título e información de la empresa</li>
 *   <li>Fecha de generación</li>
 *   <li>Tabla de productos con formato visual</li>
 *   <li>Fila de totales (valor total del inventario)</li>
 *   <li>Pie de página con número de página</li>
 * </ul>
 *
 * <p><b>[APRENDE] — Table en iText 7</b><br>
 * {@link Table} es el elemento más potente de iText para datos tabulares.
 * Se define con un array de anchos relativos y se rellena añadiendo
 * {@link Cell} fila a fila. Cada celda puede tener su propio estilo:
 * fondo, alineación, negrita, bordes, colspan/rowspan...</p>
 *
 * <p><b>[APRENDE] — Pie de página con event handler</b><br>
 * En iText 7 los pies de página se implementan como <em>event handlers</em>:
 * registras un listener que se ejecuta al final de cada página. Dentro
 * del handler usas {@link PdfCanvas} (la API de bajo nivel) para dibujar
 * directamente sobre la página ya cerrada.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del informe PDF de salida. */
    private static final String FICHERO_PDF = "data/informe_productos.pdf";

    /** Color corporativo para la cabecera de la tabla (azul oscuro). */
    private static final DeviceRgb COLOR_CABECERA = new DeviceRgb(31, 73, 125);

    /** Color de fila alternada (gris muy claro). */
    private static final DeviceRgb COLOR_FILA_PAR = new DeviceRgb(235, 241, 250);

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        generarInforme();
    }

    /**
     * Genera el informe PDF completo.
     */
    private static void generarInforme() {
        System.out.println("=== GENERANDO INFORME PDF ===");

        // Datos de ejemplo (en una app real vendrían de la BD o del CSV)
        List<String[]> productos = List.of(
            new String[]{"1", "Manzana Fuji",    "1.99",  "150"},
            new String[]{"2", "Leche Entera",    "0.89",  "300"},
            new String[]{"3", "Pan de Molde",    "1.35",  "80"},
            new String[]{"4", "Aceite de Oliva", "6.50",  "45"},
            new String[]{"5", "Queso Manchego",  "12.90", "20"}
        );

        try (PdfWriter   writer   = new PdfWriter(FICHERO_PDF);
             PdfDocument pdf      = new PdfDocument(writer);
             Document    document = new Document(pdf)) {

            // Registramos el pie de página como event handler
            // [APRENDE] — El handler se llama automáticamente al cerrar cada página.
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new PieDePaginaHandler());

            // === CABECERA DEL INFORME ===
            añadirCabecera(document);

            // === FECHA DE GENERACIÓN ===
            añadirFecha(document);

            // === TABLA DE PRODUCTOS ===
            añadirTablaProductos(document, productos);

            System.out.println("Informe generado correctamente: " + FICHERO_PDF);

        } catch (IOException e) {
            System.err.println("Error al generar el informe: " + e.getMessage());
        }
    }

    // =========================================================================
    // Secciones del documento
    // =========================================================================

    /**
     * Añade la cabecera del informe: nombre empresa y título del documento.
     *
     * @param document el documento al que añadir la cabecera
     */
    private static void añadirCabecera(Document document) {
        document.add(new Paragraph("EMPRESA EJEMPLO S.L.")
                .setBold()
                .setFontSize(10)
                .setFontColor(ColorConstants.GRAY)
                .setTextAlignment(TextAlignment.RIGHT));

        document.add(new Paragraph("Informe de Inventario de Productos")
                .setBold()
                .setFontSize(22)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(5));

        // Línea divisoria visual
        document.add(new Paragraph("_".repeat(80))
                .setFontColor(new DeviceRgb(31, 73, 125))
                .setMarginBottom(10));
    }

    /**
     * Añade el bloque de fecha de generación del informe.
     *
     * @param document el documento al que añadir la fecha
     */
    private static void añadirFecha(Document document) {
        String fecha = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        document.add(new Paragraph("Fecha de generación: " + fecha)
                .setFontSize(10)
                .setFontColor(ColorConstants.DARK_GRAY)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginBottom(15));
    }

    /**
     * Construye y añade la tabla de productos al documento.
     *
     * <p><b>[APRENDE] — UnitValue.createPercentArray()</b><br>
     * Define los anchos de columna como porcentajes del ancho disponible.
     * {@code {5, 40, 20, 15, 20}} significa: col1=5%, col2=40%, col3=20%,
     * col4=15%, col5=20%. La suma no tiene que ser 100 exactamente:
     * iText lo normaliza. {@code forceWidth(100%)} hace que la tabla
     * ocupe todo el ancho de la página.</p>
     *
     * @param document  el documento al que añadir la tabla
     * @param productos lista de productos como arrays de Strings {id, nombre, precio, stock}
     */
    private static void añadirTablaProductos(Document document, List<String[]> productos) {
        // Definimos los anchos relativos de las 5 columnas
        float[] anchos = {5f, 40f, 20f, 15f, 20f};
        Table tabla = new Table(UnitValue.createPercentArray(anchos))
                .useAllAvailableWidth()
                .setMarginBottom(20);

        // --- Fila de cabecera ---
        String[] cabeceras = {"ID", "NOMBRE", "PRECIO/UD", "STOCK", "VALOR TOTAL"};
        for (String cab : cabeceras) {
            tabla.addHeaderCell(
                new Cell().add(new Paragraph(cab).setBold().setFontColor(ColorConstants.WHITE))
                          .setBackgroundColor(COLOR_CABECERA)
                          .setTextAlignment(TextAlignment.CENTER)
                          .setPadding(6)
            );
        }

        // --- Filas de datos ---
        double valorInventarioTotal = 0;
        int fila = 0;

        for (String[] prod : productos) {
            DeviceRgb colorFila = (fila % 2 == 0) ? ColorConstants.WHITE : COLOR_FILA_PAR;

            double precio = Double.parseDouble(prod[2]);
            int    stock  = Integer.parseInt(prod[3]);
            double valorTotal = precio * stock;
            valorInventarioTotal += valorTotal;

            tabla.addCell(celdaDato(prod[0], colorFila, TextAlignment.CENTER));
            tabla.addCell(celdaDato(prod[1], colorFila, TextAlignment.LEFT));
            tabla.addCell(celdaDato(String.format("%.2f €", precio), colorFila, TextAlignment.RIGHT));
            tabla.addCell(celdaDato(prod[3] + " ud", colorFila, TextAlignment.CENTER));
            tabla.addCell(celdaDato(String.format("%.2f €", valorTotal), colorFila, TextAlignment.RIGHT));

            fila++;
        }

        // --- Fila de totales ---
        tabla.addCell(
            new Cell(1, 4)  // colspan=4: ocupa las 4 primeras columnas
                .add(new Paragraph("VALOR TOTAL DEL INVENTARIO").setBold())
                .setBackgroundColor(new DeviceRgb(220, 230, 245))
                .setTextAlignment(TextAlignment.RIGHT)
                .setPadding(6)
        );
        tabla.addCell(
            new Cell()
                .add(new Paragraph(String.format("%.2f €", valorInventarioTotal)).setBold())
                .setBackgroundColor(new DeviceRgb(220, 230, 245))
                .setTextAlignment(TextAlignment.RIGHT)
                .setPadding(6)
        );

        document.add(tabla);

        // Nota al pie de la tabla
        document.add(new Paragraph("* Los precios incluyen IVA.")
                .setFontSize(9)
                .setFontColor(ColorConstants.GRAY)
                .setItalic());
    }

    /**
     * Crea una celda estándar de dato con estilo uniforme.
     *
     * @param contenido   texto de la celda
     * @param colorFondo  color de fondo
     * @param alineacion  alineación del texto
     * @return la celda configurada
     */
    private static Cell celdaDato(String contenido, DeviceRgb colorFondo,
                                   TextAlignment alineacion) {
        return new Cell()
                .add(new Paragraph(contenido))
                .setBackgroundColor(colorFondo)
                .setTextAlignment(alineacion)
                .setPadding(5);
    }

    // =========================================================================
    // Pie de página — Event Handler
    // =========================================================================

    /**
     * Handler que dibuja el pie de página al finalizar cada página del documento.
     *
     * <p><b>[APRENDE] — IEventHandler y PdfCanvas</b><br>
     * {@link IEventHandler} es la interfaz de eventos de iText. Aquí interceptamos
     * {@code END_PAGE} que se lanza justo antes de cerrar cada página.<br>
     * {@link PdfCanvas} es la API de bajo nivel: trabajas con coordenadas absolutas
     * en puntos (pt). 1 pt = 1/72 de pulgada. Una página A4 mide 595 x 842 pt.</p>
     */
    private static class PieDePaginaHandler implements IEventHandler {

        @Override
        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdf  = docEvent.getDocument();
            PdfPage     page = docEvent.getPage();

            int numeroPagina   = pdf.getPageNumber(page);
            int totalPaginas   = pdf.getNumberOfPages();
            Rectangle pageSize = page.getPageSize();

            // [APRENDE] — PdfCanvas escribe directamente sobre la página a nivel bajo.
            // Después lo envolvemos con Canvas (capa de layout) para usar Paragraph.
            PdfCanvas canvas = new PdfCanvas(page.newContentStreamAfter(), page.getResources(), pdf);

            try (Canvas layoutCanvas = new Canvas(canvas, pageSize)) {
                String textoPie = String.format(
                    "Informe generado automáticamente con Java & iText 7  |  Página %d de %d",
                    numeroPagina, totalPaginas);

                // Posicionamos el pie en la parte inferior: y = 20 pt desde el borde
                layoutCanvas.showTextAligned(
                    new Paragraph(textoPie)
                        .setFontSize(8)
                        .setFontColor(ColorConstants.GRAY),
                    pageSize.getWidth() / 2,  // centrado horizontal
                    20,                        // 20 pt desde el borde inferior
                    TextAlignment.CENTER
                );
            }
        }
    }
}
