package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Consulta;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.ConsultaService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "http://localhost:4200")

public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/crear")
    public ResponseEntity<Consulta> crearConsulta(@RequestBody Consulta consulta) {
        try {
            Consulta nuevaConsulta = consultaService.crearConsulta(consulta);
            return new ResponseEntity<>(nuevaConsulta, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idConsulta}")
    public ResponseEntity<Consulta> obtenerConsulta(@PathVariable int idConsulta) {
        try {
            Consulta consulta = consultaService.obtenerConsulta(idConsulta);
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Consulta>> listarConsultas() {
        try {
            List<Consulta> consultas = consultaService.listarConsultas();
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

