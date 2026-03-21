# Tema 11 — Colecciones

> Prerequisito: Tema 07 (clases), Tema 09 (interfaces), Generics basicos

El framework de colecciones de Java — estructuras de datos dinamicas para almacenar y manipular grupos de objetos.

> ⚠️ **Pendiente:** corregir numeracion duplicada (dos Ejercicio04, dos Ejercicio06).

---

## Teoria rapida

### Jerarquía de colecciones

```
Collection
├── List — elementos ordenados, permite duplicados
│   ├── ArrayList     ← array dinamico, acceso por índice O(1)
│   ├── LinkedList    ← lista enlazada, insercion/eliminacion O(1)
│   └── Vector        ← como ArrayList pero sincronizado (legacy)
│
├── Set — sin duplicados
│   ├── HashSet       ← sin orden, busqueda O(1)
│   ├── LinkedHashSet ← mantiene orden de insercion
│   └── TreeSet       ← ordenado naturalmente, O(log n)
│
└── Queue / Deque — FIFO / doble extremo
    ├── LinkedList    ← implementa Queue y Deque
    ├── ArrayDeque    ← la mas eficiente como pila y cola
    └── PriorityQueue ← cola con prioridad

Map — pares clave-valor (NO extiende Collection)
├── HashMap       ← sin orden, O(1) para get/put
├── LinkedHashMap ← mantiene orden de insercion
└── TreeMap       ← ordenado por clave, O(log n)
```

### ArrayList — la mas usada

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> lista = new ArrayList<>();
lista.add("Ana");
lista.add("Luis");
lista.add("Maria");

lista.get(0)        // "Ana"
lista.size()        // 3
lista.contains("Luis") // true
lista.remove("Luis")   // elimina por valor
lista.remove(0)        // elimina por índice

// Ordenar
Collections.sort(lista);          // orden natural
Collections.sort(lista, Comparator.reverseOrder());  // orden inverso

// Iterar
for (String s : lista) { ... }
lista.forEach(System.out::println);
```

### HashMap — pares clave-valor

```java
import java.util.HashMap;

HashMap<String, Integer> edades = new HashMap<>();
edades.put("Ana", 25);
edades.put("Luis", 30);
edades.put("Maria", 22);

edades.get("Ana")           // 25
edades.containsKey("Luis")  // true
edades.containsValue(22)    // true
edades.size()               // 3
edades.remove("Luis")       // elimina la entrada

// Iterar sobre claves
for (String clave : edades.keySet()) {
    System.out.println(clave + ": " + edades.get(clave));
}

// Iterar sobre entradas (mas eficiente)
for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
    System.out.println(entrada.getKey() + " → " + entrada.getValue());
}

// getOrDefault — evita NullPointerException
int edad = edades.getOrDefault("Pedro", 0);  // 0 si no existe
```

### HashSet — sin duplicados

```java
HashSet<String> set = new HashSet<>();
set.add("rojo");
set.add("azul");
set.add("rojo");  // no se añade (duplicado)
set.size()        // 2

// Operaciones de conjunto
set1.addAll(set2);      // union
set1.retainAll(set2);   // interseccion
set1.removeAll(set2);   // diferencia
```

### ArrayDeque — pila y cola

```java
ArrayDeque<Integer> deque = new ArrayDeque<>();

// Usar como PILA (LIFO)
deque.push(1);   deque.push(2);   deque.push(3);
deque.pop()      // 3 — último en entrar, primero en salir

// Usar como COLA (FIFO)
deque.offer(1);  deque.offer(2);  deque.offer(3);
deque.poll()     // 1 — primero en entrar, primero en salir
```

---

## Ejercicios

| Carpeta | Descripción |
|---------|------------|
| `Ejercicio01Arrays/` | Conversion entre array y colección (`Arrays.asList`) |
| `Ejercicio02ArrayList/` | Operaciones con `ArrayList` |
| `Ejercicio03pila/` | Implementar pila con `LinkedList` o `ArrayDeque` |
| `Ejercicio04LinkedList/` | Operaciones con `LinkedList` |
| `Ejercicio04Map/` | `HashMap` — pares clave-valor ⚠️ numero duplicado |
| `Ejercicio05ArrayList/` | ArrayList avanzado |
| `Ejercicio06HashSet/` | Operaciones con `HashSet` |
| `Ejercicio06LinkedHashSet/` | `LinkedHashSet` — set con orden de insercion ⚠️ numero duplicado |
| `Ejercicio07TreeSet/` | `TreeSet` — set ordenado naturalmente |
| `Ejercicio08LinkedHashMap/` | `LinkedHashMap` — mapa con orden de insercion |
| `Ejercicio09TreeMap/` | `TreeMap` — mapa ordenado por clave |
| `Ejercicio10HashMap/` | HashMap avanzado |
| `Ejercicio11Generico/` | Clase generica con colección |
| `Ejercicio12/` | Ejercicio combinado de colecciones |
| `Colecciones.png` | Diagrama del jerarquía de colecciones |

> ⚠️ **Pendiente:** renombrar `Ejercicio04Map` y `Ejercicio06LinkedHashSet` para que los numeros sean unicos.
