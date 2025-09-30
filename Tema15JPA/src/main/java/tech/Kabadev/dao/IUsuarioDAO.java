package tech.Kabadev.model;

import java.util.List;

public interface IUsuario {
    List <Usuario> listarUsuarios ();
    boolean buscarUsuarioId(Usuario usuario);
    boolean agregarUsuario(Usuario usuario);
    boolean modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
}
