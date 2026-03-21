package org.kabalera82.dao;

import org.kabalera82.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List <Usuario> listarUsuarios ();
    boolean buscarUsuarioId(Usuario usuario);
    boolean agregarUsuario(Usuario usuario);
    boolean modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
}
