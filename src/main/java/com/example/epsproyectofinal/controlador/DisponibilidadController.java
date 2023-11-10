package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Disponibilidad;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.DisponibilidadService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disponibilidad")
@CrossOrigin(origins = "http://localhost:4200")

public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;


    @GetMapping("/{idDisponibilidad}")
    public ResponseEntity<Disponibilidad> obtenerDisponibilidad(@PathVariable int idDisponibilidad) {
        try {
            Disponibilidad disponibilidad = disponibilidadService.obtenerDisponibilidad(idDisponibilidad);
            return new ResponseEntity<>(disponibilidad, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
