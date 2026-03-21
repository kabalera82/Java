package Tema11Colecciones.Ejercicio12;
/**
 * Ejercicio: Clasificación automática de números en un {@link java.util.TreeSet}.
 *
 * <p>Se desea diseñar un programa que lea números enteros introducidos por el usuario
 * y los almacene en un {@link java.util.TreeSet}, de modo que se mantengan <b>ordenados automáticamente
 * de menor a mayor</b> sin permitir duplicados.</p>
 *
 * <p>El objetivo es construir un sistema que permita:</p>
 * <ul>
 *   <li>Insertar números positivos en el conjunto. Si el número ya existe, no se vuelve a insertar.</li>
 *   <li>Mostrar en todo momento el conjunto ordenado (gracias al TreeSet) después de cada inserción.</li>
 *   <li>Calcular automáticamente:
 *       <ul>
 *           <li>El <b>número menor</b> y el <b>número mayor</b> del conjunto (usando {@code first()} y {@code last()}).</li>
 *           <li>El <b>número total de elementos</b> (sin duplicados).</li>
 *           <li>La <b>suma total</b> y la <b>media</b> de todos los números almacenados.</li>
 *       </ul>
 *   </li>
 *   <li>Permitir eliminar un número del conjunto y recalcular las estadísticas.</li>
 * </ul>
 *
 * <p>Este ejercicio es útil para practicar:</p>
 * <ul>
 *   <li>Uso de {@link java.util.TreeSet} para mantener datos ordenados automáticamente.</li>
 *   <li>Algoritmos básicos sobre conjuntos numéricos (mínimo, máximo, suma, media).</li>
 *   <li>Prevención de duplicados sin necesidad de condicionales adicionales.</li>
 *   <li>Uso de los métodos {@code first()}, {@code last()}, {@code size()}, y recorridos con bucles.</li>
 *   <li>Diseño de menús interactivos con lógica numérica.</li>
 * </ul>
 *
 * <p>Ejemplo de ejecución:</p>
 *
 * <pre>
 * Introduzca un número (0 para salir): 5
 * Conjunto actual: [5]
 * Mínimo: 5 | Máximo: 5 | Total: 1 | Suma: 5 | Media: 5.0
 *
 * Introduzca un número (0 para salir): 8
 * Conjunto actual: [5, 8]
 * Mínimo: 5 | Máximo: 8 | Total: 2 | Suma: 13 | Media: 6.5
 *
 * Introduzca un número (0 para salir): 5
 * El número 5 ya estaba en el conjunto.
 *
 * Introduzca un número (0 para salir): 2
 * Conjunto actual: [2, 5, 8]
 * Mínimo: 2 | Máximo: 8 | Total: 3 | Suma: 15 | Media: 5.0
 * </pre>
 *
 * <p>Este tipo de ejercicios ayuda a conectar la lógica de programación básica
 * (máximos, mínimos, sumas, duplicados) con estructuras de datos ordenadas como {@code TreeSet}.</p>
 */

public class Main {
}
