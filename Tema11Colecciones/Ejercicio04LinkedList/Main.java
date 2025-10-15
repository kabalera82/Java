package Tema11Colecciones.Ejercicio04LinkedList;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ CREACIÓN DE LINKEDLIST ===================================================
        LinkedList<String> lista = new LinkedList<>();

        // 2️⃣ AÑADIR ELEMENTOS =========================================================
        lista.add("Carlos");
        lista.add("Ana");
        lista.add("Bea");
        lista.add("David");
        lista.add("Eva");

        System.out.println("Lista inicial: " + lista);

        // addFirst / addLast
        lista.addFirst("Inicio");
        lista.addLast("Final");
        System.out.println("Después de addFirst y addLast: " + lista);

        // add en posición específica
        lista.add(3, "Marta");
        System.out.println("Después de insertar en índice 3: " + lista);

        // addAll
        List<String> extra = List.of("Lucía", "Pedro");
        lista.addAll(extra);
        System.out.println("Después de addAll(): " + lista);

        // 3️⃣ ACCESO Y MODIFICACIÓN ===================================================
        System.out.println("Primer elemento (getFirst): " + lista.getFirst());
        System.out.println("Último elemento (getLast): " + lista.getLast());
        System.out.println("Elemento en índice 2: " + lista.get(2));

        lista.set(2, "Cambiado");
        System.out.println("Después de set(2): " + lista);

        System.out.println("¿Contiene 'Ana'?: " + lista.contains("Ana"));
        System.out.println("Índice de 'Bea': " + lista.indexOf("Bea"));

        // 4️⃣ ELIMINAR ELEMENTOS =====================================================
        lista.remove(4); // por índice
        System.out.println("Después de remove(4): " + lista);

        lista.remove("Pedro"); // por objeto
        System.out.println("Después de remove(\"Pedro\"): " + lista);

        // removeFirst / removeLast
        lista.removeFirst();
        lista.removeLast();
        System.out.println("Después de removeFirst y removeLast: " + lista);

        // removeIf (Java 8+)
        lista.removeIf(nombre -> nombre.startsWith("C"));
        System.out.println("Después de removeIf(C...): " + lista);

        // 5️⃣ MÉTODOS DE COLA / PILA (Deque) ==========================================
        // LinkedList implementa Deque ⇒ se puede usar como cola o pila

        // 🔸 Cola FIFO
        lista.clear();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        System.out.println("\nCola inicial: " + lista);

        lista.offer("D"); // añade al final (cola)
        System.out.println("Después de offer(D): " + lista);

        System.out.println("peek (ver primero): " + lista.peek()); // A
        System.out.println("poll (extraer primero): " + lista.poll()); // A
        System.out.println("Después de poll: " + lista);

        // 🔸 Pila LIFO
        lista.push("X");
        lista.push("Y");
        System.out.println("\nComo pila después de push X,Y: " + lista);
        System.out.println("peek (cima): " + lista.peek()); // Y
        System.out.println("pop (sacar cima): " + lista.pop()); // Y
        System.out.println("Después de pop: " + lista);

        // 6️⃣ INFORMACIÓN Y SUBLISTAS ================================================
        lista.clear();
        lista.addAll(List.of("Zoe", "Luis", "Andrés", "Bea", "Carlos"));
        System.out.println("\nLista repoblada: " + lista);

        System.out.println("Tamaño: " + lista.size());
        System.out.println("¿Está vacía?: " + lista.isEmpty());

        List<String> sub = lista.subList(1, 4);
        System.out.println("Sublista (1..4): " + sub);

        // 7️⃣ RECORRER LISTA ==========================================================
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

        // 8️⃣ LIMPIAR ================================================================
        lista.clear();
        System.out.println("\nDespués de clear(): " + lista);
    }
}
