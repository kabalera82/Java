package tech.Kabadev.conexion;

//imports
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
/**
 * Esta clase gestiona la conexión a la base de datos.
 *
 * <p> Centraliza la obtencion de una {@link Connection} hacia un servidor</p>
 * <p>MySQL en {code:localhost:3306} contra la base de datos {@code pokemon}.
 * Los parámtetros se encuentran codificados para un entorno de desarrollo.</p>
 *
 * <h2>Requisitos</h2>
 * <ul>
 *     <li>Tener el classpath el driver oficial de MySQL:</li>
 * </ul>
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
