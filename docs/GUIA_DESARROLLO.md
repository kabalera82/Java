# Guia de Desarrollo — Java 1ºDAM
> Estado del repositorio, propuesta de temario, bugs pendientes y hoja de ruta

---

## Índice

1. [Estado actual](#1-estado-actual)
2. [Acciones inmediatas — seguridad y basura](#2-acciones-inmediatas--seguridad-y-basura)
3. [Bugs y correcciones pendientes](#3-bugs-y-correcciones-pendientes)
4. [Orden propuesto del temario](#4-orden-propuesto-del-temario)
5. [Temas que faltan por desarrollar](#5-temas-que-faltan-por-desarrollar)
6. [Mejoras por tema](#6-mejoras-por-tema)
7. [Problemas estructurales](#7-problemas-estructurales)
8. [Convenios de codigo](#8-convenios-de-codigo)
9. [Relacion con Java2 (2ºDAM)](#9-relacion-con-java2-2dam)
10. [Hoja de ruta — checkboxes](#10-hoja-de-ruta--checkboxes)

---

## 1. Estado actual

### Resumen por tema

| Carpeta | Estado | Crítico |
|---------|--------|---------|
| `Tema01ConceptosBasicos` | ✅ Completo — 17 ejercicios | No |
| `Tema02Condicionales` | ✅ Completo — 20 ejercicios | No |
| `Tema03Bucles` | ✅ Completo — 20 ejercicios | No |
| `Tema04_01Metodos` | ✅ Completo — 20 ejercicios | No |
| `Tema04_02VarArgs` | ✅ Funcional — 4 ejercicios | No |
| `Tema04_03Polimorfismo` | ⚠️ Escaso — 1 ejercicio | Si |
| `Tema05_01Tablas` | ✅ Completo — 15 ejercicios | No |
| `Tema05_02MatricesArrays` | ✅ Completo — 8 ejercicios | No |
| `Tema06CadenasDeCaracteres` | ⚠️ Muy escaso — 2 ejercicios | Si |
| `Tema07Clases` | ✅ Funcional — 8 ejercicios | No |
| `Tema08_01Herencia` | ⚠️ Incompleto — falta Ej02 | No |
| `Tema08_02InstanceOf` | ✅ Funcional — 2 ejercicios | No |
| `Tema09Interfaces` | ✅ Funcional — 4 ejercicios | No |
| `Tema10_01FicherosDeTexto` | ✅ Funcional — 2 ejercicios | No |
| `Tema10_02FicherosBinarios` | ✅ Funcional — 5 ejercicios | No |
| `Tema11Colecciones` | ⚠️ Numeracion duplicada | No |
| `Tema12AcesoDatos` | ⚠️ Typo + falta Ej04 | No |
| `Tema13Streams` | ⚠️ Muy escaso — 3 archivos | Si |
| `Tema14Threads` | ⚠️ Escaso — 3 ejercicios | Si |
| `Tema15JPA` | 🔴 Bug de seguridad + malnombrado | Si |
| `Tema16JavaServerPages` | 🔴 Completamente vacio | Si |
| `Tema17ProgramacionFuncional` | ⚠️ Duplicado de Java2 | Si |
| `Tema18ProgramacionRed` | ⚠️ Duplicado de Java2 | Si |
| `Tema19ContructorProcesos` | ⚠️ Duplicado de Java2 | Si |
| `Tema20Interfaces` | ⚠️ Solo Swing01 — mal ubicado | No |
| `Tema99EjerciciosMultiples` | ⚠️ Sin organizacion | No |

### Archivos en la raíz que deben eliminarse

| Archivo | Problema |
|---------|---------|
| `red.text` | 🔴 Salida de ipconfig con IPs reales — SEGURIDAD |
| `errores.txt` | Archivo vacio — basura |
| `Readme.txt` | Reemplazado por `README.md` |

---

## 2. Acciones inmediatas — seguridad y basura

**Hacer ANTES de cualquier otra cosa:**

### Eliminar `red.text`

Contiene la salida del comando `ipconfig` de Windows con información de red real:
- IP local: `192.168.1.133`
- IPv6: `2a0c:5a80:3c09:f100:4106:f7bc:da5b:fea`
- Gateway: `192.168.1.1`

Este archivo fue committeado accidentalmente. Eliminarlo del repo y de la historia si es necesario:
```bash
git rm red.text
git commit -m "chore: remove accidental ipconfig output"
# Si ya esta en commits anteriores:
git filter-branch --force --index-filter "git rm --cached --ignore-unmatch red.text" HEAD
```

### Eliminar `errores.txt`

Archivo vacio. Sin proposito. Eliminar.

### Sacar la password de `Tema15JPA/Conexión.java`

```java
// ACTUAL — password root en repo público de GitHub
private static final String PASSWORD = "221182";

// CORRECCION — variable de entorno
private static final String PASSWORD = System.getenv("DB_PASSWORD");

// O mejor — fichero de propiedades en .gitignore:
// database.properties:
//   db.url=jdbc:mysql://localhost:3306/tutorial
//   db.user=root
//   db.password=221182
```

Añadir al `.gitignore`:
```
database.properties
*.local.properties
application-local.properties
```

---

## 3. Bugs y correcciones pendientes

### Tema11 — Colecciones: numeracion duplicada

```
Ejercicio04LinkedList/  ← Ejercicio04 × 2
Ejercicio04Map/         ← Ejercicio04 × 2

Ejercicio06HashSet/     ← Ejercicio06 × 2
Ejercicio06LinkedHashSet/ ← Ejercicio06 × 2
```

**Propuesta de renombracion:**
```
Ejercicio04LinkedList/  → queda como Ejercicio04
Ejercicio04Map/         → renombrar a Ejercicio05Map
Ejercicio05ArrayList/   → renombrar a Ejercicio06ArrayList
Ejercicio06HashSet/     → renombrar a Ejercicio07HashSet
Ejercicio06LinkedHashSet/ → renombrar a Ejercicio08LinkedHashSet
... (ajustar numeros sucesivos)
```

---

### Tema08 — Herencia: falta Ejercicio02

```
Ejercicio01Vehiculos/   ← existe
                        ← Ejercicio02 AUSENTE
Ejercicio03Planta/      ← existe
```

Opciones:
1. Crear `Ejercicio02` con un ejercicio nuevo (jerarquía de figuras, animales, etc.)
2. Renombrar `Ejercicio03Planta/` a `Ejercicio02Planta/` si el ejercicio perdido no existe

---

### Tema12 — AccesoDatos: typo + falta ejercicio

1. **Typo en nombre:** `Tema12AcesoDatos` → `Tema12AccesoDatos` (doble 'c')
   ```bash
   git mv Tema12AcesoDatos Tema12AccesoDatos
   ```

2. **Numeracion rota:** `ejercicio03` → salta a `ejercicio05json`
   - Crear `ejercicio04` o renombrar `ejercicio05` y `ejercicio06` a `ejercicio04` y `ejercicio05`

---

### Archivos con acentos en nombre

```bash
# Renombrar para evitar problemas en Windows/Linux
git mv "Tema01ConceptosBasicos/Ejercicio03OperadoresAritméticos.java" \
       "Tema01ConceptosBasicos/Ejercicio03OperadoresAritmeticos.java"

git mv "Tema05_02MatricesArrays/Ejercicio07MétodosBusqueda.java" \
       "Tema05_02MatricesArrays/Ejercicio07MetodosBusqueda.java"
```

---

### Tema15JPA: paquete duplicado

Dentro del mismo proyecto Maven hay dos arboles de clases identicos:
- `src/main/java/org/kabalera82/...`
- `src/main/java/tech/Kabadev/...`

**Eliminar el paquete `org.kabalera82` completo** — es la versión anterior. La versión `tech.Kabadev` es la mas reciente y completa (tiene Javadoc).

---

### Tema15JPA: nombre incorrecto

El tema se llama JPA pero usa JDBC (`java.sql.*`, `DriverManager`). JPA requeriria:
- Hibernate o EclipseLink
- Anotaciones `@Entity`, `@Table`, `@Id`, `@GeneratedValue`
- `EntityManager` en lugar de `Connection`

**Renombrar carpeta:**
```bash
git mv Tema15JPA Tema15JDBC
```

---

### Tema16JavaServerPages: proyecto completamente vacio

`Main.java` es el placeholder de IntelliJ con `main` vacio. No hay codigo JSP, no hay dependencias de servlet.

**Opciones:**
1. Implementar un ejemplo JSP básico (requiere Tomcat y dependencias en pom.xml)
2. Renombrar a `Tema16HttpURLConnection` y hacer un cliente HTTP con `HttpURLConnection` o `java.net.http.HttpClient` (Java 11+) — mas alineado con 1ºDAM
3. Eliminar si no va a desarrollarse

---

## 4. Orden propuesto del temario

### Justificacion del orden actual vs propuesto

El orden actual tiene dos problemas:
1. Los temas 17, 18, 19 (Lambdas avanzadas, Sockets, ProcessBuilder) son de 2ºDAM y no deben estar aqui
2. Falta completamente el tema de Excepciones, que deberia ir despues de Metodos

### Orden propuesto para 1ºDAM

```
01 — Conceptos basicos           (= Tema01 actual)
02 — Condicionales                (= Tema02 actual)
03 — Bucles                       (= Tema03 actual)
04 — Metodos                      (= Tema04_01 + Tema04_02 unificados)
05 — Arrays                       (= Tema05_01 + Tema05_02 unificados)
06 — Cadenas                      (= Tema06 actual — AMPLIAR)
07 — Clases y POO                 (= Tema07 actual)
08 — Herencia y Polimorfismo      (= Tema08_01 + Tema04_03 unificados — COMPLETAR)
09 — Interfaces                   (= Tema09 actual)
10 — Excepciones                  (CREAR — completamente ausente)
11 — Ficheros                     (= Tema10_01 + Tema10_02 unificados)
12 — Colecciones                  (= Tema11 actual — CORREGIR NUMERACION)
13 — Acceso a datos               (= Tema12 actual — RENOMBRAR + completar)
14 — Streams introductorios       (= Tema13 actual — AMPLIAR)
15 — Hilos                        (= Tema14 actual — AMPLIAR)
16 — JDBC                         (= Tema15 actual — RENOMBRAR + limpiar)
17 — Swing                        (= Tema20Interfaces/Swing — MOVER + AMPLIAR)
```

### Temas de 2ºDAM que no deben estar en este repo

- `Tema17ProgramacionFuncional` — Lambdas avanzadas, Collectors, parallelStream
- `Tema18ProgramacionRed` — Sockets TCP, ServerSocket
- `Tema19ContructorProcesos` — ProcessBuilder avanzado con Maven

---

## 5. Temas que faltan por desarrollar

### CRITICO — Excepciones (completamente ausente)

Es uno de los temas fundamentales de Java y no existe ningun ejercicio dedicado.

**Estructura propuesta:**
```
10-excepciones/
├── README.md
├── Ejercicio01TryCatch.java           try-catch básico con NumberFormatException
├── Ejercicio02MultiplesCatch.java     varios bloques catch, orden importa
├── Ejercicio03Finally.java            bloque finally para limpieza
├── Ejercicio04ThrowThrows.java        throw y declaracion con throws
├── Ejercicio05ExcepcionPersonalizada.java  CustomException extends RuntimeException
├── Ejercicio06TryWithResources.java   try-with-resources con BufferedReader
└── Ejercicio07JerarquiaExcepciones.java   Error vs Exception vs RuntimeException
```

**Conceptos clave:**
```java
// Jerarquía
Throwable
├── Error                    (no checked: OutOfMemoryError, StackOverflowError)
└── Exception
    ├── RuntimeException     (no checked: NPE, ArrayIndexOutOfBounds, ClassCast)
    └── IOException, SQLException  (checked: hay que declarar o capturar)

// Crear excepción personalizada
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(double importe) {
        super("Saldo insuficiente: " + importe + " €");
    }
}

// throws en la firma del metodo (excepciones checked)
public void leerFichero(String ruta) throws IOException {
    // ...
}
```

---

### IMPORTANTE — Cadenas (ampliar Tema06 de 2 a 12 ejercicios)

**Ejercicios pendientes:**
1. Contar vocales y consonantes en una cadena
2. Revertir una cadena sin `StringBuilder.reverse()`
3. Palindromo: comprobar si una cadena se lee igual al reves
4. Contar palabras en una oracion
5. Cifrado Cesar: desplazar cada letra N posiciones
6. Validar email con `contains()` e `indexOf()`
7. Anagrama: dos palabras son anagrama si tienen las mismas letras
8. `StringBuilder` en un bucle vs `String +=` — benchmark de rendimiento
9. Expresiones regulares: `String.matches()`, `Pattern`, `Matcher`
10. `String.format()` y `printf` con distintos tipos

---

### IMPORTANTE — Polimorfismo completo (ampliar Tema04_03 y Tema08)

**Lo que falta:**
```java
// Clases abstractas — no se pueden instanciar
abstract class Figura {
    public abstract double area();    // obliga a implementar
    public void mostrar() { System.out.println("Area: " + area()); }
}

// Polimorfismo con colección
List<Figura> figuras = List.of(new Circulo(5), new Rectangulo(4, 3));
figuras.forEach(Figura::mostrar);  // cada figura calcula su area
```

---

### UTIL — Enumeraciones (`enum`)

No hay ningun ejercicio de `enum` en el repo. Deberia ir en Tema07 o Tema09.

```java
public enum Estado { ACTIVO, INACTIVO, SUSPENDIDO; }
public enum DiaSemana {
    LUNES, MARTES, ..., DOMINGO;
    public boolean esLaboral() { return this != SABADO && this != DOMINGO; }
}
```

---

### UTIL — Generics basicos

Prerequisito real para entender las colecciones y los Streams. Cero ejercicios dedicados.

```java
public class Caja<T> {
    private T contenido;
    public void guardar(T item) { contenido = item; }
    public T sacar() { return contenido; }
}

public static <T extends Comparable<T>> T maximo(T a, T b) {
    return a.compareTo(b) >= 0 ? a : b;
}
```

---

## 6. Mejoras por tema

### Tema04_03 — Polimorfismo

| Mejora | Descripción |
|--------|------------|
| Ampliar de 1 a 6 ejercicios | Un solo ejercicio no cubre el concepto |
| Añadir clases abstractas | `abstract class` es el patrón clave |
| Unificar con Tema08 | Polimorfismo + herencia son el mismo concepto — deben estar juntos |

### Tema06 — Cadenas

| Mejora | Descripción |
|--------|------------|
| Ampliar de 2 a 12 ejercicios | Ver lista en sección 5 |
| Añadir regex | `matches()`, `Pattern`, `Matcher` |
| Ejercicio de `String.format` | Formato de salida — se usa en todos los proyectos |

### Tema07 — Clases

| Mejora | Descripción |
|--------|------------|
| Unificar nomenclatura | `ejercicio01persona` (minuscula) vs `Ejercicio00Modificadores` (mayuscula) |
| Mover `DDBBPersonCocheCCorriente.java` | Archivo suelto que deberia estar en una carpeta de ejercicio |
| Añadir ejercicio de `enum` | Natural despues de los ejercicios de clases |

### Tema08 — Herencia

| Mejora | Descripción |
|--------|------------|
| Crear `Ejercicio02` | El salto de 01 a 03 sugiere que falta |
| Añadir clases abstractas | No hay ningun ejemplo de `abstract class` |
| Añadir `@Override` explicito | Varios ejercicios sobreescriben sin la anotacion |

### Tema11 — Colecciones

| Mejora | Descripción |
|--------|------------|
| Corregir numeracion | Dos Ejercicio04 y dos Ejercicio06 |
| Añadir `ArrayDeque` | El mas eficiente como pila y cola — no aparece |
| Añadir `PriorityQueue` | Cola con prioridad — pedida en examenes |
| Eliminar `Set.txt` | Archivo de texto suelto — su contenido deberia estar en el README |

### Tema12 — AccesoDatos

| Mejora | Descripción |
|--------|------------|
| Renombrar carpeta (typo) | `AcesoDatos` → `AccesoDatos` |
| Crear `ejercicio04` | Numeracion rota del 03 al 05 |
| Añadir fichero `.properties` | Leer configuración de conexión — buena práctica |

### Tema13 — Streams

| Mejora | Descripción |
|--------|------------|
| Ampliar de 3 a 10+ archivos | Solo 3 — insuficiente |
| `filter` + `map` + `collect` | Las tres operaciones fundamentales |
| `Optional` | Evitar NullPointerException |
| `Collectors.groupingBy` | Agrupar elementos — muy util y pedido |
| Convertir `Readme.txt` a `README.md` | Unificar extension |

### Tema14 — Threads

| Mejora | Descripción |
|--------|------------|
| Ampliar de 3 a 8+ ejercicios | Muy escaso para un tema tan importante |
| Añadir `ExecutorService` | Forma moderna y recomendada de gestionar hilos |
| Añadir `Callable` y `Future` | Para hilos con valor de retorno |
| Diagrama de ciclo de vida | ASCII: NEW → RUNNABLE → BLOCKED → TERMINATED |

### Tema15 — JDBC

| Mejora | Descripción |
|--------|------------|
| Renombrar a `Tema15JDBC/` | El nombre actual (JPA) es incorrecto |
| Eliminar paquete `org.kabalera82` | Codigo duplicado — mantener solo `tech.Kabadev` |
| Sacar password del codigo | `"221182"` visible en GitHub público |
| Añadir transacciones | `setAutoCommit`, `commit`, `rollback` |
| Crear ejercicio sin GUI | `Main.java` con GUI es demasiado complejo de entrada |

### Tema20 — Swing

| Mejora | Descripción |
|--------|------------|
| Mover a `Tema17Swing/` | El numero 20 rompe el orden lógico |
| Ampliar de 1 a 8+ ejercicios | Solo `Swing01` |
| Añadir layouts | BorderLayout, GridLayout, FlowLayout |
| Añadir eventos | ActionListener, KeyListener |
| `SwingUtilities.invokeLater()` | Obligatorio para crear ventanas en el EDT |

---

## 7. Problemas estructurales

### Temas 17, 18, 19 — duplicados de Java2

Son exactamente los mismos archivos. Temas de 2ºDAM que no pertenecen a este repo.

**Decision necesaria:**
- Eliminarlos completamente de este repo
- O mantenerlos como referencia rapida con un NOTE en el README que diga de donde vienen

---

### Subtemas numerados con `_01`, `_02`, `_03` vs carpetas directas

Inconsistencia entre `Tema04_01Metodos`, `Tema04_02VarArgs`, `Tema04_03Polimorfismo` y el resto de temas sin sufijo.

**Propuesta:**
```
Tema04Metodos/
├── 01-metodos-basicos/
├── 02-varargs-sobrecarga/
└── 03-polimorfismo-abstractas/
```

---

### `data/` en la raíz

Los archivos de datos pertenecen a ejercicios especificos, no a la raíz del repo.

**Mover a:**
- `Tema12AccesoDatos/data/` — para los ficheros de texto/CSV
- `Tema10_02FicherosBinarios/data/` — para `datos.dat`

---

### `.gitignore` incompleto

Falta excluir:
```
# Compilados
out/
target/
*.class

# Maven
.mvn/
*.jar

# IntelliJ
.idea/
*.iml

# Credenciales — NUNCA commitear
database.properties
*.env
application-local.properties
```

---

## 8. Convenios de codigo

### Naming (violaciones actuales)

| Elemento | Correcto | Actual en el repo |
|---------|----------|------------------|
| Clase | PascalCase | `ejercicio01persona` (minuscula) en Tema07 |
| Archivo | Igual que la clase | `Ejercicio03OperadoresAritméticos.java` (acento) |
| Paquete | lowercase sin acentos | `package Tema01ConceptosBasicos` (mayuscula) |

### Excepciones — no silenciar

```java
// MAL
} catch (Exception e) { }
} catch (IOException e) { e.printStackTrace(); }

// BIEN
} catch (IOException e) {
    System.err.println("Error: " + e.getMessage());
}
```

### Credenciales — nunca en el codigo

```java
// MAL — visible en GitHub para siempre
private static final String PASSWORD = "221182";

// BIEN
private static final String PASSWORD = System.getenv("DB_PASSWORD");
```

### try-with-resources

```java
// SIEMPRE para I/O, conexiones, streams
try (BufferedReader br = Files.newBufferedReader(ruta)) {
    // br.close() se llama automáticamente
}
```

---

## 9. Relacion con Java2 (2ºDAM)

Este repo cubre 1ºDAM. Muchos temas tienen continuacion natural en Java2:

| Java (1ºDAM) | Java2 (2ºDAM) |
|-------------|--------------|
| `Tema14Threads` — hilos basicos | `Hilos/` — ciclo de vida completo, ExecutorService |
| `Tema14Threads` — synchronized básico | `Sincronizacion/` — ReentrantLock, deadlocks, Filosofos |
| — | `Concurrencia/` — Productor-Consumidor, wait/notify |
| `Tema12AccesoDatos` — ficheros | `AccesoDatos/` — NIO2, JSON, CSV avanzado |
| `Tema15JDBC` — JDBC básico | — (Java2 no tiene JDBC completo — pendiente alli también) |
| `Tema13Streams` — introduccion | `Tema17ProgramacionFuncional/` — Streams completos, Optional |
| — | `Tema18ProgramacionRed/` — Sockets TCP |
| — | `AlgoritmosOrdenacion/` — FIFO, SJF, SRTF, Round Robin |

---

## 10. Hoja de ruta — checkboxes

### Prioridad 1 — Seguridad y limpieza (antes de todo)

- [ ] `git rm red.text` — eliminar archivo con IPs reales
- [ ] `git rm errores.txt` — eliminar archivo vacio
- [ ] Sacar password `"221182"` de `Tema15JPA/Conexión.java`
- [ ] Crear `README.md` (reemplazar `Readme.txt`) ✅ hecho
- [ ] Actualizar `.gitignore` para excluir credenciales

### Prioridad 2 — Bugs estructurales

- [ ] Renombrar `Tema12AcesoDatos` → `Tema12AccesoDatos` (typo)
- [ ] Renombrar `Tema15JPA` → `Tema15JDBC` (nombre incorrecto)
- [ ] Eliminar paquete `org.kabalera82` de `Tema15JPA` (duplicado)
- [ ] Corregir numeracion duplicada en `Tema11Colecciones`
- [ ] Crear o aclarar `Ejercicio02` en `Tema08_01Herencia`
- [ ] Renombrar archivos con acentos: `Ejercicio03OperadoresAritméticos.java`, `Ejercicio07MétodosBusqueda.java`

### Prioridad 3 — Tema crítico ausente

- [ ] Crear `Tema10Excepciones/` con 7 ejercicios progresivos
- [ ] Ampliar `Tema06CadenasDeCaracteres` de 2 a 12 ejercicios

### Prioridad 4 — Temas escasos que necesitan contenido

- [ ] Ampliar `Tema04_03Polimorfismo` con clases abstractas
- [ ] Ampliar `Tema13Streams` de 3 a 10+ ejercicios
- [ ] Ampliar `Tema14Threads` de 3 a 8+ ejercicios
- [ ] Implementar o eliminar `Tema16JavaServerPages`

### Prioridad 5 — Limpieza estructural

- [ ] Decidir que hacer con `Tema17`, `Tema18`, `Tema19` (duplicados de Java2)
- [ ] Mover `Tema20Interfaces/Swing` a su propio tema con numero lógico
- [ ] Mover archivos de `data/` raíz al ejercicio correspondiente
- [ ] Unificar nomenclatura subtemas (Tema04_01 → subcarpetas)
- [ ] Añadir `enum` como ejercicio en Tema07 o Tema09
- [ ] Añadir Generics basicos como ejercicio en Tema11

---

*Documento generado el 2026-03-21. Actualizar conforme se vayan completando los puntos.*
