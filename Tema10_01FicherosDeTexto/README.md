# Tema 10a — Ficheros de Texto

> Prerequisito: Tema 07 (clases), Tema 09 (interfaces)

Lectura y escritura de archivos de texto en Java con `BufferedReader/Writer`, `FileReader/Writer` y la API moderna `Files` de NIO2.

---

## Teoria rapida

### Leer un fichero de texto

```java
import java.io.*;
import java.nio.file.*;

// OPCION 1: BufferedReader (clasico)
try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
}

// OPCION 2: Files.readAllLines (moderno, Java 7+) — carga todo en memoria
List<String> lineas = Files.readAllLines(Path.of("archivo.txt"));
lineas.forEach(System.out::println);

// OPCION 3: Files.lines (stream, Java 8+) — perezoso, ideal para ficheros grandes
Files.lines(Path.of("archivo.txt"))
     .filter(l -> !l.isBlank())
     .forEach(System.out::println);
```

### Escribir en un fichero de texto

```java
// OPCION 1: BufferedWriter (clasico)
try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
    bw.write("Primera linea");
    bw.newLine();
    bw.write("Segunda linea");
}

// OPCION 2: PrintWriter (mas comodo, como System.out)
try (PrintWriter pw = new PrintWriter(new FileWriter("salida.txt", true))) { // true = append
    pw.println("Linea nueva al final");
    pw.printf("Valor: %d%n", 42);
}

// OPCION 3: Files.writeString (moderno, Java 11+)
Files.writeString(Path.of("salida.txt"), "Contenido completo");

// OPCION 4: Files.write con lista
List<String> lineas = List.of("linea1", "linea2", "linea3");
Files.write(Path.of("salida.txt"), lineas);
```

### try-with-resources — OBLIGATORIO para I/O

```java
// El bloque try cierra automaticamente el recurso al salir, incluso si hay excepcion
try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
    // usar br
}  // br.close() se llama aqui automaticamente
```

---

## Ejercicios

| Carpeta | Descripcion |
|---------|------------|
| `Ejercicio01Ejemplo/` | Leer y mostrar el contenido de un fichero |
| `Ejercicio02Bonana/` | Leer fichero de frutas, procesarlo y escribir resultado |
