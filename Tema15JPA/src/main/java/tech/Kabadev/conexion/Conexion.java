package tech.Kabadev.conexion;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Esta clase gestiona la conexión a la base de datos MySQL.
 *
 * <p>Centraliza la obtención de una {@link Connection} hacia un servidor
 * MySQL en <code>localhost:3306</code> contra la base de datos
 * <code>tutorial</code>.</p>
 *
 * <p>Los parámetros (URL, usuario, contraseña) están codificados para
 * un entorno de desarrollo.</p>
 *
 * <h2>Requisitos</h2>
 * <ul>
 *   <li>Tener en el classpath el driver oficial de MySQL (por ejemplo, <code>mysql-connector-j</code>).</li>
 * </ul>
 *
 * <p><b>Nota:</b> en entornos productivos es recomendable externalizar la
 * configuración (URL, usuario, contraseña) en un fichero de propiedades
 * o variables de entorno.</p>
 *
 * @author kabalera82
 * @version 1.0
 */
public class Conexion {

    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return objeto {@link Connection} si la conexión es exitosa, o {@code null} en caso de error.
     */

    public static Connection getConexion(){

        // Parámetros de conexión ----------------------------------------------------------------------------

        Connection conexion = null;
        var baseDatos = "tutorial";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos +
                  "?createDatabaseIfNotExist=true"; //Y SI NO EXISTE LA CREAS
        var usuario = "root";
        var password = "221182";

        //----------------------------------------------------------------------------------

        try {
            // Cargar el driver
            // Class.forName("com.mysql.jdbc.Driver"); // Obsoleto --> Clase propia de la conexion a la BBDD (Driver) <--
            // Solicita conexion con la direccion usuario y contraseña
            conexion = DriverManager.getConnection(url, usuario, password); // --> pasamos la direccion usuario y pass de MySQL

        } catch (Exception e) {
            System.out.println("Error al conectar a la BBDD:" + e.getMessage());
        }

        // Retornamos la conexión.
        return conexion;


    }
}
