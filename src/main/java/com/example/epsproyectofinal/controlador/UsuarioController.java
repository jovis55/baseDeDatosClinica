package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
}
