# Tema 14 — Streams y Lambdas

> Prerequisito: Tema 12 (colecciones), Tema 09 (interfaces funcionales basicas)

Introduccion a la programación funcional con Streams en Java. Los Streams permiten procesar colecciones de forma declarativa — describimos QUE queremos, no COMO hacerlo.

---

## Teoria rapida

### Que es un Stream

```
Colección.stream()
    [operaciones intermedias — devuelven Stream, son lazy]
    .filter(Predicate)    <- filtra elementos
    .map(Function)        <- transforma cada elemento
    .sorted()             <- ordena
    .distinct()           <- elimina duplicados
    .limit(n)             <- toma los primeros n
    [operación terminal — consume el stream, produce resultado]
    .collect(Collectors.toList())
    .forEach(Consumer)
    .count()
    .findFirst()
    .reduce(...)
```

### Ejemplos basicos

```java
List<String> nombres = List.of("Ana", "Luis", "Maria", "Carlos", "Elena");

// Filtrar — nombres con mas de 4 letras
List<String> largos = nombres.stream()
    .filter(n -> n.length() > 4)
    .collect(Collectors.toList());  // ["Maria", "Carlos", "Elena"]

// Transformar — convertir a mayusculas
List<String> mayusculas = nombres.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// Contar
long cantidad = nombres.stream()
    .filter(n -> n.startsWith("A"))
    .count();   // 1

// Suma de numeros
List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
int sumaPares = nums.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(Integer::intValue)
    .sum();   // 30

// forEach
nombres.stream()
    .sorted()
    .forEach(System.out::println);
```

### Lambdas — sintaxis

```java
// Una lambda es una función anonima
(parametros) -> expresion
(parametros) -> { bloque de codigo }

// Ejemplos
n -> n % 2 == 0              // Predicate<Integer> — par
s -> s.toUpperCase()         // Function<String, String>
(a, b) -> a.compareTo(b)     // Comparator<String>
() -> System.out.println("!") // Runnable
```

---

## Ejercicios

| Archivo | Descripción |
|---------|------------|
| `Ejercicio01Hola.java` | Interfaz funcional custom con lambda |
| `Ejercicio02SaludoMultiple.java` | Metodo generico con interfaz funcional |
| `Ejercicio03StreamBasico.java` | `filter`, `map`, `sorted`, `distinct`, encadenado |
| `Ejercicio04Reduccion.java` | `count`, `sum`, `min`, `max`, `average`, `reduce`, `anyMatch` |
| `Ejercicio05MethodReference.java` | `::` — los 4 tipos de referencias a metodo |
| `Ejercicio06Optional.java` | `Optional` — evitar `NullPointerException` con elegancia |
| `ISaludo.java` | Interfaz funcional custom |
| `Cliente.java` | Clase modelo para ejercicios |
