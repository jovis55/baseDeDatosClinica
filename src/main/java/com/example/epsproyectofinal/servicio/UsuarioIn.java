package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioIn {

    Optional<Usuario> buscarUsuarioId(String idUsuario) throws Exception;

    Usuario modificarUsuario(Usuario usuario) throws Exception;

    void eliminarUsuario(Usuario usuario) throws Exception;

    List<Usuario> listarUsuarios();
}
