# Tema 12 — Acceso a Datos

> Prerequisito: Tema 10 (ficheros), Tema 11 (colecciones)

Lectura y escritura de ficheros en distintos formatos: texto plano, CSV y JSON. Introduccion a la persistencia de datos sin base de datos.

> ⚠️ **Typo en nombre de carpeta:** `Tema12AcesoDatos` → deberia ser `Tema12AccesoDatos` (doble 'c').
> ⚠️ **Pendiente:** falta `ejercicio04` — la numeracion salta del 03 al 05.

---

## Teoria rapida

### Texto plano con `BufferedReader`

```java
Path ruta = Path.of("data", "clientes.txt");

// Leer linea a linea
try (BufferedReader br = Files.newBufferedReader(ruta)) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
}

// Escribir
try (BufferedWriter bw = Files.newBufferedWriter(ruta,
        StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
    bw.write("Nueva linea");
    bw.newLine();
}
```

### CSV — valores separados por coma

```java
// Formato: nombre,apellido,edad,email
// Ana,Garcia,25,ana@mail.com

// Leer y parsear CSV manualmente
List<Cliente> clientes = new ArrayList<>();
try (BufferedReader br = Files.newBufferedReader(Path.of("clientes.csv"))) {
    String linea;
    br.readLine(); // saltar cabecera si existe
    while ((linea = br.readLine()) != null) {
        String[] partes = linea.split(",");
        clientes.add(new Cliente(partes[0], partes[1],
                                 Integer.parseInt(partes[2]), partes[3]));
    }
}

// Escribir CSV
try (BufferedWriter bw = Files.newBufferedWriter(Path.of("salida.csv"))) {
    bw.write("nombre,apellido,edad,email");
    bw.newLine();
    for (Cliente c : clientes) {
        bw.write(c.getNombre() + "," + c.getApellido() + ","
                + c.getEdad() + "," + c.getEmail());
        bw.newLine();
    }
}
```

### JSON — con biblioteca externa (Jackson o Gson)

```java
// Con Jackson (dependencia Maven: com.fasterxml.jackson.core:jackson-databind)
ObjectMapper mapper = new ObjectMapper();

// Leer JSON → objeto Java
Cliente cliente = mapper.readValue(new File("cliente.json"), Cliente.class);

// Objeto Java → JSON
mapper.writeValue(new File("salida.json"), cliente);
String json = mapper.writeValueAsString(cliente);  // como String
```

---

## Ejercicios

| Carpeta | Descripcion |
|---------|------------|
| `ejercicio01/` | Leer fichero de texto plano linea a linea |
| `ejercicio02Texto/` | Escribir y leer datos de clientes en texto |
| `ejercicio03/` | Procesamiento de texto con busqueda |
| `ejercicio05json/` | Leer y procesar datos en formato JSON ⚠️ falta ejercicio04 |
| `ejercicio06csv/` | Leer y escribir fichero CSV de productos (incluye PDF con enunciado) |
