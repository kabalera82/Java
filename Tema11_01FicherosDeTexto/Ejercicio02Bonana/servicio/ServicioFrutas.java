package Tema11_01FicherosDeTexto.Ejercicio02Bonana.servicio;

import Tema11_01FicherosDeTexto.Ejercicio02Bonana.model.Frutas;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implementación del servicio de frutas.
 * Contiene la lógica de negocio y validación básica.
 */
public class ServicioFrutas implements IServicioFrutas {

    /** Lista en memoria de frutas */
    private final List<Frutas> frutas;

    /** Constructor: inicia una lista vacía */
    public ServicioFrutas() {
        this.frutas = new ArrayList<>();
    }

    /**
     * Agrega una fruta con validaciones básicas.
     */
    @Override
    public void addFruta(Frutas fruta) {
        Predicate<Frutas> validacion = f ->
                f != null &&
                        f.getNombre() != null && f.getNombre().trim().length() >= 2 &&
                        f.getPrecioKg() >= 0 &&
                        f.getStockKg() >= 0;

        if (validacion.test(fruta)) {
            frutas.add(fruta);
            System.out.println("✅ Fruta añadida correctamente: " + fruta.getNombre());
        } else {
            System.out.println("❌ Datos inválidos o fruta nula.");
        }
    }

    /**
     * Lista las frutas en consola.
     */
    @Override
    public void listFruta() {
        if (frutas.isEmpty()) {
            System.out.println("📭 No hay frutas registradas.");
        } else {
            System.out.println("=== LISTADO DE FRUTAS ===");
            frutas.forEach(System.out::println);
        }
    }

    /** Devuelve la lista actual en memoria. */
    @Override
    public List<Frutas> getFrutas() {
        return frutas;
    }
}
