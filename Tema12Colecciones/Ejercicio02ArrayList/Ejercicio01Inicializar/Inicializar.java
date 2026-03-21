package Tema11Colecciones.Ejercicio02ArrayList.Ejercicio01Inicializar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Incializa un ArrayList
 * <p>
 * Clase de paquete java.util que implementa la interfaz List
 * <p>
 * Tamaño Dinámico: Su tamaño puede crecer o reducirse automaticamente al añadir o eliminar.
 * Homogeneidad: Todos los elementos deben ser del mismo tipo
 * Índices: Se accede a todos los elementos por índices numéricos.
 *
 * <p>
 * <h3>Métodos más Comunes</h3>
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

    // Instanciamos La lista de Objetos
    private static ArrayList<Object> listaPruebas = new ArrayList<>();
    private static ArrayList<String> listaNombres = new ArrayList<>();


    public static void main(String[] args) {

        /**
         * Incializamos añadiendo elementos
         */
        //add
        listaNombres.add("Marcos");
        listaNombres.add("Maria");
        // Array list de Objeto "como una lista" asList
        listaPruebas.add(Arrays.asList("Marcos", "Padilla", "Puentes", 42));
        listaPruebas.add(Arrays.asList("Maria", "Lobera", "Lobera", 33));
        listaPruebas.add(Arrays.asList("Alai", "Padilla", "Lobera", 8));
        listaPruebas.add(Arrays.asList("Laia", "Padilla", "Lobera", 3));
        listaPruebas.add(Arrays.asList("Artai", "Padilla", "Lobera", 1));

        // add(segun indice)
        listaNombres.add(0, "Artai");
        // Recuperamos el elemento
        System.out.println("---- GET ----- ");
        System.out.println(listaNombres.get(0));
        System.out.println(listaPruebas.get(0));

        // Esto no hace nada -> listaNombres.toString();
        // Esto no hace nada -> listaPruebas.toString();

        // Set va con indice
        System.out.println("----- SET ------");
        listaPruebas.set(2,"Alia");
        System.out.println(listaPruebas);
        // remove
        listaPruebas.remove(2);
        System.out.println(listaPruebas);

        // Contains
        System.out.println("----- CONTAINS ------");
        System.out.println(listaNombres.contains("Antonio"));
        System.out.println(listaNombres.contains("Marcos"));

        // indexOf Co

        /**
         * - - - Bucle for Clasico - - -
         *
         */
        System.out.println("------------ FOR ---------------");
        for(int i= 0; i<listaPruebas.size();i++){
            Object persona = listaPruebas.get(i);
            System.out.println(
            "En el objeto persona en la posición: " + i + "\n" +
            persona.toString().toLowerCase().contains("marcos")
            );
        }

        /**
         *  - - - Do - - -
         */
        System.out.println("------------ DO ---------------");
        int i= 0;
        while ( i < listaPruebas.size()){

            System.out.println(listaPruebas.get(i));
            i++;
        }

        /**
         *  - - - - for Each Clasico - - - - -
         */
        System.out.println("------------ FOR EACH---------------");
        for (Object lista : listaPruebas){
            System.out.println(lista);
        }
        /**
         *  - - - - for Each lambda
         */
        System.out.println("------------ FOR EACH lambda ---------------");
        listaPruebas.forEach ( lista ->
                        System.out.println(lista)
                );
        System.out.println("------------ FOR EACH STREAMS refencia a metodo ---------------");
        listaPruebas.forEach (System.out::println);
        System.out.println("------------ FOR EACH lambda ---------------");

        //Contains
        listaPruebas.forEach(persona -> {
            boolean encontrado = persona.toString().toLowerCase().contains("marcos");
            System.out.println("Persona: " + persona);
            System.out.println("¿Contiene 'marcos'? " + encontrado + "\n");
        });
        System.out.println("------------  streams ---------------");
        listaPruebas.stream()
                .filter(persona -> persona.toString().toLowerCase().contains("marcos"))
                .forEach(persona -> System.out.println("Encontrado: " + persona));

        // Clear
        listaPruebas.clear();
        listaNombres.clear();
        System.out.println(listaNombres);
        System.out.println(listaPruebas);

    }
}
