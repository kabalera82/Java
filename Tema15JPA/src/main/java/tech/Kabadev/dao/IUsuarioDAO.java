package tech.Kabadev.dao;

import tech.Kabadev.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List <Usuario> listarUsuarios ();
    boolean buscarUsuarioId(Usuario usuario);
    boolean agregarUsuario(Usuario usuario);
    boolean modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
}
