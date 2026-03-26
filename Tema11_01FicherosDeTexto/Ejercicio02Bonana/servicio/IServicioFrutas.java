package Tema11_01FicherosDeTexto.Ejercicio02Bonana.servicio;

import Tema11_01FicherosDeTexto.Ejercicio02Bonana.model.Frutas;
import java.util.List;

/**
 * Interfaz que define las operaciones principales sobre las frutas.
 */
public interface IServicioFrutas {

    /** Añade una fruta a la lista en memoria. */
    void addFruta(Frutas fruta);

    /** Lista todas las frutas actualmente en memoria. */
    void listFruta();

    /** Devuelve la lista de frutas (para guardar o exportar). */
    List<Frutas> getFrutas();
}
