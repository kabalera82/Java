package Tema10_01FicherosDeTexto.Ejercicio02Bonana.model;

import java.util.Objects;

/**
 * POJO que representa una fruta del inventario.
 * Gestiona automáticamente el ID y asegura que no haya duplicados.
 */
public class Frutas {

    /** Contador estático para asignar IDs únicos */
    private static int contador = 1;

    /** Identificador único */
    private int id;

    /** Nombre de la fruta */
    private String nombre;

    /** Precio por kilogramo */
    private double precioKg;

    /** Stock disponible en kilogramos */
    private int stockKg;

    // ===================== CONSTRUCTORES =====================

    /**
     * Constructor con parámetros principales.
     * Asigna automáticamente un ID incremental.
     */
    public Frutas(String nombre, double precioKg, int stockKg) {
        this.id = contador++;
        this.nombre = nombre;
        this.precioKg = precioKg;
        this.stockKg = stockKg;
    }

    /**
     * Constructor usado al cargar frutas desde archivo.
     * Actualiza el contador si es necesario para evitar colisiones de ID.
     */
    public Frutas(int id, String nombre, double precioKg, int stockKg) {
        this.id = id;
        this.nombre = nombre;
        this.precioKg = precioKg;
        this.stockKg = stockKg;

        if (id >= contador) {
            contador = id + 1;
        }
    }

    // ===================== GETTERS & SETTERS =====================

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioKg() { return precioKg; }

    public void setPrecioKg(double precioKg) { this.precioKg = precioKg; }

    public int getStockKg() { return stockKg; }

    public void setStockKg(int stockKg) { this.stockKg = stockKg; }

    // ===================== MÉTODOS DE OBJETO =====================

    @Override
    public String toString() {
        return  "---------------------------------------\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio/kg: " + precioKg + " €\n" +
                "Stock/kg: " + stockKg + "\n" +
                "---------------------------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frutas frutas = (Frutas) o;
        return id == frutas.id &&
                Double.compare(frutas.precioKg, precioKg) == 0 &&
                stockKg == frutas.stockKg &&
                Objects.equals(nombre, frutas.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precioKg, stockKg);
    }
}
