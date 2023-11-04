package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Alergia;
import com.example.epsproyectofinal.entidad.Ciudad;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.AlergiaService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alergia")
@CrossOrigin(origins = "http://localhost:4200")

public class AlergiaController {
    @Autowired
    AlergiaService alergiaService;

    @GetMapping("/listar")
    public List<Alergia> listarCiudades() throws Exception{
        try {
            return alergiaService.listarAlergias();
        } catch (Exception e) {
            throw new AttributeException("no hay alergias");

        }
    }
}
