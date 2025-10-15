package Tema11Colecciones.Ejercicio09TreeMap;


import java.util.*;

public class Ejercicio01 {
    public static void main(String[] args) {

        // 1️⃣ CREACIÓN DE TREEMAP ===========================================================
        // Orden natural (numérica ascendente)
        TreeMap<Integer, String> mapa = new TreeMap<>();

        // 2️⃣ MÉTODOS BÁSICOS DE MAP =======================================================
        mapa.put(30, "Carlos");
        mapa.put(10, "Ana");
        mapa.put(50, "Bea");
        mapa.put(40, "David");
        mapa.put(20, "Eva");

        System.out.println("Mapa inicial: " + mapa);

        // get / containsKey / containsValue
        System.out.println("Valor con clave 20: " + mapa.get(20));
        System.out.println("¿Contiene clave 10?: " + mapa.containsKey(10));
        System.out.println("¿Contiene valor 'Bea'?: " + mapa.containsValue("Bea"));

        // replace / putIfAbsent / getOrDefault
        mapa.replace(50, "Berta");
        mapa.putIfAbsent(60, "Fernando");
        System.out.println("Valor de 70 o por defecto: " + mapa.getOrDefault(70, "No existe"));

        // keySet / values / entrySet
        System.out.println("Conjunto de claves: " + mapa.keySet());
        System.out.println("Colección de valores: " + mapa.values());
        System.out.println("Conjunto de entradas: " + mapa.entrySet());

        // size / isEmpty
        System.out.println("Tamaño del mapa: " + mapa.size());
        System.out.println("¿Está vacío?: " + mapa.isEmpty());

        // remove
        mapa.remove(40);
        System.out.println("Después de eliminar clave 40: " + mapa);

        // 3️⃣ MÉTODOS DE SORTEDMAP =========================================================
        System.out.println("Comparador: " + mapa.comparator()); // null (orden natural)
        System.out.println("Primera clave: " + mapa.firstKey());
        System.out.println("Última clave: " + mapa.lastKey());

        // headMap, tailMap, subMap
        System.out.println("headMap(<30): " + mapa.headMap(30));       // claves < 30
        System.out.println("tailMap(30): " + mapa.tailMap(30));        // claves >= 30
        System.out.println("subMap(10, 40): " + mapa.subMap(10, 40));  // [10,40)

        // 4️⃣ MÉTODOS DE NAVIGABLEMAP =======================================================
        System.out.println("lowerKey(25): " + mapa.lowerKey(25));       // menor estricta
        System.out.println("floorKey(30): " + mapa.floorKey(30));       // menor o igual
        System.out.println("ceilingKey(30): " + mapa.ceilingKey(30));   // mayor o igual
        System.out.println("higherKey(30): " + mapa.higherKey(30));     // mayor estricta

        System.out.println("lowerEntry(25): " + mapa.lowerEntry(25));
        System.out.println("floorEntry(30): " + mapa.floorEntry(30));
        System.out.println("ceilingEntry(30): " + mapa.ceilingEntry(30));
        System.out.println("higherEntry(30): " + mapa.higherEntry(30));

        // firstEntry, lastEntry
        System.out.println("Primera entrada: " + mapa.firstEntry());
        System.out.println("Última entrada: " + mapa.lastEntry());

        // pollFirstEntry / pollLastEntry
        Map.Entry<Integer, String> primera = mapa.pollFirstEntry();
        System.out.println("Entrada extraída al principio: " + primera);
        Map.Entry<Integer, String> ultima = mapa.pollLastEntry();
        System.out.println("Entrada extraída al final: " + ultima);
        System.out.println("Mapa tras polls: " + mapa);

        // descendingMap, descendingKeySet
        System.out.println("Mapa descendente: " + mapa.descendingMap());
        System.out.println("Claves descendentes: " + mapa.descendingKeySet());

        // navigableKeySet (ascendente)
        System.out.println("navigableKeySet (asc): " + mapa.navigableKeySet());

        // subMap con inclusividad explícita
        mapa.put(15, "Julio");
        mapa.put(25, "Lucía");
        mapa.put(35, "Marta");
        System.out.println("Mapa actual: " + mapa);
        NavigableMap<Integer, String> sub = mapa.subMap(15, true, 35, true);
        System.out.println("Submap (15..35 inclusive): " + sub);

        // Modificar la vista también modifica el original
        sub.put(20, "Cambiado");
        System.out.println("Submap modificado: " + sub);
        System.out.println("Mapa original también cambiado: " + mapa);

        // 5️⃣ LIMPIAR ================================================================
        mapa.clear();
        System.out.println("Mapa después de clear(): " + mapa);
    }
}
