# Java — Apuntes 1ºDAM

> Repositorio de teoría, apuntes y ejercicios de Java para primer curso de Desarrollo de Aplicaciones Multiplataforma (DAM). Los temas van de los fundamentos del lenguaje hasta la programación orientada a objetos, colecciones, ficheros, hilos y acceso a datos con JDBC.

---

## Índice

1. [Estado actual del repositorio](#1-estado-actual-del-repositorio)
2. [Temario actual y orden propuesto](#2-temario-actual-y-orden-propuesto)
3. [Bugs y errores pendientes](#3-bugs-y-errores-pendientes)
4. [Temas que faltan por desarrollar](#4-temas-que-faltan-por-desarrollar)
5. [Mejoras propuestas por tema](#5-mejoras-propuestas-por-tema)
6. [Problemas estructurales del repo](#6-problemas-estructurales-del-repo)
7. [Convenios de codigo](#7-convenios-de-codigo)
8. [Hoja de ruta](#8-hoja-de-ruta)
9. [Requisitos y compilacion](#9-requisitos-y-compilacion)

---

## 1. Estado actual del repositorio

| Carpeta | Estado | Comentario |
|---------|--------|-----------|
| `Tema01ConceptosBasicos/` | ✅ Completo | 17 ejercicios + repaso. Buen volumen |
| `Tema02Condicionales/` | ✅ Completo | 20 ejercicios variados |
| `Tema03Bucles/` | ✅ Completo | 20 ejercicios. Buen volumen |
| `Tema04_01Metodos/` | ✅ Completo | 20 ejercicios incluyendo recursion |
| `Tema04_02VarArgs/` | ✅ Funcional | 4 ejercicios de varargs y sobrecarga |
| `Tema04_03Polimorfismo/` | ⚠️ Muy escaso | Solo 1 ejercicio. Necesita ampliacion |
| `Tema05_01Tablas/` | ✅ Completo | 15 ejercicios de arrays 1D |
| `Tema05_02MatricesArrays/` | ✅ Completo | 8 ejercicios de arrays 2D y ordenacion |
| `Tema06CadenasDeCaracteres/` | ⚠️ Muy escaso | Solo 2 ejercicios. Necesita ampliacion urgente |
| `Tema07Clases/` | ✅ Funcional con issues | Buena base POO. Nomenclatura mixta (carpetas/archivos sueltos) |
| `Tema08_01Herencia/` | ⚠️ Incompleto | Falta Ejercicio02. Solo 2 de probables 3+ |
| `Tema08_02InstanceOf/` | ✅ Funcional | 2 ejercicios de instanceof e interfaces |
| `Tema09Interfaces/` | ✅ Funcional | 4 ejercicios de interfaces |
| `Tema10_01FicherosDeTexto/` | ✅ Funcional | 2 ejercicios. Podria tener mas |
| `Tema10_02FicherosBinarios/` | ✅ Funcional | 5 ejercicios de ObjectOutputStream/InputStream |
| `Tema11Colecciones/` | ⚠️ Numeros duplicados | Dos Ejercicio04, dos Ejercicio06 — numeros de ejercicio inconsistentes |
| `Tema12AcesoDatos/` | ⚠️ Typo + incompleto | Typo en nombre (AcesoDatos → AccesoDatos). Falta ejercicio04. JDBC ausente |
| `Tema13Streams/` | ⚠️ Muy escaso | Solo 3 archivos Java. Necesita ampliacion |
| `Tema14Threads/` | ⚠️ Muy escaso | Solo 3 ejercicios. La base esta pero necesita mas |
| `Tema15JPA/` | ⚠️ Malnombrado + bug seguridad | Es JDBC no JPA. Password hardcodeada. Codigo duplicado dentro |
| `Tema16JavaServerPages/` | ⚠️ Esqueleto vacio | Main.java es un placeholder vacio. No hay JSP real |
| `Tema99EjerciciosMultiples/` | ⚠️ Desorganizado | Mezcla de ejercicios sin tema claro. Algunos duplican AlgoritmosOrdenacion de Java2 |

**Archivos en la raíz que deben eliminarse:**
- `red.text` — salida de `ipconfig` con IPs reales del sistema. **ELIMINAR — expone información sensible**
- `errores.txt` — archivo vacio sin proposito
- `Readme.txt` — reemplazado por este `README.md`

---

## 2. Temario actual y orden propuesto

### Temario actual

| # | Carpeta | Contenido |
|---|---------|-----------|
| 01 | [Tema01ConceptosBasicos](./Tema01ConceptosBasicos/) | Tipos primitivos, operadores, `Scanner`, `JOptionPane` |
| 02 | [Tema02Condicionales](./Tema02Condicionales/) | `if/else`, `switch`, operador ternario |
| 03 | [Tema03Bucles](./Tema03Bucles/) | `for`, `while`, `do-while`, bucles anidados |
| 04 | [Tema04_01Metodos](./Tema04_01Metodos/) | Declaracion, parametros, retorno, recursion |
| 04b | [Tema04_02VarArgs](./Tema04_02VarArgs/) | Argumentos variables, sobrecarga |
| 04c | [Tema04_03Polimorfismo](./Tema04_03Polimorfismo/) | Polimorfismo (escaso) |
| 05 | [Tema05_01Tablas](./Tema05_01Tablas/) | Arrays unidimensionales |
| 05b | [Tema05_02MatricesArrays](./Tema05_02MatricesArrays/) | Arrays 2D, algoritmos de ordenacion e busqueda |
| 06 | [Tema06CadenasDeCaracteres](./Tema06CadenasDeCaracteres/) | `String`, `StringBuilder` (escaso) |
| 07 | [Tema07Clases](./Tema07Clases/) | Clases, constructores, encapsulamiento, `static` |
| 08 | [Tema08_01Herencia](./Tema08_01Herencia/) | Herencia, `extends`, `super` |
| 08b | [Tema08_02InstanceOf](./Tema08_02InstanceOf/) | `instanceof`, casting de objetos |
| 09 | [Tema09Interfaces](./Tema09Interfaces/) | Interfaces, implementación multiple |
| 10 | [Tema10_01FicherosDeTexto](./Tema10_01FicherosDeTexto/) | `BufferedReader/Writer`, `Files` |
| 10b | [Tema10_02FicherosBinarios](./Tema10_02FicherosBinarios/) | `ObjectOutputStream/InputStream`, serializacion |
| 11 | [Tema11Colecciones](./Tema11Colecciones/) | `List`, `Set`, `Map`, `Stack`, `Queue` |
| 12 | [Tema12AcesoDatos](./Tema12AcesoDatos/) | Texto plano, JSON, CSV (falta JDBC) |
| 13 | [Tema13Streams](./Tema13Streams/) | Streams basicos (muy escaso) |
| 14 | [Tema14Threads](./Tema14Threads/) | `Thread`, `Runnable`, sincronizacion básica |
| 15 | [Tema15JPA](./Tema15JPA/) | JDBC + MySQL con patrón DAO (mal nombrado) |
| 16 | [Tema16JavaServerPages](./Tema16JavaServerPages/) | Proyecto vacio (no hay contenido) |
| 99 | [Tema99EjerciciosMultiples](./Tema99EjerciciosMultiples/) | Ejercicios mixtos sin tema claro |

### Orden y estructura propuesto

El temario de 1ºDAM cubre los fundamentos del lenguaje.

```
01-conceptos-basicos/           tipos, operadores, Scanner, JOptionPane
02-condicionales/               if/else, switch, ternario
03-bucles/                      for, while, do-while
04-metodos/                     declaracion, sobrecarga, recursion, varargs
05-arrays/                      1D, 2D, Arrays utility class
06-cadenas/                     String, StringBuilder, expresiones regulares ← AMPLIAR
07-poo-clases/                  clases, constructores, encapsulamiento, static
08-herencia/                    extends, super, override, abstract ← COMPLETAR
09-interfaces/                  interface, polimorfismo ← UNIFICAR Tema04_03 aqui
10-excepciones/                 try-catch-finally, jerarquía ← FALTA COMPLETAMENTE
11-ficheros/                    texto plano, binarios, NIO2
12-colecciones/                 List, Set, Map, Queue, Stack ← CORREGIR NUMERACION
13-acceso-datos/                CSV, JSON, JDBC (renombrar Tema12AcesoDatos)
14-streams-lambdas/             Streams basicos, lambdas introductorias
15-hilos/                       Thread, Runnable, sincronizacion
16-jdbc/                        JDBC completo con patrón DAO (renombrar Tema15JPA)
17-swing/                       Interfaces graficas basicas ← FALTA (Swing/JavaFX)
```

---

## 3. Bugs y errores pendientes

### SEGURIDAD CRITICA — `red.text` expone IPs reales del sistema

```
/tmp/Java1/red.text — contiene salida de ipconfig con:
- Direccion IPv4: 192.168.1.133
- Direccion IPv6: 2a0c:5a80:3c09:f100:4106:f7bc:da5b:fea
- Puerta de enlace: 192.168.1.1
```

Este archivo es la salida del comando `ipconfig` de Windows guardada accidentalmente. **Debe eliminarse del repo** — expone información de red del sistema del autor.

---

### SEGURIDAD — `Tema15JPA/src/main/java/tech/Kabadev/conexión/Conexión.java` — password hardcodeada

```java
// ACTUAL — password root del MySQL en codigo fuente público
private static final String USUARIO = "root";
private static final String PASSWORD = "221182";
```

La contraseña de root del servidor MySQL esta en texto plano en el repositorio público de GitHub.

**Correccion:**
```java
// Opcion 1: variable de entorno
private static final String PASSWORD = System.getenv("DB_PASSWORD");

// Opcion 2: fichero .properties (en .gitignore)
// database.url=jdbc:mysql://localhost:3306/tutorial
// database.user=root
// database.password=221182
```

---

### BUG — `Tema15JPA/` — codigo duplicado dentro del mismo proyecto

El proyecto tiene DOS paquetes con exactamente las mismas clases:
- `org.kabalera82.conexión.Conexión` / `tech.Kabadev.conexión.Conexión`
- `org.kabalera82.dao.UsuarioDAO` / `tech.Kabadev.dao.UsuarioDAO`
- `org.kabalera82.model.Usuario` / `tech.Kabadev.model.Usuario`
- `org.kabalera82.gui.Main` / `tech.Kabadev.gui.Main`

Una de las dos implementaciones debe eliminarse. Mantener `tech.Kabadev` que es la mas completa.

---

### BUG — `Tema15JPA/` — nombre incorrecto

El tema se llama JPA pero usa `java.sql.Connection`, `DriverManager` y `PreparedStatement` — eso es **JDBC**, no JPA. JPA usa Hibernate/EclipseLink con anotaciones como `@Entity`, `@Table`, `@Id`. El `pom.xml` solo tiene `mysql-connector-java`, no Hibernate.

**Correccion:** Renombrar a `Tema15JDBC/` o `Tema16JDBC/` segun el orden final.

---

### BUG — `Tema16JavaServerPages/` — proyecto vacio

`Tema16JavaServerPages/src/main/java/tech/Kabadev/Main.java` contiene solo el placeholder de IntelliJ:

```java
public class Main {
    public static void main(String[] args) {
        // vacio
    }
}
```

No hay codigo JSP, no hay dependencia de servlet en el `pom.xml`. O se implementa o se elimina.

---

### BUG — `Tema11Colecciones/` — numeros de ejercicio duplicados

```
Ejercicio04LinkedList/    ← dos Ejercicio04
Ejercicio04Map/           ← dos Ejercicio04

Ejercicio06HashSet/       ← dos Ejercicio06
Ejercicio06LinkedHashSet/ ← dos Ejercicio06
```

Renombrar para que los numeros sean unicos y el orden sea claro.

---

### BUG — `Tema08_01Herencia/` — falta Ejercicio02

```
Ejercicio01Vehiculos/    ← existe
                         ← Ejercicio02 ausente
Ejercicio03Planta/       ← existe (salta el 02)
```

O se crea el Ejercicio02 o se renombra Ejercicio03Planta a Ejercicio02Planta.

---

### BUG MENOR — `Tema12AcesoDatos/` — falta ejercicio04

```
ejercicio01/
ejercicio02Texto/
ejercicio03/
             ← ejercicio04 ausente
ejercicio05json/
ejercicio06csv/
```

Renombrar ejercicio05 y 06 para que la numeracion sea consecutiva, o crear el ejercicio04.

---

### BUG MENOR — Archivos con acentos en el nombre

```
Tema01ConceptosBasicos/Ejercicio03OperadoresAritméticos.java   ← acento en é
Tema05_02MatricesArrays/Ejercicio07MétodosBusqueda.java        ← acento en é
```

Algunos sistemas de ficheros y herramientas Git tienen problemas con caracteres no-ASCII en nombres de archivo. Renombrar a `Ejercicio03OperadoresAritmeticos.java` y `Ejercicio07MetodosBusqueda.java`.

---

### AVISO — `data/` en la raíz

La carpeta `data/` con `clientes.txt`, `clientes.csv`, `datos.dat`, `miArchivo.txt`, etc., esta en la raíz del repo en lugar de dentro del ejercicio que la usa. Los archivos de datos deberían estar dentro de cada ejercicio o en `Tema12AcesoDatos/data/`.

---

## 4. Temas que faltan por desarrollar

### CRITICO — Excepciones (`try/catch/finally`)

No existe ningun tema dedicado a excepciones. En el `Readme.txt` original aparecia como `Tema12Excepciones` pero la carpeta no existe — en su lugar hay `Tema12AcesoDatos` que es otro concepto.

**Que incluir:**
```java
// Jerarquía de excepciones
Throwable
├── Error (OutOfMemoryError, StackOverflowError)
└── Exception
    ├── RuntimeException (no checked: NullPointerException, ArrayIndexOutOfBoundsException)
    └── IOException, SQLException (checked — hay que declarar o capturar)

// Bloque try-catch-finally
try {
    int[] arr = new int[5];
    arr[10] = 1; // ArrayIndexOutOfBoundsException
} catch (ArrayIndexOutOfBoundsException e) {
    System.err.println("Índice fuera de rango: " + e.getMessage());
} finally {
    System.out.println("Esto siempre se ejecuta");
}

// Crear excepción personalizada
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(double importe) {
        super("Saldo insuficiente para operar con " + importe + " €");
    }
}

// throw y throws
public void retirar(double importe) throws SaldoInsuficienteException {
    if (importe > saldo) throw new SaldoInsuficienteException(importe);
    saldo -= importe;
}
```

**Ejercicios propuestos:**
1. Capturar `NumberFormatException` al parsear entrada del usuario
2. Jerarquía de excepciones — `catch` multiple y orden
3. `finally` para cerrar recursos
4. Crear `CuentaBancariaException` personalizada
5. `try-with-resources` con `BufferedReader`

---

### IMPORTANTE — Cadenas de caracteres (ampliar Tema06)

`Tema06CadenasDeCaracteres` tiene solo 2 ejercicios. Es un tema fundamental con mucho por cubrir.

**Que incluir:**
```java
// Metodos de String mas importantes
String s = "Hola Mundo";
s.length()          // 10
s.toUpperCase()     // "HOLA MUNDO"
s.toLowerCase()     // "hola mundo"
s.trim()            // elimina espacios
s.substring(0, 4)  // "Hola"
s.contains("Mundo") // true
s.replace("Mundo", "Java") // "Hola Java"
s.split(" ")        // ["Hola", "Mundo"]
s.charAt(0)         // 'H'
s.indexOf("Mundo")  // 5
s.startsWith("Hola") // true

// StringBuilder para concatenacion eficiente
StringBuilder sb = new StringBuilder();
sb.append("Hola").append(" ").append("Mundo");
String resultado = sb.toString();

// Comparacion correcta
"hola".equals("hola")           // true (correcto)
"hola".equalsIgnoreCase("HOLA") // true
"hola" == "hola"               // NO usar == para Strings

// Formateo
String.format("Nombre: %s, Edad: %d", nombre, edad);
```

**Ejercicios propuestos (faltan al menos 10 mas):**
1. Contar vocales y consonantes
2. Revertir una cadena
3. Comprobar si es palindromo
4. Contar palabras en una oracion
5. Cifrado Cesar básico
6. Validar email con `contains()` e `indexOf()`
7. Anagrama: comprobar si dos palabras son anagramas
8. `StringBuilder` vs `String` — diferencia de rendimiento

---

### IMPORTANTE — Polimorfismo y clases abstractas (ampliar Tema04_03 / Tema08)

`Tema04_03Polimorfismo` tiene 1 ejercicio. El polimorfismo merece mucho mas desarrollo.

**Que incluir:**
```java
// Clase abstracta
public abstract class Figura {
    public abstract double area();  // metodo abstracto — sin implementación
    public void mostrar() {
        System.out.println("Area: " + area()); // metodo concreto
    }
}

// Herencia + polimorfismo
public class Circulo extends Figura {
    private double radio;
    @Override
    public double area() { return Math.PI * radio * radio; }
}

// Polimorfismo en acción
List<Figura> figuras = List.of(new Circulo(5), new Rectangulo(4, 3));
figuras.forEach(f -> f.mostrar()); // cada figura calcula su area a su manera
```

---

### IMPORTANTE — Enumeraciones (`enum`)

No hay ningun ejercicio de `enum` en el repo.

```java
public enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

    public boolean esLaboral() {
        return this != SABADO && this != DOMINGO;
    }
}

// Uso
DiaSemana hoy = DiaSemana.LUNES;
System.out.println(hoy.esLaboral()); // true
```

---

### UTIL — Generics basicos

Los Generics son prerequisito para entender las colecciones y los Streams. No hay ningun ejercicio específico.

```java
// Clase generica
public class Caja<T> {
    private T contenido;
    public void guardar(T item) { contenido = item; }
    public T sacar() { return contenido; }
}

// Metodo generico
public static <T extends Comparable<T>> T maximo(T a, T b) {
    return a.compareTo(b) >= 0 ? a : b;
}
```

---

### UTIL — Patrón DAO documentado como patrón

`Tema15JPA/` (realmente JDBC) implementa el patrón DAO pero sin documentarlo como tal. El patrón merece su propia explicacion teorica.

---

## 5. Mejoras propuestas por tema

### Tema01 — ConceptosBasicos

| Mejora | Descripción |
|--------|------------|
| Completar `Ejercicio05` y `Ejercicio06` | Nombres vacios — añadir descripción en el nombre |
| Renombrar `Primitivos.java` | No sigue el convenio `EjercicioXX` — mover a ejercicio de referencia |
| Añadir ejercicio de `Scanner` | El `Scanner` se usa mucho pero no hay ejercicio dedicado |

### Tema04 — Metodos

| Mejora | Descripción |
|--------|------------|
| Unificar en una sola carpeta | `Tema04_01`, `Tema04_02`, `Tema04_03` deberían ser subcarpetas de `Tema04Metodos/` |
| Ampliar `Tema04_03Polimorfismo` | Un solo ejercicio no es suficiente para este concepto |
| Añadir clases abstractas | `abstract class` es el paso natural despues de interfaces |

### Tema06 — Cadenas

| Mejora | Descripción |
|--------|------------|
| Ampliar de 2 a 12 ejercicios | Ver sección "Temas que faltan" para lista completa |
| Añadir expresiones regulares | `String.matches()`, `Pattern`, `Matcher` |
| `String.format()` y `printf` | Formato de cadenas — muy util en todos los temas |

### Tema07 — Clases

| Mejora | Descripción |
|--------|------------|
| Unificar nomenclatura | Mezcla `Ejercicio07ClasesEspeciales` (carpeta) con `DDBBPersonCocheCCorriente.java` (archivo suelto) |
| `DDBBPersonCocheCCorriente.java` | Nombre confuso — renombrar y mover dentro de una carpeta de ejercicio |
| Añadir `Ejercicio09` con `enum` | Natural despues de los ejercicios de clases |
| Documentar patrón de clase | Orden de elementos: constantes → campos → constructores → metodos |

### Tema08 — Herencia

| Mejora | Descripción |
|--------|------------|
| Crear `Ejercicio02` | El salto de 01 a 03 sugiere que falta un ejercicio |
| Añadir clases abstractas | `Tema08_01Herencia` no tiene ningun ejemplo con `abstract` |
| Añadir `@Override` explicito | Varios ejercicios sobreescriben sin la anotacion |

### Tema11 — Colecciones

| Mejora | Descripción |
|--------|------------|
| Corregir numeracion duplicada | Dos Ejercicio04 y dos Ejercicio06 — renombrar |
| Añadir `Deque` | `ArrayDeque` como pila y cola — el mas eficiente |
| Añadir `PriorityQueue` | Cola con prioridad — muy pedida en examenes |
| Mover o eliminar `Set.txt` | Archivo de texto suelto en la carpeta — su contenido debería estar en el README |

### Tema12 — AccesoDatos

| Mejora | Descripción |
|--------|------------|
| Corregir typo en nombre | `Tema12AcesoDatos` → `Tema12AccesoDatos` (doble 'c') |
| Crear ejercicio04 | La numeracion salta del 03 al 05 |
| Añadir `.properties` | Leer configuración desde fichero — muy util con JDBC |

### Tema13 — Streams

| Mejora | Descripción |
|--------|------------|
| Ampliar de 3 a 10+ ejercicios | Solo hay 3 archivos Java — insuficiente para el tema |
| Añadir ejercicios de `filter/map/collect` | Las operaciones fundamentales |
| Añadir `Optional` | Muy relacionado con Streams |
| Convertir Readme.txt a README.md | Unificar extension de documentacion |

### Tema14 — Threads

| Mejora | Descripción |
|--------|------------|
| Ampliar de 3 a 8+ ejercicios | Solo 3 ejercicios — el tema es muy importante |
| Añadir `ExecutorService` | El enfoque moderno para gestión de hilos |
| Añadir `Callable` y `Future` | Para hilos con valor de retorno |
| Documentar ciclo de vida | Diagrama ASCII: NEW → RUNNABLE → BLOCKED → TERMINATED |

### Tema15 — JDBC (actualmente llamado JPA)

| Mejora | Descripción |
|--------|------------|
| **Renombrar a `Tema15JDBC/`** | El nombre actual (JPA) es incorrecto |
| **Eliminar paquete `org.kabalera82`** | Codigo duplicado — mantener solo `tech.Kabadev` |
| **Sacar password del codigo** | `"221182"` en texto plano en GitHub público |
| Añadir `README.md` | Explicar patrón DAO, requisitos (MySQL), como configurar |
| Añadir transacciones | `setAutoCommit(false)`, `commit()`, `rollback()` |
| Añadir ejercicio sin GUI | La GUI de `Main.java` es demasiado compleja de entrada |

---

## 6. Problemas estructurales del repo

### Tema numerados con esquema inconsistente

- Algunos temas usan `_01` y `_02` como subtema: `Tema04_01`, `Tema04_02`, `Tema04_03`, `Tema05_01`, `Tema05_02`, `Tema08_01`, `Tema08_02`
- Otros son carpetas directas: `Tema01`, `Tema02`...

**Propuesta:** Usar subcarpetas dentro de un tema en lugar de sufijos numericos:
```
Tema04Metodos/
├── 01-metodos-basicos/      ← era Tema04_01Metodos
├── 02-varargs-sobrecarga/   ← era Tema04_02VarArgs
└── 03-polimorfismo/         ← era Tema04_03Polimorfismo
```

---

### `Tema99EjerciciosMultiples` sin organizacion

Contiene ejercicios como `Algoritmos/` (que tiene FCFS, FIFO, SJF — mismos algoritmos de Java2), `Billetes/`, `campanadas/`, etc. No hay README y no queda claro si son examenes, practicas o ejercicios de repaso.

**Propuesta:** Crear `README.md` en Tema99 explicando el origen de cada ejercicio (examen, práctica, repaso).

---

### `data/` en la raíz del repo

Los archivos de datos (`clientes.txt`, `clientes.csv`, `datos.dat`, etc.) estan en la raíz en lugar de dentro de los ejercicios que los usan. Esto dificulta saber que ejercicio usa cada archivo.

**Propuesta:** Mover cada archivo a su ejercicio correspondiente o crear una carpeta `Tema12AccesoDatos/data/` centralizada.

---

### Falta `.gitignore` actualizado

El `.gitignore` actual es el de IntelliJ por defecto. No excluye:
- `out/` (compilados)
- `target/` (Maven build)
- `*.class`
- Ficheros de propiedades con credenciales (`database.properties`)

---

## 7. Convenios de codigo

### Naming

| Elemento | Convenio | Ejemplo |
|---------|----------|---------|
| Clase | PascalCase | `CuentaBancaria` |
| Metodo | camelCase | `calcularSaldo()` |
| Variable | camelCase | `nombreUsuario` |
| Constante | UPPER_SNAKE_CASE | `MAX_INTENTOS` |
| Paquete | lowercase sin acentos | `tema01conceptosbasicos` |
| Archivo | Igual que la clase pública | `CuentaBancaria.java` |

**Violaciones actuales:**
- `Ejercicio03OperadoresAritméticos.java` — acento en nombre de archivo
- `Ejercicio07MétodosBusqueda.java` — acento en nombre de archivo
- `ejercicio01persona/`, `ejercicio02coche/` en Tema07 — minuscula
- `Main.java` suelto en Tema07 — sin contexto de cual ejercicio es

### Excepciones

```java
// MAL — bloque catch vacio
} catch (Exception e) { }

// MAL — solo printStackTrace en produccion
} catch (IOException e) { e.printStackTrace(); }

// BIEN
} catch (IOException e) {
    System.err.println("Error al leer: " + e.getMessage());
}
```

### Credenciales

**NUNCA** poner passwords, tokens o credenciales en el codigo fuente. Usar variables de entorno o ficheros `.properties` excluidos del control de versiones:

```
# .gitignore
database.properties
application.local.properties
*.env
```

---

## 8. Hoja de ruta

### Prioridad 1 — Seguridad y basura (hacer ANTES de cualquier otra cosa)

- [ ] **ELIMINAR `red.text`** — expone IPs reales del sistema en repo público
- [ ] **ELIMINAR `errores.txt`** — archivo vacio sin proposito
- [ ] **Eliminar password hardcodeada** en `Tema15JPA/Conexión.java` — `"221182"` en repo público
- [ ] **Eliminar paquete duplicado** `org.kabalera82` de `Tema15JPA/`
- [ ] Crear `README.md` (este archivo) y eliminar `Readme.txt`

### Prioridad 2 — Bugs estructurales

- [ ] Corregir numeracion duplicada en `Tema11Colecciones/` (Ejercicio04×2, Ejercicio06×2)
- [ ] Crear o aclarar `Ejercicio02` en `Tema08_01Herencia/`
- [ ] Renombrar `Tema15JPA/` a `Tema15JDBC/`
- [ ] Corregir typo `Tema12AcesoDatos/` → `Tema12AccesoDatos/`
- [ ] Renombrar archivos con acentos: `Ejercicio03OperadoresAritméticos.java`, `Ejercicio07MétodosBusqueda.java`

### Prioridad 3 — Temas que necesitan contenido urgente

- [ ] **Crear `Tema10Excepciones/`** — tema completamente ausente, crítico para 1ºDAM
- [ ] Ampliar `Tema06CadenasDeCaracteres/` de 2 a 10+ ejercicios
- [ ] Ampliar `Tema04_03Polimorfismo/` con clases abstractas
- [ ] Ampliar `Tema13Streams/` de 3 a 10+ ejercicios
- [ ] Ampliar `Tema14Threads/` de 3 a 8+ ejercicios

### Prioridad 4 — Limpieza estructural

- [ ] Implementar o eliminar `Tema16JavaServerPages/` (actualmente vacio)
- [ ] Mover archivos de `data/` raíz al ejercicio correspondiente
- [ ] Añadir `Tema99EjerciciosMultiples/README.md` explicando el origen de cada ejercicio
- [ ] Unificar nomenclatura de subtemas (Tema04_01 vs subcarpetas)

### Prioridad 5 — Mejoras de calidad

- [ ] Añadir `enum` como ejercicio en Tema07 o Tema09
- [ ] Añadir Generics basicos como ejercicio en Tema11Colecciones
- [ ] Documentar patrón DAO en `Tema15JDBC/`
- [ ] Añadir transacciones JDBC en `Tema15JDBC/`
- [ ] Actualizar `.gitignore` para excluir `target/`, `out/`, `*.class`, `database.properties`

---

## 9. Requisitos y compilacion

**Requisitos:**
- **Java 17+** (recomendado) — el `pom.xml` raíz usa Java 24
- **Maven 3.6+** — para `Tema15JPA/`, `Tema16JavaServerPages/`
- **MySQL 8+** — para `Tema15JPA/` (JDBC)
- **IDE recomendado:** IntelliJ IDEA o VS Code con Extension Pack for Java

**Compilar un ejercicio sin IDE:**

```bash
# Ejercicios sueltos (Tema01-Tema06, sin package complejo)
javac -d out Tema01ConceptosBasicos/Ejercicio01HolaMundo.java
java -cp out Tema01ConceptosBasicos.Ejercicio01HolaMundo

# Ejercicios en carpeta con package
javac -d out Tema07Clases/ejercicio01persona/*.java
java -cp out ejercicio01persona.Main

# Tema15JPA con Maven
cd Tema15JPA
mvn compile
mvn exec:java -Dexec.mainClass="tech.Kabadev.gui.Main"
```

**Estructura de cada tema:**
```
TemaXX/
├── README.md           ← Teoria + índice de ejercicios
├── EjercicioXX/        ← Cada ejercicio en su carpeta
│   ├── Main.java       ← Punto de entrada
│   └── *.java          ← Clases auxiliares
└── data/               ← Archivos de datos si aplica
```

---

*Ultima actualizacion: 2026-03-21*
