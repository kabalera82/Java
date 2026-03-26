package Tema11_03CSV.Ejercicio04AppCompleto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO (<em>Data Access Object</em>) para gestionar la persistencia de
 * {@link Producto} en un fichero CSV.
 *
 * <p>Proporciona las operaciones CRUD completas sobre el fichero
 * {@value #FICHERO_CSV}:</p>
 * <ul>
 *   <li>{@link #listarTodos()} — leer todos los productos</li>
 *   <li>{@link #buscarPorNombre(String)} — búsqueda parcial por nombre</li>
 *   <li>{@link #añadir(Producto)} — insertar un nuevo producto</li>
 *   <li>{@link #actualizarPrecio(int, double)} — modificar precio por id</li>
 *   <li>{@link #eliminarPorId(int)} — borrar un producto por id</li>
 * </ul>
 *
 * <p><b>[APRENDE] — Patrón DAO</b><br>
 * El DAO aísla la capa de presentación (el {@link Main} con el menú) de los
 * detalles de persistencia (cómo y dónde se guardan los datos). Mañana podríamos
 * cambiar el CSV por una base de datos SQL sin modificar el código del menú.
 * Eso es el principio de <em>Open/Closed</em> de SOLID.</p>
 *
 * <p><b>[APRENDE] — Optional</b><br>
 * {@link Optional} es el contenedor estándar de Java para representar
 * "un valor que puede existir o no". Es más semántico que devolver {@code null}
 * y obliga al llamador a manejar el caso de "no encontrado" de forma explícita.</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class ProductoCSVDao {

    /** Ruta del fichero CSV de persistencia. */
    private static final String FICHERO_CSV = "data/productos.csv";

    /** Separador de campos. */
    private static final String SEPARADOR = ";";

    /** Cabecera del CSV. */
    private static final String CABECERA = "id" + SEPARADOR + "nombre" + SEPARADOR
            + "precio" + SEPARADOR + "stock";

    // =========================================================================
    // READ — Leer todos
    // =========================================================================

    /**
     * Lee todos los productos del fichero CSV.
     *
     * @return lista de productos, vacía si el fichero no existe o está vacío
     */
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_CSV))) {
            br.readLine(); // descartar cabecera
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isBlank()) {
                    parsearLinea(linea).ifPresent(productos::add);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer CSV: " + e.getMessage());
        }

        return productos;
    }

    // =========================================================================
    // READ — Buscar por nombre
    // =========================================================================

    /**
     * Busca productos cuyo nombre contenga el texto indicado (sin distinción
     * de mayúsculas/minúsculas).
     *
     * @param texto texto a buscar dentro del nombre
     * @return lista de productos que coinciden
     */
    public List<Producto> buscarPorNombre(String texto) {
        String textoBusqueda = texto.toLowerCase().trim();

        // [APRENDE] — Stream + filter: una forma funcional y legible de filtrar listas.
        // Equivale a un bucle for que comprueba la condición y añade a una nueva lista.
        return listarTodos().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(textoBusqueda))
                .toList();
    }

    // =========================================================================
    // CREATE — Añadir
    // =========================================================================

    /**
     * Añade un nuevo producto al final del fichero CSV.
     *
     * <p><b>[APRENDE] — Modo append en FileWriter</b><br>
     * {@code new FileWriter(ruta, true)} abre el fichero en modo <em>append</em>:
     * el cursor se posiciona al final y no se borra el contenido existente.
     * Es equivalente a {@code >>} en bash o redirección de adición.</p>
     *
     * @param producto el producto a insertar
     */
    public void añadir(Producto producto) {
        // [APRENDE] — true = append mode: no sobreescribe, añade al final
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_CSV, true))) {
            pw.println(formatearLinea(producto));
            System.out.println("Producto añadido: " + producto.getNombre());
        } catch (IOException e) {
            System.err.println("Error al añadir producto: " + e.getMessage());
        }
    }

    // =========================================================================
    // UPDATE — Actualizar precio
    // =========================================================================

    /**
     * Actualiza el precio de un producto identificado por su id.
     *
     * @param id        identificador del producto
     * @param nuevoPrecio nuevo precio (debe ser &gt;= 0)
     * @return {@code true} si se encontró y actualizó el producto
     */
    public boolean actualizarPrecio(int id, double nuevoPrecio) {
        List<Producto> productos = listarTodos();
        boolean encontrado = false;

        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setPrecio(nuevoPrecio);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarTodos(productos);
        }

        return encontrado;
    }

    // =========================================================================
    // DELETE — Eliminar por id
    // =========================================================================

    /**
     * Elimina el producto con el id especificado del fichero CSV.
     *
     * @param id identificador del producto a eliminar
     * @return {@code true} si se encontró y eliminó el producto
     */
    public boolean eliminarPorId(int id) {
        List<Producto> productos = listarTodos();
        // removeIf devuelve true si eliminó al menos un elemento
        boolean eliminado = productos.removeIf(p -> p.getId() == id);

        if (eliminado) {
            guardarTodos(productos);
        }

        return eliminado;
    }

    // =========================================================================
    // Métodos privados de apoyo
    // =========================================================================

    /**
     * Reescribe el fichero completo con la lista de productos proporcionada.
     * Siempre incluye la cabecera como primera línea.
     *
     * @param productos lista de productos a persistir
     */
    private void guardarTodos(List<Producto> productos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO_CSV, false))) {
            pw.println(CABECERA);
            for (Producto p : productos) {
                pw.println(formatearLinea(p));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar CSV: " + e.getMessage());
        }
    }

    /**
     * Convierte una línea CSV en un {@link Optional}&lt;{@link Producto}&gt;.
     * Devuelve {@link Optional#empty()} si la línea está malformada.
     *
     * @param linea la línea CSV a parsear
     * @return el producto parseado, o vacío si hay error
     */
    private Optional<Producto> parsearLinea(String linea) {
        try {
            String[] campos = linea.split(SEPARADOR);
            if (campos.length != 4) return Optional.empty();

            int    id     = Integer.parseInt(campos[0].trim());
            String nombre = campos[1].trim();
            double precio = Double.parseDouble(campos[2].trim());
            int    stock  = Integer.parseInt(campos[3].trim());

            return Optional.of(new Producto(id, nombre, precio, stock));

        } catch (NumberFormatException e) {
            System.err.println("Línea CSV malformada ignorada: " + linea);
            return Optional.empty();
        }
    }

    /**
     * Convierte un {@link Producto} en una línea CSV formateada.
     *
     * @param p el producto a formatear
     * @return la línea CSV correspondiente
     */
    private String formatearLinea(Producto p) {
        return p.getId() + SEPARADOR
                + p.getNombre() + SEPARADOR
                + String.format("%.2f", p.getPrecio()) + SEPARADOR
                + p.getStock();
    }
}
