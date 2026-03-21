# Tema 08a — Herencia

> Prerequisito: Tema 07 (clases y POO)

Herencia en Java: `extends`, `super`, sobreescritura de metodos y clases abstractas.

---

## Teoria rapida

### extends — heredar de una clase

```java
// Clase padre (superclase)
public class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {
        System.out.println(nombre + " esta comiendo.");
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " anos)";
    }
}

// Clase hija (subclase) — hereda todo lo de Animal
public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);  // llama al constructor del padre — DEBE IR PRIMERO
        this.raza = raza;
    }

    // Sobreescribir un metodo del padre
    @Override
    public void comer() {
        System.out.println(nombre + " come pienso de perro.");
    }

    // Nuevo metodo propio de Perro
    public void ladrar() {
        System.out.println("¡Guau!");
    }
}
```

### Clases abstractas

```java
// No se puede instanciar directamente — sirve como base para otras clases
public abstract class Figura {
    // Metodo abstracto — sin implementación, OBLIGA a las subclases a implementarlo
    public abstract double area();
    public abstract double perimetro();

    // Metodo concreto — puede usarse tal cual por las subclases
    public void mostrar() {
        System.out.printf("Area: %.2f | Perimetro: %.2f%n", area(), perimetro());
    }
}

public class Circulo extends Figura {
    private double radio;
    public Circulo(double radio) { this.radio = radio; }

    @Override public double area() { return Math.PI * radio * radio; }
    @Override public double perimetro() { return 2 * Math.PI * radio; }
}
```

### Polimorfismo

```java
// Variable de tipo padre, objeto de tipo hijo — polimorfismo
Animal a = new Perro("Rex", 3, "Labrador");
a.comer();  // llama al metodo de Perro (no de Animal) — enlace dinamico

// Lista de animales con distintos tipos
List<Animal> animales = List.of(
    new Perro("Rex", 3, "Labrador"),
    new Gato("Mimi", 5)
);
animales.forEach(Animal::comer);  // cada animal usa su propia implementación
```

---

## Ejercicios

| Carpeta | Descripción |
|---------|------------|
| `Ejercicio01Vehiculos/` | Jerarquía `Vehiculo → Coche/Moto/Camion` con `extends` y `super` |
| `Ejercicio03Planta/` | Jerarquía de plantas con metodos sobreescritos |

> ⚠️ **Pendiente:** falta `Ejercicio02`. Ver [README raíz](../README.md#bugs-y-errores-pendientes).
