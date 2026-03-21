# Roadmap Java — De junior a semi-senior

> Guía completa de todo lo que debe dominar un desarrollador Java para ser empleable y efectivo en un equipo profesional. Los temas marcados con el repo indican dónde encontrar los apuntes. Los que no tienen enlace son los **puntos ciegos de estos repos** — lo que necesitas aprender por tu cuenta.

---

## Cómo usar esta guía

- **[Java]** → cubierto en [github.com/kabalera82/Java](https://github.com/kabalera82/Java) (1ºDAM)
- **[Java2]** → cubierto en [github.com/kabalera82/Java2](https://github.com/kabalera82/Java2) (2ºDAM)
- **[Java] ⚠️** → el tema existe pero está incompleto o tiene bugs pendientes
- Sin etiqueta → **no está en ninguno de los dos repos** — necesitas buscarlo fuera

---

## Bloque 1 — Fundamentos del lenguaje

Todo esto es imprescindible antes de tocar frameworks.

| Tema | Estado | Dónde estudiarlo |
|------|--------|-----------------|
| Tipos primitivos, operadores, casting | ✅ | [Java] Tema01 |
| `Scanner`, `JOptionPane`, entrada/salida | ✅ | [Java] Tema01 |
| Condicionales: `if/else`, `switch` | ✅ | [Java] Tema02 |
| Bucles: `for`, `while`, `do-while`, `break`, `continue` | ✅ | [Java] Tema03 |
| Métodos: declaración, parámetros, retorno, sobrecarga | ✅ | [Java] Tema04 |
| Recursión | ✅ | [Java] Tema04 |
| Varargs | ✅ | [Java] Tema04 |
| Arrays 1D y 2D | ✅ | [Java] Tema05 |
| Algoritmos de búsqueda y ordenación básicos | ✅ | [Java] Tema05 |
| `String`, `StringBuilder`, métodos de cadena | ✅ ⚠️ escaso | [Java] Tema06 |
| Expresiones regulares (`Pattern`, `Matcher`) | [Java] ⚠️ pendiente ampliar | Documentación oficial Java |
| **Excepciones: `try/catch/finally`, `throw`, `throws`** | **[Java] ⚠️ FALTA** | Crear Tema10Excepciones |
| Excepciones personalizadas | **[Java] ⚠️ FALTA** | Crear Tema10Excepciones |
| `try-with-resources` | Mencionado pero sin ejercicio propio | [Java] Tema10 |

---

## Bloque 2 — Programación Orientada a Objetos

El núcleo del lenguaje. Sin esto, nada de lo demás tiene sentido.

| Tema | Estado | Dónde |
|------|--------|-------|
| Clases, objetos, constructores, encapsulamiento | ✅ | [Java] Tema07 |
| Modificadores de acceso: `public`, `private`, `protected` | ✅ | [Java] Tema07 |
| `static`: atributos y métodos de clase | ✅ | [Java] Tema07 |
| `this` y `super` | ✅ | [Java] Tema08 |
| Herencia (`extends`) y polimorfismo | ✅ ⚠️ falta Ej02 | [Java] Tema08 |
| Clases abstractas (`abstract`) | ⚠️ sin ejercicio propio | Ampliar [Java] Tema08 |
| Interfaces (`interface`, `implements`) | ✅ | [Java] Tema09 |
| `instanceof` y casting de objetos | ✅ | [Java] Tema08b |
| `@Override`, `@FunctionalInterface` | Parcial | [Java] Tema08-09 |
| **Enumeraciones (`enum`)** | **FALTA en ambos repos** | Java Docs: Enum Types |
| **Records (Java 16+)** | **FALTA en ambos repos** | Java Docs: Records |
| Clases selladas (`sealed`, Java 17+) | FALTA | Java Docs |
| `equals()`, `hashCode()`, `toString()` correctamente | Parcial en Tema16JDBC | [Java] Tema07 |
| Inmutabilidad: `final`, clases inmutables | FALTA | Java Docs |

---

## Bloque 3 — Estructuras de datos y colecciones

Sin dominar esto, los Streams no tienen sentido.

| Tema | Estado | Dónde |
|------|--------|-------|
| `ArrayList`, `LinkedList` | ✅ | [Java] Tema11 |
| `HashMap`, `LinkedHashMap`, `TreeMap` | ✅ | [Java] Tema11 |
| `HashSet`, `LinkedHashSet`, `TreeSet` | ✅ ⚠️ numeración duplicada | [Java] Tema11 |
| `ArrayDeque` como pila y cola | ⚠️ no aparece | Ampliar [Java] Tema11 |
| `PriorityQueue` | ⚠️ no aparece | Ampliar [Java] Tema11 |
| `Collections`: `sort()`, `reverse()`, `shuffle()` | Parcial | [Java] Tema11 |
| **Generics: `<T>`, `<? extends T>`, `<? super T>`** | **FALTA ejercicio propio** | Java Docs: Generics |
| Comparator y Comparable | Parcial en Tema17 | [Java2] Tema17 |
| `Iterator` y `Iterable` | FALTA | Java Docs |

---

## Bloque 4 — Ficheros y acceso a datos

| Tema | Estado | Dónde |
|------|--------|-------|
| Lectura/escritura de ficheros de texto | ✅ | [Java] Tema10a |
| Serialización de objetos (`ObjectOutputStream`) | ✅ | [Java] Tema10b |
| `Files`, `Path`, NIO2 | Parcial | [Java2] AccesoDatos |
| CSV: parseo manual con `split()` | ✅ | [Java] Tema12, [Java2] AccesoDatos |
| **JSON con Jackson o Gson** | **⚠️ existe estructura, falta código** | Ampliar [Java2] AccesoDatos |
| Fichero `.properties` (`Properties`) | FALTA | Java Docs |
| **JDBC: `Connection`, `PreparedStatement`, `ResultSet`** | **⚠️ básico en Tema16JDBC (con bugs)** | Corregir [Java] Tema15 |
| JDBC: transacciones (`commit`, `rollback`) | FALTA | Ampliar [Java] Tema16JDBC |
| **JPA/Hibernate: `@Entity`, `@Table`, `@Id`, `EntityManager`** | **FALTA en ambos repos** | Spring Data JPA docs |
| Connection Pool (HikariCP) | FALTA | HikariCP docs |
| **SQL: `SELECT`, `JOIN`, `GROUP BY`, índices, claves** | **FALTA en ambos repos** | W3Schools SQL, SQLBolt |

---

## Bloque 5 — Programación funcional

| Tema | Estado | Dónde |
|------|--------|-------|
| Interfaces funcionales: `Predicate`, `Function`, `Consumer`, `Supplier` | ✅ | [Java2] Tema17 |
| Lambdas | ✅ | [Java] Tema13, [Java2] Tema17 |
| Stream API: `filter`, `map`, `collect`, `reduce`, `sorted` | ✅ | [Java2] Tema17 |
| `Optional` | ✅ | [Java2] Tema17 |
| Referencias a métodos (`::`) | ✅ | [Java2] Tema17 |
| `Collectors.groupingBy`, `joining`, `toMap` | Parcial | [Java2] Tema17 |
| `flatMap` | ⚠️ falta ejercicio | Ampliar [Java2] Tema17 |
| `parallelStream` y sus peligros | ✅ | [Java2] Tema17 |
| **`CompletableFuture`** | **FALTA en ambos repos** | Java Docs |

---

## Bloque 6 — Concurrencia

| Tema | Estado | Dónde |
|------|--------|-------|
| `Thread`, `Runnable` | ✅ | [Java] Tema14, [Java2] Hilos |
| Ciclo de vida del hilo | ✅ | [Java2] Hilos |
| `sleep()`, `join()`, `interrupt()` | ✅ | [Java2] Hilos |
| `synchronized` (método y bloque) | ✅ | [Java2] Sincronizacion |
| `ReentrantLock`, `tryLock()` | ✅ | [Java2] Sincronizacion |
| Deadlock: qué es y cómo evitarlo | ✅ | [Java2] Sincronizacion |
| Productor-Consumidor con `wait/notify` | ⚠️ Productor.java vacío | Corregir [Java2] Concurrencia |
| `ExecutorService`, `Callable`, `Future` | ⚠️ falta ejercicio propio | Ampliar [Java2] Hilos |
| `BlockingQueue` (versión moderna de Productor-Consumidor) | FALTA | Ampliar [Java2] Concurrencia |
| `CountDownLatch`, `CyclicBarrier`, `Semaphore` | FALTA | java.util.concurrent docs |
| `AtomicInteger`, variables atómicas | Parcial | [Java2] Hilos |
| **`CompletableFuture` (async moderno)** | **FALTA en ambos repos** | Java Docs |
| **Reactive programming (básico)** | **FALTA en ambos repos** | Project Reactor / RxJava |

---

## Bloque 7 — Interfaces gráficas (Swing)

| Tema | Estado | Dónde |
|------|--------|-------|
| `JFrame`, `JPanel`, `JLabel`, `JButton`, `JTextField` | ✅ | [Java2] Swing |
| Layouts: `BorderLayout`, `GridLayout`, `FlowLayout` | ✅ | [Java2] Swing |
| Eventos: `ActionListener` | ✅ | [Java2] Swing |
| EDT (Event Dispatch Thread) | ✅ | [Java2] Swing |
| `JTable` para datos tabulares | FALTA | Ampliar [Java2] Swing |
| `JFileChooser`, `JDialog` | FALTA | Ampliar [Java2] Swing |
| Proyecto CRUD completo con Swing + datos | FALTA | Crear en [Java2] |
| **JavaFX** (la alternativa moderna a Swing) | **FALTA en ambos repos** | OpenJFX docs |

---

## Bloque 8 — Build tools y dependencias

Imprescindible para trabajar en cualquier proyecto real.

| Tema | Estado | Dónde |
|------|--------|-------|
| Maven: `pom.xml`, `groupId`, `artifactId`, `version` | Parcial (Tema15, Tema19) | Ampliar |
| Maven: ciclo de vida (`compile`, `test`, `package`, `install`) | **FALTA en ambos repos** | Maven docs |
| Maven: añadir dependencias de Maven Central | **FALTA en ambos repos** | search.maven.org |
| **Gradle (alternativa a Maven)** | **FALTA en ambos repos** | Gradle docs |
| `pom.xml` multi-módulo | FALTA | Maven docs |
| Gestión de versiones con `<properties>` | FALTA | Maven docs |

---

## Bloque 9 — Testing

**No hay ni un test en ninguno de los dos repos.** Es uno de los puntos ciegos más graves.

| Tema | Estado | Dónde |
|------|--------|-------|
| **JUnit 5: `@Test`, `@BeforeEach`, `@AfterEach`, `Assertions`** | **FALTA en ambos repos** | JUnit 5 docs |
| `@ParameterizedTest` con distintas fuentes | FALTA | JUnit 5 docs |
| **Mockito: `@Mock`, `when().thenReturn()`, `verify()`** | **FALTA en ambos repos** | Mockito docs |
| TDD: ciclo Red-Green-Refactor | FALTA | "Test Driven Development" - Kent Beck |
| Tests de integración vs tests unitarios | FALTA | |
| Cobertura de código (JaCoCo con Maven) | FALTA | JaCoCo docs |
| **Testcontainers** (tests con base de datos real en Docker) | FALTA | testcontainers.org |

---

## Bloque 10 — Diseño y arquitectura

Lo que diferencia a un junior de un semi-senior.

| Tema | Estado | Dónde |
|------|--------|-------|
| **Principios SOLID** | **FALTA en ambos repos** | "Clean Architecture" - R. Martin |
| **Patrón DAO** | Parcial en [Java] Tema16JDBC | Documentar como patrón |
| **Patrón Singleton** | FALTA | Design Patterns - GoF |
| **Patrón Factory / Factory Method** | FALTA | Design Patterns - GoF |
| **Patrón Builder** | FALTA | Design Patterns - GoF |
| **Patrón Observer / Event Listener** | FALTA | Design Patterns - GoF |
| **Patrón Strategy** | FALTA | Design Patterns - GoF |
| Patrón Repository | FALTA | DDD - Eric Evans |
| Arquitectura en capas (Presentación → Servicio → Repositorio) | FALTA | |
| **Clean Code: nombres, funciones pequeñas, SRP** | **FALTA en ambos repos** | "Clean Code" - R. Martin |

---

## Bloque 11 — Spring Framework

El framework más usado en Java empresarial en España. Sin Spring, es muy difícil encontrar trabajo.

| Tema | Estado | Dónde |
|------|--------|-------|
| **Inyección de dependencias (DI) y IoC** | **FALTA en ambos repos** | Spring docs |
| **Spring Boot: `@SpringBootApplication`, auto-configuración** | **FALTA en ambos repos** | start.spring.io |
| **Spring MVC: `@RestController`, `@GetMapping`, `@PostMapping`** | **FALTA en ambos repos** | Spring docs |
| **Spring Data JPA: `@Entity`, `JpaRepository`, `@Query`** | **FALTA en ambos repos** | Spring Data docs |
| **Spring Security: autenticación, autorización, JWT** | **FALTA en ambos repos** | Spring Security docs |
| **Manejo de excepciones global (`@ControllerAdvice`)** | **FALTA en ambos repos** | Spring docs |
| Validación de datos (`@Valid`, `@NotNull`, `@Size`) | FALTA | Jakarta Validation |
| Documentación de API con Swagger/OpenAPI | FALTA | springdoc-openapi |

---

## Bloque 12 — APIs REST y HTTP

| Tema | Estado | Dónde |
|------|--------|-------|
| Protocolo HTTP: verbos (`GET`, `POST`, `PUT`, `DELETE`, `PATCH`) | FALTA | MDN Web Docs |
| Códigos de estado HTTP (200, 201, 400, 401, 403, 404, 500) | FALTA | MDN Web Docs |
| Consumir una API REST con `HttpClient` (Java 11+) | Parcial en [Java2] Tema18 | Ampliar |
| Parsear respuesta JSON (Jackson) | Parcial | Ampliar [Java2] AccesoDatos |
| **Diseñar una API REST correctamente (recursos, verbos, URLs)** | **FALTA en ambos repos** | RESTful API Design |
| Autenticación con JWT (JSON Web Token) | FALTA | jwt.io |

---

## Bloque 13 — Herramientas de desarrollo

| Tema | Estado | Dónde |
|------|--------|-------|
| **Git: ramas, merge, rebase, pull requests** | **FALTA en ambos repos** | learngitbranching.js.org |
| Git: resolución de conflictos | FALTA | |
| Git: flujo de trabajo (GitFlow, trunk-based) | FALTA | |
| IntelliJ IDEA: atajos, refactoring, depuración | FALTA | JetBrains Academy |
| **Docker: imágenes, contenedores, `docker-compose`** | **FALTA en ambos repos** | docs.docker.com |
| Docker: contener una app Spring Boot | FALTA | |
| **Linux/Bash básico: navegación, permisos, pipes, scripts** | **FALTA en ambos repos** | The Linux Command Line |
| Variables de entorno y configuración | FALTA | |

---

## Bloque 14 — Logging y observabilidad

| Tema | Estado | Dónde |
|------|--------|-------|
| `java.util.logging` básico | FALTA (mencionado en Java2 guide) | Crear [Java2] logging |
| **SLF4J + Logback** | **FALTA en ambos repos** | SLF4J docs |
| Niveles de log: `TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR` | FALTA | |
| Logs estructurados (JSON) para producción | FALTA | |
| Por qué `System.out.println` no es logging | FALTA | |

---

## Bloque 15 — CI/CD básico

| Tema | Estado | Dónde |
|------|--------|-------|
| **GitHub Actions: workflows, jobs, steps** | **FALTA en ambos repos** | GitHub docs |
| Ejecutar tests automáticamente en cada push | FALTA | |
| Publicar un artefacto Maven | FALTA | |
| Variables de entorno y secretos en CI | FALTA | |

---

## Resumen: lo que sí está vs lo que falta

### Lo que cubren los dos repos juntos

```
Fundamentos Java (tipos, operadores, control de flujo)
POO básico-intermedio (clases, herencia, interfaces)
Arrays y colecciones
Ficheros (texto y binario)
Streams y lambdas (Java 8+)
Concurrencia básica-avanzada (hilos, sync, Productor-Consumidor)
Algoritmos de planificación CPU (FIFO, SJF, SRTF, Round Robin)
Acceso a datos (ficheros texto/CSV, JDBC básico con bugs)
Interfaces gráficas Swing
Redes básicas (sockets, URL)
ProcessBuilder
```

### Lo que NO está y un junior/semi-senior necesita

```
Excepciones (tema crítico ausente en Java1)
Enumeraciones y Records
Generics avanzados
SOLID y Clean Code
Patrones de diseño (Singleton, Factory, Builder, Observer, Strategy)
JPA/Hibernate (el REAL, no JDBC)
SQL (el lenguaje de base de datos)
JUnit 5 + Mockito (testing — cero en ambos repos)
Maven completo (ciclo de vida, dependencias)
Spring Boot (imprescindible para trabajar en España)
Spring MVC + REST APIs
Spring Data JPA
Spring Security
Docker
Git avanzado (ramas, pull requests, conflictos)
GitHub Actions (CI/CD)
SLF4J/Logback (logging profesional)
Linux/Bash básico
```

---

## Recursos externos recomendados

| Recurso | Para qué |
|---------|---------|
| [Baeldung.com](https://www.baeldung.com) | Tutoriales Java y Spring de calidad |
| [Spring Guides](https://spring.io/guides) | Guías oficiales de Spring Boot |
| [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) | Testing con JUnit 5 |
| [Mockito docs](https://site.mockito.org) | Mocks en tests |
| [SQLBolt](https://sqlbolt.com) | SQL interactivo desde cero |
| [learngitbranching.js.org](https://learngitbranching.js.org) | Git visual e interactivo |
| [docs.docker.com/get-started](https://docs.docker.com/get-started/) | Docker desde cero |
| [refactoring.guru](https://refactoring.guru/es) | Patrones de diseño con ejemplos |
| "Clean Code" — Robert C. Martin | Código limpio y mantenible |
| "Effective Java" — Joshua Bloch | Las mejores prácticas de Java |

---

*Última actualización: 2026-03-21*
