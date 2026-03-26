package Tema11_03CSV.Ejercicio04AppCompleto;

/**
 * Modelo de dominio que representa un producto del catálogo.
 *
 * <p><b>[APRENDE] — POJO y modelo de dominio</b><br>
 * Un POJO (<em>Plain Old Java Object</em>) es una clase Java sin dependencias
 * de frameworks. Aquí el modelo solo conoce sus propios datos. La lógica de
 * persistencia CSV vive en {@link ProductoCSVDao}, no aquí. Esto respeta el
 * principio de <em>Separación de Responsabilidades</em> (SRP de SOLID).</p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Producto {

    /** Identificador único del producto. */
    private int id;

    /** Nombre descriptivo del producto. */
    private String nombre;

    /** Precio de venta en euros. */
    private double precio;

    /** Unidades disponibles en almacén. */
    private int stock;

    // ===================== CONSTRUCTOR =====================

    /**
     * Crea un nuevo producto con todos sus campos.
     *
     * @param id     identificador único
     * @param nombre nombre del producto
     * @param precio precio en euros
     * @param stock  unidades en stock
     */
    public Producto(int id, String nombre, double precio, int stock) {
        this.id     = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock  = stock;
    }

    // ===================== GETTERS & SETTERS =====================

    /** @return el id del producto */
    public int getId() { return id; }

    /** @return el nombre del producto */
    public String getNombre() { return nombre; }

    /** @return el precio del producto */
    public double getPrecio() { return precio; }

    /**
     * Actualiza el precio del producto.
     *
     * @param precio nuevo precio (debe ser &gt;= 0)
     */
    public void setPrecio(double precio) { this.precio = precio; }

    /** @return el stock del producto */
    public int getStock() { return stock; }

    // ===================== toString =====================

    @Override
    public String toString() {
        return String.format("Producto { id=%d, nombre='%s', precio=%.2f€, stock=%d }",
                id, nombre, precio, stock);
    }
}
