package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Usuario;

import java.util.List;

public interface UsuarioIn {

    Usuario crearUsuario(Usuario usuario) throws Exception;

    Usuario modificarUsuario(Usuario usuario) throws Exception;

    void eliminarUsuario(Usuario usuario) throws Exception;

    List<Usuario> listarUsuarios();
}
