package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.MedicamentoService;
import com.example.epsproyectofinal.servicio.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")

public class MedicoController {
    @Autowired
    MedicoService medicoService;
}
