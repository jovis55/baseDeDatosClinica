package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class UsuarioService implements UsuarioIn {
    @Autowired
    UsuarioRepository usuarioRepository;
}
