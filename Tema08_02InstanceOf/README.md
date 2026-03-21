# Tema 08b — instanceof y Casting de Objetos

> Prerequisito: Tema 08a (herencia)

Comprobacion de tipos en tiempo de ejecucion con `instanceof` y casting seguro entre clases de una jerarquía.

---

## Teoria rapida

### instanceof — comprobar el tipo real

```java
Animal a = new Perro("Rex", 3, "Labrador");

// instanceof devuelve true si el objeto es del tipo (o de una subclase)
a instanceof Animal   // true
a instanceof Perro    // true
a instanceof Gato     // false

// Patrón clasico antes de un cast
if (a instanceof Perro) {
    Perro p = (Perro) a;   // cast seguro
    p.ladrar();
}
```

### Pattern matching con instanceof (Java 16+)

```java
// Forma moderna — evita el cast manual
if (a instanceof Perro p) {
    p.ladrar();  // p ya es de tipo Perro aqui dentro
}

// En un switch (Java 21+)
String resultado = switch (a) {
    case Perro p -> "Es un perro: " + p.getRaza();
    case Gato g  -> "Es un gato";
    default      -> "Otro animal";
};
```

### ClassCastException — error de casting

```java
Animal a = new Gato("Mimi", 5);

// INCORRECTO — ClassCastException en tiempo de ejecucion
Perro p = (Perro) a;  // Gato NO puede castearse a Perro

// CORRECTO — comprobar siempre antes de castear
if (a instanceof Perro) {
    Perro p = (Perro) a;  // solo llega aqui si realmente es Perro
}
```

---

## Ejercicios

| Carpeta | Descripción |
|---------|------------|
| `ejercicio01/` | Uso de `instanceof` en jerarquía de clases |
| `ejercicio02Interfaz/` | `instanceof` con interfaces |
