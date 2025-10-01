package tech.Kabadev.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Esta clase gestiona la conexión a la base de datos MySQL y
 * asegura que la base de datos y las tablas necesarias existan.
 *
 * <p>Centraliza la obtención de una {@link Connection} hacia un servidor
 * MySQL en <code>localhost:3306</code> contra la base de datos
 * <code>tutorial</code>.</p>
 *
 * <p>Además, proporciona un método auxiliar para inicializar la base de datos
 * creando la tabla {@code usuario} si no existe.</p>
 *
 * <h2>Requisitos</h2>
 * <ul>
 *   <li>Tener en el classpath el driver oficial de MySQL
 *       (por ejemplo, <code>mysql-connector-j</code>).</li>
 *   <li>Un servidor MySQL en ejecución en <code>localhost:3306</code>.</li>
 * </ul>
 *
 * <p><b>Nota:</b> en entornos productivos es recomendable externalizar la
 * configuración (URL, usuario, contraseña) en un fichero de propiedades
 * o variables de entorno.</p>
 *
 * @author kabalera82
 * @version 1.1
 */
public class Conexion {

    // -------------------------------------------------------------------------
    // Parámetros de conexión (hardcodeados en entorno de desarrollo)
    // -------------------------------------------------------------------------
    private static final String BASE_DATOS = "tutorial";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BASE_DATOS
            + "?createDatabaseIfNotExist=true"; // crea la BD si no existe
    private static final String USUARIO = "root";
    private static final String PASSWORD = "221182";

    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return objeto {@link Connection} si la conexión es exitosa, o {@code null} en caso de error.
     */
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error al conectar a la BBDD: " + e.getMessage());
        }
        return conexion;
    }

    /**
     * Inicializa la base de datos creando la tabla {@code usuario} si no existe.
     *
     * <p>Este método se puede invocar al inicio de la aplicación
     * (por ejemplo, en el {@code main}) para garantizar que la tabla
     * requerida está disponible antes de ejecutar operaciones CRUD.</p>
     */
    public static void inicializarBD() {
        String sql = """
                CREATE TABLE IF NOT EXISTS usuario (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(50) NOT NULL,
                    primerApellido VARCHAR(50) NOT NULL,
                    segundoApellido VARCHAR(50) NOT NULL,
                    telefono VARCHAR(20),
                    email VARCHAR(100)
                )
                """;

        try (Connection conexion = getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.execute();
            System.out.println("Tabla 'usuario' verificada/creada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al inicializar la BD: " + e.getMessage());
        }
    }
}
