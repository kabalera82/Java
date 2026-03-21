package Tema11Colecciones.Ejercicio05ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ejercicio01 {


    public static void main(String[] args) {

        // 1️⃣ CREACIÓN DE ARRAYLIST ===================================================
        ArrayList<String> lista = new ArrayList<>(); // vacía

        // 2️⃣ AÑADIR ELEMENTOS =======================================================
        lista.add("Carlos");
        lista.add("Ana");
        lista.add("Bea");
        lista.add("David");
        lista.add("Eva");

        System.out.println("Lista inicial: " + lista);

        // add en posición específica
        lista.add(2, "Marta");
        System.out.println("Después de insertar en índice 2: " + lista);

        // addAll (añadir colección completa)
        List<String> extra = List.of("Lucía", "Pedro");
        lista.addAll(extra);
        System.out.println("Después de addAll(): " + lista);

        // 3️⃣ ACCESO Y MODIFICACIÓN ===================================================
        // get
        System.out.println("Elemento en índice 3: " + lista.get(3));

        // set (modificar en posición)
        lista.set(3, "Diana");
        System.out.println("Después de modificar índice 3: " + lista);

        // contains
        System.out.println("¿Contiene 'Ana'?: " + lista.contains("Ana"));

        // indexOf / lastIndexOf
        lista.add("Ana");
        System.out.println("Primera posición de 'Ana': " + lista.indexOf("Ana"));
        System.out.println("Última posición de 'Ana': " + lista.lastIndexOf("Ana"));

        // 4️⃣ ELIMINAR ELEMENTOS =====================================================
        // remove por índice
        lista.remove(2);
        System.out.println("Después de remove(2): " + lista);

        // remove por objeto
        lista.remove("Lucía");
        System.out.println("Después de remove(\"Lucía\"): " + lista);

        // removeAll (eliminar todos los elementos de una colección)
        lista.removeAll(List.of("Pedro", "Ana"));
        System.out.println("Después de removeAll(): " + lista);

        // retainAll (mantener solo los de una colección)
        lista.retainAll(List.of("Carlos", "Eva"));
        System.out.println("Después de retainAll(): " + lista);

        // clear (vaciar lista)
        lista.clear();
        System.out.println("Después de clear(): " + lista);

        // 5️⃣ REPOBLAR PARA DEMOSTRAR MÁS MÉTODOS ===================================
        lista.addAll(List.of("Zoe", "Luis", "Andrés", "Bea", "Carlos"));
        System.out.println("\nLista repoblada: " + lista);

        // size / isEmpty
        System.out.println("Tamaño de la lista: " + lista.size());
        System.out.println("¿Está vacía?: " + lista.isEmpty());

        // subList
        List<String> sub = lista.subList(1, 4);
        System.out.println("Sublista (1..4): " + sub);

        // sort
        Collections.sort(lista);
        System.out.println("Lista ordenada alfabéticamente: " + lista);

        // reverse
        Collections.reverse(lista);
        System.out.println("Lista en orden inverso: " + lista);

        // 6️⃣ RECORRER LISTA =========================================================
        System.out.println("\n--- For clásico ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Índice " + i + ": " + lista.get(i));
        }

        System.out.println("\n--- For-each ---");
        for (String nombre : lista) {
            System.out.println(nombre);
        }

        System.out.println("\n--- Iterator ---");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String nombre = it.next();
            System.out.println(nombre);
        }

        // 7️⃣ removeIf (Java 8+)
        lista.removeIf(nombre -> nombre.startsWith("C"));
        System.out.println("Después de removeIf(C...): " + lista);

        // 8️⃣ replaceAll (Java 8+)
        lista.replaceAll(nombre -> nombre.toUpperCase());
        System.out.println("Después de replaceAll(toUpperCase): " + lista);
    }
}


