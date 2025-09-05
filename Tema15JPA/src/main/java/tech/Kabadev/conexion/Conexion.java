package tech.Kabadev.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion(){

        //----------------------------------------------------------------------------------

        Connection conexion = null;
        var baseDatos = "pokemon";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;

        //----------------------------------------------------------------------------------

        var usuario = "root";
        var password = "221182";

        //----------------------------------------------------------------------------------

        try {
            Class.forName("com.mysql.jdbc.Driver"); // --> Clase propia de la conexion a la BBDD (Driver) <--
            conexion = DriverManager.getConnection(url, usuario, password); // --> pasamos la direccion usuario y pass de MySQL

        } catch (Exception e) {
            System.out.println("Error al conectar a la BBDD:" + e.getMessage());
        }

        return conexion;
    }
}
