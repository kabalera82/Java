# Tema 04c — Polimorfismo y Clases Abstractas

> Prerequisito: Tema 07 (clases), Tema 08_01 (herencia)

El polimorfismo es la capacidad de un objeto de tomar distintas formas.
Una variable de tipo `Animal` puede apuntar a un `Perro` o un `Gato` — y al llamar a `hacerSonido()`, Java ejecuta la version correcta segun el tipo real del objeto.

---

## Teoria rapida

### Clases abstractas

```java
// No se puede instanciar — solo sirve como base
public abstract class Figura {
    protected String color;

    public Figura(String color) { this.color = color; }

    // Metodo abstracto — SIN cuerpo, las subclases DEBEN implementarlo
    public abstract double area();

    // Metodo concreto — las subclases lo heredan o lo sobreescriben
    public void describir() {
        System.out.println(getClass().getSimpleName() + ": area = " + area());
    }
}

// Subclase concreta — DEBE implementar area()
public class Circulo extends Figura {
    private double radio;
    public Circulo(String color, double radio) { super(color); this.radio = radio; }

    @Override
    public double area() { return Math.PI * radio * radio; }
}
```

### Polimorfismo en accion

```java
// Variable de tipo abstracto — puede apuntar a cualquier subclase
Figura[] figuras = {
    new Circulo("rojo", 5),
    new Rectangulo("azul", 4, 6),
    new Triangulo("verde", 3, 4, 5, 5)
};

// Java ejecuta el area() CORRECTO de cada objeto
for (Figura f : figuras) {
    f.describir(); // polimorfismo en tiempo de ejecucion
}
```

### Casting e instanceof

```java
// Upcasting — implicito, siempre seguro
Figura f = new Circulo("rojo", 5);

// Downcasting — puede fallar, SIEMPRE comprobar con instanceof
if (f instanceof Circulo c) {          // pattern matching Java 16+
    System.out.println(c.getRadio());
}

// Sin instanceof puede lanzar ClassCastException
Rectangulo r = (Rectangulo) f; // ERROR en tiempo de ejecucion
```

---

## Ejercicios

| Carpeta | Descripcion |
|---------|-------------|
| `Ejercicio01/` | Polimorfismo basico — `Animal`, `Perro`, `Gato` con `hacerSonido()` |
| `Ejercicio02ClasesAbstractas/` | Clase abstracta `Figura` → `Circulo`, `Rectangulo`, `Triangulo` |
| `Ejercicio03ListaPolimorfica/` | Lista `List<Vehiculo>` con `Coche`, `Moto`, `Barco` |
| `Ejercicio04Casting/` | Upcasting, downcasting, `instanceof`, `ClassCastException` |
