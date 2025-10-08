package org.kabalera82.dao;

import org.kabalera82.conexion.Conexion;
import org.kabalera82.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz {@link IUsuarioDAO} que gestiona
 * las operaciones CRUD (Create, Read, Update, Delete) sobre la entidad
 * {@link Usuario} en la base de datos.
 *
 * <p>Utiliza la clase {@link Conexion} para obtener conexiones JDBC
 * contra una base de datos MySQL.</p>
 *
 * <h2>Operaciones soportadas:</h2>
 * <ul>
 *   <li>Listar todos los usuarios</li>
 *   <li>Buscar usuario por su ID</li>
 *   <li>Insertar un nuevo usuario</li>
 *   <li>Modificar datos de un usuario existente</li>
 *   <li>Eliminar un usuario por ID</li>
 * </ul>
 *
 * @author Marcos
 * @version 1.0
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * Recupera todos los registros de la tabla {@code usuario}, ordenados por el campo {@code id}.
     *
     * <p>Crea una lista de objetos {@link Usuario} a partir de los datos almacenados
     * en la base de datos. Cada fila del {@link ResultSet} se transforma en un objeto
     * con sus atributos mapeados.</p>
     *
     * @return una lista de objetos {@link Usuario}. Si no hay registros devuelve una lista vacía.
     */
    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY id";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prepStet = conexion.prepareStatement(sql);
             ResultSet resultEst = prepStet.executeQuery()) {

            while (resultEst.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultEst.getInt("id"));
                usuario.setNombre(resultEst.getString("nombre"));
                usuario.setPrimerApellido(resultEst.getString("primerApellido"));
                usuario.setSegundoApellido(resultEst.getString("segundoApellido"));
                usuario.setTelefono(resultEst.getString("telefono"));
                usuario.setEmail(resultEst.getString("email"));

                usuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    /**
     * Busca un usuario concreto en la tabla {@code usuario} a partir de su {@code id}.
     *
     * <p>El objeto {@link Usuario} recibido como parámetro debe contener un {@code id} válido.
     * Si el usuario existe, se actualizan los atributos del objeto con los valores obtenidos
     * de la base de datos.</p>
     *
     * @param usuario objeto de tipo {@link Usuario} que contiene el {@code id} a buscar.
     * @return {@code true} si el usuario existe y se actualizaron sus datos, {@code false} en caso contrario.
     */
    @Override
    public boolean buscarUsuarioId(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prepStet = conexion.prepareStatement(sql)) {

            prepStet.setInt(1, usuario.getId());
            try (ResultSet resultEst = prepStet.executeQuery()) {
                if (resultEst.next()) {
                    usuario.setNombre(resultEst.getString("nombre"));
                    usuario.setPrimerApellido(resultEst.getString("primerApellido"));
                    usuario.setSegundoApellido(resultEst.getString("segundoApellido"));
                    usuario.setTelefono(resultEst.getString("telefono"));
                    usuario.setEmail(resultEst.getString("email"));
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar el usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * Inserta un nuevo registro en la tabla {@code usuario}.
     *
     * <p>El objeto {@link Usuario} proporcionado debe contener los valores de
     * {@code nombre}, {@code primerApellido}, {@code segundoApellido}, {@code telefono} y {@code email}.
     * El campo {@code id} normalmente es autoincremental y lo gestiona la base de datos.</p>
     *
     * @param usuario objeto de tipo {@link Usuario} con los datos a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} en caso contrario.
     */
    @Override
    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre, primerApellido, segundoApellido, telefono, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prepStet = conexion.prepareStatement(sql)) {

            prepStet.setString(1, usuario.getNombre());
            prepStet.setString(2, usuario.getPrimerApellido());
            prepStet.setString(3, usuario.getSegundoApellido());
            prepStet.setString(4, usuario.getTelefono());
            prepStet.setString(5, usuario.getEmail());

            int filasInsertadas = prepStet.executeUpdate();
            return filasInsertadas > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * Modifica los datos de un usuario existente en la tabla {@code usuario}.
     *
     * <p>Se actualizan los campos {@code nombre}, {@code primerApellido},
     * {@code segundoApellido}, {@code telefono} y {@code email}, identificando
     * el registro por su {@code id}.</p>
     *
     * @param usuario objeto de tipo {@link Usuario} con los nuevos datos y un {@code id} válido.
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     */
    @Override
    public boolean modificarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre=?, primerApellido=?, segundoApellido=?, telefono=?, email=? WHERE id=?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prepStet = conexion.prepareStatement(sql)) {

            prepStet.setString(1, usuario.getNombre());
            prepStet.setString(2, usuario.getPrimerApellido());
            prepStet.setString(3, usuario.getSegundoApellido());
            prepStet.setString(4, usuario.getTelefono());
            prepStet.setString(5, usuario.getEmail());
            prepStet.setInt(6, usuario.getId());

            int filas = prepStet.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al modificar usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * Elimina un registro de la tabla {@code usuario} a partir de su {@code id}.
     *
     * @param usuario objeto de tipo {@link Usuario} que contiene el {@code id} del registro a eliminar.
     * @return {@code true} si se eliminó correctamente, {@code false} si no existía o hubo un error.
     */
    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prepStet = conexion.prepareStatement(sql)) {

            prepStet.setInt(1, usuario.getId());
            int filas = prepStet.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
        return false;
    }
}
