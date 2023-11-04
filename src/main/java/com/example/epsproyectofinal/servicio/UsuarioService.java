package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Usuario;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.UsuarioRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class UsuarioService implements UsuarioIn {
    @Autowired
    UsuarioRepository usuarioRepository;



    @Override
    public Optional<Usuario> buscarUsuarioId(String idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }



    @Override
    public Usuario modificarUsuario(Usuario usuario) throws Exception {
        if(usuarioRepository.findById(usuario.getIdUsuario()).isPresent()){
            return usuarioRepository.save(usuario);
        }
        else{
            throw new AttributeException("El usuario no se encuentra en la case de datos");
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws Exception {
        if(usuarioRepository.findById(usuario.getIdUsuario()).isPresent()){
            usuarioRepository.deleteById(usuario.getIdUsuario());
        }
        else{
            throw new AttributeException("El usuario no se encuentra en la case de datos");
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
