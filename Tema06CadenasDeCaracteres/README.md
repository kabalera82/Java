# Tema 06 — Cadenas de Caracteres

> Prerequisito: Tema 01-04

Manejo de `String` y `StringBuilder` en Java. Metodos mas comunes, comparacion correcta y construccion eficiente de cadenas.


---

## Teoria rapida

### String — inmutable

```java
String s = "Hola Mundo";

// Longitud e indices
s.length()          // 10
s.charAt(0)         // 'H'
s.indexOf("Mundo")  // 5 — primera posicion
s.lastIndexOf('o')  // 9

// Substrings
s.substring(5)      // "Mundo"
s.substring(0, 4)   // "Hola"  (de 0 inclusive a 4 exclusive)

// Transformacion
s.toUpperCase()                  // "HOLA MUNDO"
s.toLowerCase()                  // "hola mundo"
s.trim()                         // elimina espacios al inicio y al final
s.replace("Mundo", "Java")       // "Hola Java"
s.replaceAll("[aeiou]", "*")     // regex: "H*l* M*nd*"

// Comprobaciones
s.contains("Mundo")              // true
s.startsWith("Hola")             // true
s.endsWith("Mundo")              // true
s.isEmpty()                      // false
s.isBlank()                      // false (isBlank también cuenta espacios)

// Division y union
String[] partes = s.split(" ");  // ["Hola", "Mundo"]
String.join("-", "a", "b", "c")  // "a-b-c"

// Formateo
String.format("Nombre: %s, Edad: %d", "Ana", 25); // "Nombre: Ana, Edad: 25"
```

### Comparacion — NUNCA usar `==`

```java
String a = "hola";
String b = "hola";

a == b          // NO usar — compara referencias, no contenido
a.equals(b)     // true — compara contenido (correcto)
a.equalsIgnoreCase("HOLA")  // true — sin importar mayusculas/minusculas

// Ordenar alfabeticamente
a.compareTo(b)  // 0 si iguales, <0 si a<b, >0 si a>b
```

### StringBuilder — mutable y eficiente

```java
// Usar cuando hay muchas concatenaciones en un bucle
// String + String crea un objeto nuevo en cada operación (ineficiente)

StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10; i++) {
    sb.append("item").append(i).append(", ");
}
String resultado = sb.toString();

// Metodos de StringBuilder
sb.insert(0, "INICIO: ");  // insertar en posicion
sb.delete(0, 7);           // eliminar rango
sb.reverse();              // invertir
sb.length()                // longitud actual
```

### Conversion entre tipos y String

```java
// Primitivo → String
String s1 = String.valueOf(42);       // "42"
String s2 = Integer.toString(42);     // "42"
String s3 = "" + 42;                  // "42" (concatenacion)

// String → Primitivo
int n = Integer.parseInt("42");        // 42
double d = Double.parseDouble("3.14"); // 3.14
boolean b = Boolean.parseBoolean("true"); // true
```

---

## Ejercicios

| Archivo | Descripción |
|---------|------------|
| `Ejercicio01.java` | Recorrer todos los caracteres Unicode (code points) |
| `Ejercicio02LongitudStrings.java` | Longitud y comparacion de cadenas |
| `Ejercicio03MetodosBasicos.java` | `length`, `charAt`, `indexOf`, `contains`, `trim`, `replace` |
| `Ejercicio04SplitJoin.java` | `split()` con separadores y regex, `String.join()` |
| `Ejercicio05Comparacion.java` | `equals` vs `==`, `equalsIgnoreCase`, `compareTo`, null safety |
| `Ejercicio06StringBuilder.java` | `StringBuilder` — rendimiento vs String, `append`, `insert`, `reverse` |
| `Ejercicio07Formato.java` | `String.format`, `printf`, tabla formateada con especificadores |
| `Ejercicio08Practico.java` | Palindromos, contar palabras, capitalizar, contar ocurrencias |
