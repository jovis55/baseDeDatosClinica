package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Usuario;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/{idUsuario}")
    public Optional<Usuario> obtenerPorId(@PathVariable String idUsuario){
        Optional<Usuario> usuario = usuarioService.buscarUsuarioId(idUsuario);

        if (usuario.isPresent()) {
            return usuario;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario con ID " + idUsuario + " no encontrado");
        }
    }


}
