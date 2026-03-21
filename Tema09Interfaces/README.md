# Tema 09 — Interfaces

> Prerequisito: Tema 08 (herencia)

Interfaces en Java: definicion, implementacion, herencia multiple de interfaces y diferencia con clases abstractas.

---

## Teoria rapida

### Definir e implementar una interfaz

```java
// Una interfaz es un contrato: define QUE hay que hacer, no COMO
public interface Reproducible {
    void reproducir();              // metodo abstracto (publico por defecto)
    void pausar();
    void detener();

    // Metodo con implementacion por defecto (Java 8+)
    default void reiniciar() {
        detener();
        reproducir();
    }

    // Constante (implicitamente public static final)
    int MAX_VOLUMEN = 100;
}

// Una clase puede implementar varias interfaces
public class Cancion implements Reproducible, Descargable {
    @Override
    public void reproducir() { System.out.println("Reproduciendo cancion..."); }
    @Override
    public void pausar() { System.out.println("Pausado."); }
    @Override
    public void detener() { System.out.println("Detenido."); }
    @Override
    public void descargar() { System.out.println("Descargando cancion..."); }
}
```

### Interfaz vs Clase abstracta

| | Interfaz | Clase abstracta |
|--|----------|----------------|
| Herencia multiple | ✅ (implements varias) | ❌ (extends solo una) |
| Metodos concretos | ✅ (solo `default`) | ✅ (cualquier metodo) |
| Atributos de instancia | ❌ (solo constantes) | ✅ |
| Constructor | ❌ | ✅ |
| Usar cuando... | Contrato compartido entre clases no relacionadas | Compartir codigo entre clases relacionadas |

### Interfaz como tipo

```java
// Una variable de tipo interfaz puede referenciar cualquier clase que la implemente
Reproducible r = new Cancion("Bohemian Rhapsody");
r.reproducir();

// Lista de objetos que implementan la interfaz
List<Reproducible> lista = new ArrayList<>();
lista.add(new Cancion("Cancion 1"));
lista.add(new Video("Video 1"));
lista.forEach(Reproducible::reproducir);  // polimorfismo
```

### Herencia de interfaces

```java
// Una interfaz puede extender otras interfaces
public interface Multimedia extends Reproducible, Descargable {
    int getDuracion();
}
```

---

## Ejercicios

| Carpeta | Descripcion |
|---------|------------|
| `Ejercicio01/` | Definir e implementar una interfaz basica |
| `Ejercicio02Lista/` | Lista de objetos tipada con una interfaz |
| `Ejercicio03Jerarquia/` | Jerarquia de interfaces (interfaz extiende interfaz) |
| `Ejercicio04Hibrida/` | Clase que hereda de clase abstracta e implementa interfaz |
