package tech.Kabadev.dao;

import tech.Kabadev.conexion.Conexion;
import tech.Kabadev.model.Usuario;

//Imports necesarios para la conexion con MySQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



public class UsuarioDAO implements IUsuarioDAO{
    /**
     * Recupera todos los registros de la tabla {@code usuario} ordenador por id
     *
     * <p>Este método establece uia conexión a la base de datos mediante {@link Conexion#getConexion()},</p>
     * @return
     */
    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        // interfaz JDBC que representa una sentencia SQL por ejemplo: INSERT, UPDATE, DELETE, SELECT).
        PreparedStatement prepStet;
        // interfaz de JDBC que representa un consjunto de resultados devueltos por la sentencia SQL
        ResultSet resultEst;
        Connection conexion = Conexion.getConexion();
        var sql = "SELECT * FROM usuario ORDER BY id";
        try {
            prepStet = conexion.prepareStatement(sql);
            resultEst = prepStet.executeQuery();
            while(resultEst.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultEst.getInt("id"));
                usuario.setNombre(resultEst.getString("nombre"));
                usuario.setPrimerApellido(resultEst.getString("primerApellido"));
                usuario.setSegundoApellido(resultEst.getString("segundoApellido"));
                usuario.setTelefono(resultEst.getString("telefono"));
                usuario.setEmail(resultEst.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Error al listar los usuarios: " +e.getMessage());;
        }
        finally {
            try{
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return usuarios;
    }

    @Override
    public boolean buscarUsuarioId(Usuario usuario) {
        // interfaz JDBC que representa una sentencia SQL por ejemplo: INSERT, UPDATE, DELETE, SELECT).
        PreparedStatement prepStet;
        // interfaz de JDBC que representa un consjunto de resultados devueltos por la sentencia SQL
        ResultSet resultEst;
        Connection conexion = Conexion.getConexion();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try{
            prepStet = conexion.prepareStatement(sql);
            prepStet.setInt(1, usuario.getId());
            resultEst = prepStet.executeQuery();
            // Avanza el cursor a la siguiente fila del ResultSet y devuelve true si existe, permitiendo recorrer todos los registros de la consulta
            if (resultEst.next()){
                usuario.setNombre(resultEst.getString("nombre"));
                usuario.setPrimerApellido((resultEst.getString("primerApellido")));
                usuario.setSegundoApellido(resultEst.getString("segundoApellido"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el usuario");
        }
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        // interfaz JDBC que representa una sentencia SQL por ejemplo: INSERT, UPDATE, DELETE, SELECT).
        PreparedStatement prepStet;
        // interfaz de JDBC que representa un consjunto de resultados devueltos por la sentencia SQL
        ResultSet resultEst;
        Connection conexion = Conexion.getConexion();
        String sql = "INSERT INTO usuario(nombre, primerApellido, segundoApellido, telefono, email) + VALUES (?, ?, ?, ?, ?)";
        try{
            prepStet = conexion.prepareStatement(sql);
            prepStet.setInt(1, usuario.getId());
            resultEst = prepStet.executeQuery();
            // Avanza el cursor a la siguiente fila del ResultSet y devuelve true si existe, permitiendo recorrer todos los registros de la consulta
            if (resultEst.next()){
                usuario.setNombre(resultEst.getString("nombre"));
                usuario.setPrimerApellido((resultEst.getString("primerApellido")));
                usuario.setSegundoApellido(resultEst.getString("segundoApellido"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el usuario");
        }
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        return false;
    }
}
