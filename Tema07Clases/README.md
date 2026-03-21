# Tema 07 — Clases y POO

> Prerequisito: Tema 01-06

Programación Orientada a Objetos: clases, objetos, constructores, encapsulamiento, modificadores de acceso y metodos especiales.

---

## Teoria rapida

### Anatomia de una clase

```java
public class Persona {
    // 1. Campos (atributos) — privados por encapsulamiento
    private String nombre;
    private int edad;
    private static int contador = 0;  // atributo de clase (compartido)

    // 2. Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contador++;
    }

    // 3. Metodos de acceso (getters/setters)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }

    // 4. Metodos de negocio
    public boolean esMayorDeEdad() { return edad >= 18; }

    // 5. Metodo estatico (de clase, no de instancia)
    public static int getContador() { return contador; }

    // 6. toString
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
```

### Instanciar y usar un objeto

```java
Persona p1 = new Persona("Ana", 25);
Persona p2 = new Persona("Luis", 17);

p1.getNombre()           // "Ana"
p1.esMayorDeEdad()       // true
p2.esMayorDeEdad()       // false
Persona.getContador()    // 2 — atributo estatico, se accede con el nombre de clase
System.out.println(p1);  // llama a toString(): Persona{nombre='Ana', edad=25}
```

### Modificadores de acceso

| Modificador | Clase | Paquete | Subclase | Todos |
|-------------|-------|---------|----------|-------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

### Constructores multiples (sobrecarga)

```java
public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacio
    public Producto() {}

    // Constructor parcial
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;  // valor por defecto
    }

    // Constructor completo
    public Producto(String nombre, double precio, int stock) {
        this(nombre, precio);  // reutiliza el constructor anterior
        this.stock = stock;
    }
}
```

### `static` — atributos y metodos de clase

```java
public class Contador {
    private static int total = 0;  // compartido por todas las instancias

    public Contador() { total++; }

    public static int getTotal() { return total; }
    // Se llama como: Contador.getTotal()
    // NO como: new Contador().getTotal()
}
```

---

## Ejercicios

| Carpeta/Archivo | Descripción |
|---------|------------|
| `Ejercicio00Modificadores/` | Modificadores de acceso public/private/protected |
| `ejercicio01persona/` | Clase `Persona` con getters/setters y toString |
| `ejercicio02coche/` | Clase `Coche` con atributos y metodos |
| `ejercicio03CuentaCorriente/` | Clase `CuentaCorriente` con saldo y operaciones |
| `ejercicio04Conversor/` | Clase con metodos de conversion de unidades |
| `ejercicio05restaurante/` | Simulacion de restaurante con varias clases |
| `ejercicio06Geometria/` | Clases de figuras geometricas |
| `ejercicio07personaSobrecarga/` | Sobrecarga de constructores en `Persona` |
| `ejercicio08Clonando/` | Clonacion de objetos |
| `CasteoDeClases/` | Casting entre tipos de clase |
| `ClasesEspeciales/` | Clases enum, record, sealed (especiales) |
| `DDBBPersonCocheCCorriente.java` | Uso combinado de Persona, Coche y CuentaCorriente |
| `Main.java` | Punto de entrada con demostracion general |

> ⚠️ **Pendiente:** unificar nomenclatura — algunos ejercicios usan `ejercicio` (minuscula) y otros `Ejercicio` (mayuscula).
