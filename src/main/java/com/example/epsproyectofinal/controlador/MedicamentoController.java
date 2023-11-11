package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Medicamento;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.MedicamentoService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
@CrossOrigin(origins = "http://localhost:4200")

public class MedicamentoController {
    @Autowired
    MedicamentoService medicamentoService;

    @GetMapping("/listar")
    public List<Medicamento> listarMedicamentos() {
        try {
            return medicamentoService.listarMedicamento();
        } catch (AttributeException e) {
            // Manejo de excepciones, puedes retornar un ResponseEntity con un mensaje de error
            e.printStackTrace();
            return null; // Otra forma de manejar el error según tus necesidades
        }
    }
}
