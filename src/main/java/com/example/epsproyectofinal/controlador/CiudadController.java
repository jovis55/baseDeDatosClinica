package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Ciudad;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.CiudadService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "http://localhost:4200")

public class CiudadController {
    @Autowired
    CiudadService ciudadService;

        @GetMapping("/listar")
        public List<Ciudad> listarCiudades() throws Exception{
            try {
                return ciudadService.listarCiudad();
            } catch (Exception e) {
                throw new AttributeException("no hay ciudades");

            }
        }
    }


