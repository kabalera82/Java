package Tema11Colecciones.Ejercicio02ArrayList.Ejercicio01Inicializar;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Incializa un ArrayList
 *
 * Clase de paquete java.util que implementa la interfaz List
 *
 * Tamaño Dinámico: Su tamaño puede crecer o reducirse automaticamente al añadir o eliminar.
 * Homogeneidad: Todos los elementos deben ser del mismo tipo
 * Índices: Se accede a todos los elementos por índices numéricos.
 *
 * <p>
 *     <h3>Métodos más Comunes</h3>
 *     <ul>
 *         <li>
 *             add(TipoElemento nombreElemento) -> Añade un elemento al final. ej: nombres.add("Marcos")
 *         </li>
 *         <li>
 *             add(int index, E e)-> Inserta en una posición concreta. ej: nombres.add(1, "Marcos")
 *         </li>
 *         <li>
 *             get(int index) -> Obtiene el elemento por índice.ej: nombres.get(0)
 *         </li>
 *         <li>
 *             set(int index, E e) -> Sustituye un elemento. ej: nombres.set(0, "Marcos")
 *         </li>
 *         <li>
 *             remove(int index) -> Elimina un elemento por índice. ej: nombres(1")
 *         </li>
 *         <li>
 *             remove(Object o) -> Elimina por valor, recorre y elimina todos lo coincidentes. ej: nombres.remove("Marcos")
 *         </li>
 *         <li>
 *             clear() -> elimina todos los elementos. ej: nombres.clear
 *         </li>
 *         <li>
 *             contains(Object o) -> Comrpueba si existe el elemento. ej: nombre.contains ("Marcos")
 *         </li>
 *         <li>
 *             indexOf(Object o) -> Comprueba la posición del elemento. ej: nombres.indexOf("Marcos")
 *         </li>
 *         <li>
 *             isEmpty() -> Verifica si esta vacío. ej: nombres.isEmpty()
 *         </li>
 *         <li>
 *             toString() -> Muestra el contenido en formato legible. ej: nombres.toString()
 *         </li>
 *     </ul>
 * </p>
 */

public class Inicializar {

    public static void main(String[] args) {
        ArrayList<String, int> nombres = new ArrayList<>(Arrays.asList(
                new Object("Marcos", 5),
                new Object("Maria", 2),
                new Object("Manuel", 8),
                new Object("Sofia", 4),
                new Object("Laia", 6),
                new Object("Alai", 3),
                new Object("Artai", 1)
        ));




    }
}
