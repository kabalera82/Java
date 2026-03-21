# Tema 10b — Ficheros Binarios y Serialización

> Prerequisito: Tema 10a (ficheros de texto), Tema 07 (clases)

Lectura y escritura de objetos Java en ficheros binarios mediante `ObjectOutputStream` y `ObjectInputStream`. Para serializar un objeto, su clase debe implementar `Serializable`.

---

## Teoria rapida

### Serializable

```java
import java.io.Serializable;

// La clase DEBE implementar Serializable para poder guardarse en fichero binario
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;  // versión del objeto

    private String nombre;
    private double precio;
    private int stock;

    // constructores, getters, toString...
}
```

### Escribir objetos en fichero binario

```java
// Serializar: guardar objeto(s) en un fichero .dat
List<Producto> productos = new ArrayList<>();
productos.add(new Producto("Manzana", 1.20, 50));
productos.add(new Producto("Pera", 0.90, 30));

try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("data/productos.dat"))) {
    oos.writeObject(productos);  // guarda la lista completa
}
```

### Leer objetos desde fichero binario

```java
// Deserializar: recuperar objetos desde fichero .dat
try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("data/productos.dat"))) {

    @SuppressWarnings("unchecked")
    List<Producto> productos = (List<Producto>) ois.readObject();
    productos.forEach(System.out::println);

} catch (ClassNotFoundException e) {
    System.err.println("Clase no encontrada: " + e.getMessage());
}
```

### `serialVersionUID` — compatibilidad de versiones

```java
private static final long serialVersionUID = 1L;
```

Si la clase cambia (nuevos campos, metodos eliminados) y el `serialVersionUID` no coincide con el del fichero guardado, lanza `InvalidClassException`. Definirlo explicitamente evita problemas inesperados.

---

## Ejercicios

| Carpeta | Descripción |
|---------|------------|
| `Ejercicio01InsertaTabla/` | Guardar un array de datos en fichero binario |
| `Ejercicio02InsertaVersos/` | Escribir versos en fichero binario |
| `Ejercicio03RecuperaVersos/` | Leer y mostrar versos del fichero |
| `Ejercicio04/` | Operaciones combinadas lectura/escritura binaria |
| `Ejercicio05/` | Proyecto con serializacion de objetos completos |
| `cancionPirata.dat` | Fichero de datos de ejemplo |
