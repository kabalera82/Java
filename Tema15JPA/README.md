# Tema 15 — JDBC con MySQL

> Prerequisito: Tema 12 (acceso a datos), Tema 07 (clases y POO)

Acceso a bases de datos relacionales con JDBC (Java Database Connectivity). Patrón DAO para separar la lógica de acceso a datos de la lógica de negocio.

> ⚠️ **Este tema esta MAL NOMBRADO.** La carpeta se llama `Tema15JPA` pero el codigo usa JDBC (`java.sql.Connection`, `DriverManager`, `PreparedStatement`), NO JPA (que usaria Hibernate y anotaciones `@Entity`). Pendiente renombrar a `Tema15JDBC/`.
>
> ⚠️ **SEGURIDAD:** hay una password de base de datos hardcodeada en `Conexión.java`. Ver [README raíz](../README.md#bugs-y-errores-pendientes).
>
> ⚠️ **Codigo duplicado:** las mismas clases existen en paquete `org.kabalera82` y en `tech.Kabadev`. Pendiente eliminar una de las dos.

---

## Requisitos

- **MySQL 8+** corriendo en `localhost:3306`
- Crear la base de datos `tutorial` (o usar `createDatabaseIfNotExist=true` en la URL)
- `mysql-connector-java 8.0.33` (incluido en `pom.xml`)

---

## Teoria rapida

### Conexión JDBC

```java
// Los 5 pasos de JDBC
// 1. Registrar el driver (automatico desde Java 6)
// 2. Obtener la conexión
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mi_bd", "usuario", "password");

// 3. Crear el statement
PreparedStatement ps = conn.prepareStatement(
    "SELECT * FROM usuario WHERE id = ?");
ps.setInt(1, 5);

// 4. Ejecutar y procesar resultados
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    System.out.println(rs.getInt("id") + " - " + rs.getString("nombre"));
}

// 5. Cerrar recursos (try-with-resources lo hace automáticamente)
```

### PreparedStatement — SIEMPRE para queries con parametros

```java
// MAL — vulnerable a SQL Injection
String sql = "SELECT * FROM usuario WHERE nombre = '" + nombre + "'";
// Un atacante podria pasar: ' OR '1'='1 -- y ver todos los registros

// BIEN — PreparedStatement escapa los parametros
PreparedStatement ps = conn.prepareStatement(
    "SELECT * FROM usuario WHERE nombre = ?");
ps.setString(1, nombre);  // ? se reemplaza de forma segura
```

### Patrón DAO (Data Access Object)

```java
// Interfaz — define el contrato
public interface IUsuarioDAO {
    List<Usuario> findAll();
    Usuario findById(int id);
    boolean save(Usuario u);
    boolean update(Usuario u);
    boolean delete(int id);
}

// Implementación — contiene el JDBC
public class UsuarioDAO implements IUsuarioDAO {
    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = Conexión.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("telefono"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
        return lista;
    }
    // ... resto de metodos CRUD
}
```

---

## Estructura del proyecto

```
Tema15JPA/
├── pom.xml                              ← mysql-connector-java 8.0.33
└── src/main/java/
    └── tech/Kabadev/
        ├── conexión/Conexión.java        ← getConexion() + inicializarBD()
        ├── model/Usuario.java            ← POJO con id, nombre, apellidos, email
        ├── dao/
        │   ├── IUsuarioDAO.java          ← interfaz del DAO
        │   └── UsuarioDAO.java           ← implementación JDBC
        └── gui/Main.java                 ← interfaz grafica con Swing
```

---

## Como ejecutar

```bash
# Asegurate de que MySQL esta corriendo
# La BD 'tutorial' se crea automáticamente (createDatabaseIfNotExist=true)

cd Tema15JPA
mvn compile
mvn exec:java -Dexec.mainClass="tech.Kabadev.gui.Main"
```

> **Nota:** antes de ejecutar, cambia el valor de `PASSWORD` en `Conexión.java` por el de tu instalacion MySQL, o mejor, exteriorizalo a una variable de entorno.
