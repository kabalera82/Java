# Tema 10 — Excepciones

> Prerequisito: Tema 07 (clases), Tema 09 (interfaces)

Mecanismo de Java para gestionar errores en tiempo de ejecucion de forma controlada.
Sin excepciones, cualquier error inesperado termina el programa de golpe.

---

## Teoria rapida

### Jerarquia de excepciones

```
Throwable
├── Error              — errores graves de la JVM (no capturar)
│   ├── OutOfMemoryError
│   └── StackOverflowError
│
└── Exception          — errores del programa
    ├── RuntimeException  ← UNCHECKED — el compilador no obliga a tratar
    │   ├── NullPointerException
    │   ├── ArithmeticException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── NumberFormatException
    │   └── IllegalArgumentException
    │
    └── IOException       ← CHECKED — el compilador obliga a tratar
        ├── FileNotFoundException
        └── SQLException (en java.sql)
```

**Checked vs Unchecked:**
- **Checked** (`Exception`): el compilador exige `try-catch` o declarar `throws`. Ejemplo: `IOException`.
- **Unchecked** (`RuntimeException`): el compilador no exige nada. Ejemplo: `NullPointerException`.

---

### try-catch-finally

```java
try {
    // codigo que puede lanzar excepcion
    int resultado = 10 / 0;

} catch (ArithmeticException e) {
    // se ejecuta si se lanza ArithmeticException
    System.out.println("Error: " + e.getMessage());

} catch (Exception e) {
    // SIEMPRE al final — es la clase padre de todas
    System.out.println("Error inesperado: " + e.getMessage());

} finally {
    // se ejecuta SIEMPRE, haya excepcion o no
    // tipicamente para cerrar recursos
    System.out.println("Bloque finally");
}
```

### Multi-catch (Java 7+)

```java
try {
    // ...
} catch (NumberFormatException | ArithmeticException e) {
    System.out.println("Formato o aritmetica: " + e.getMessage());
}
```

### throw y throws

```java
// throw — lanza una excepcion en un punto concreto
throw new IllegalArgumentException("Valor no valido: " + valor);

// throws — declara que un metodo puede lanzar una excepcion checked
public void leerFichero(String ruta) throws IOException {
    // ...
}
```

### Excepcion personalizada

```java
// Unchecked (extiende RuntimeException) — no obliga al llamador
class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(double importe) {
        super("Saldo insuficiente para " + importe + " euros");
    }
}

// Checked (extiende Exception) — obliga al llamador a usar try-catch
class PasswordDemasiadoCortoException extends Exception {
    public PasswordDemasiadoCortoException(int longitud) {
        super("Password con " + longitud + " caracteres. Minimo 8.");
    }
}
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|-------------|
| `Ejercicio01TryCatch.java` | `try-catch` basico con los 4 tipos mas comunes |
| `Ejercicio02MultipleCatch.java` | Multiples `catch` y multi-catch con `\|` |
| `Ejercicio03Finally.java` | Bloque `finally` — cuando y por que usarlo |
| `Ejercicio04ExcepcionPersonalizada.java` | Crear y lanzar excepciones propias |
| `Ejercicio05ThrowThrows.java` | `throw` vs `throws`, checked vs unchecked |
| `Ejercicio06Practica.java` | Sistema de registro con validacion completa |

---

## Referencia rapida

```java
// Obtener informacion de la excepcion
e.getMessage()      // mensaje de error
e.getClass().getName() // tipo de excepcion
e.printStackTrace() // traza completa (para depuracion)

// Relanzar excepcion
catch (Exception e) {
    // hacer algo
    throw e; // relanzar la misma
}

// try-with-resources (Java 7+) — cierra el recurso automaticamente
try (Scanner sc = new Scanner(System.in)) {
    // sc.close() se llama automaticamente al salir del try
}
```
