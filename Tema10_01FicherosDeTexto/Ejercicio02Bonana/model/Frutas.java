package Tema10_01FicherosDeTexto.Ejercicio02Bonana.model;

/**
 * POJO que representa una fruta del inventario.
 */
public class Frutas {
    // Atributos ===================
    /** contador estático para asignar IDs únicos */
    private static int contador = 1;
    /** identificador único */
    private int id;
    /** nombre del producto */
    private String nombre;
    /** precio en kg del producto */
    private double precioKg;
    /** stock actual del producto */
    private int stockKg;

    // Constructor ===========================
    /**
     * Constructor con parámetros.
     * Asigna un ID autoincremental a cada instancia.
     * @param nombre nombre de la fruta
     * @param precioKg precio por kilogramo
     * @param stockKg stock disponible en kilogramos
     */
    public Frutas(String nombre, double precioKg, int stockKg) {
        this.id = contador++;
        this.nombre = nombre;
        this.precioKg = precioKg;
        this.stockKg = stockKg;
    }

    // Getters & Setters ====================

    /**
     * Devuelve el ID de la fruta.
     * @return id de la fruta
     */
    public int getId() { return id; }

    /**
     * Devuelve el nombre de la fruta.
     * @return nombre de la fruta
     */
    public String getNombre() { return nombre; }

    /**
     * Asigna el nombre de la fruta.
     * @param nombre nombre a establecer
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Devuelve el precio de la fruta por kilogramo.
     * @return precio por kilogramo
     */
    public double getPrecioKg() { return precioKg; }

    /**
     * Asigna el precio por kilogramo de la fruta.
     * @param precioKg nuevo precio por kilogramo
     */
    public void setPrecioKg(double precioKg) { this.precioKg = precioKg; }

    /**
     * Devuelve el stock actual de la fruta.
     * @return stock en kilogramos
     */
    public int getStockKg() { return stockKg; }

    /**
     * Asigna el stock actual de la fruta.
     * @param stockKg stock a establecer
     */
    public void setStockKg(int stockKg) { this.stockKg = stockKg; }

    // Método toString =======================
    /**
     * Representación en texto de la fruta.
     * @return cadena con los datos de la fruta
     */
    @Override
    public String toString() {
        return  "---------------------------------------\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio/kg: " + precioKg + "\n" +
                "Stock/kg: " + stockKg + "\n" +
                "---------------------------------------";
    }
}
