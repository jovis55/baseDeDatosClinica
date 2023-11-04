package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.EpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eps")
@CrossOrigin(origins = "http://localhost:4200")

public class EpsController {
    private final EpsService epsService;

    @Autowired
    public EpsController(EpsService epsService) {
        this.epsService = epsService;
    }

    @GetMapping("/listar")
    public List<EPS> listarEPS() throws Exception{
        return epsService.listarEPS();
    }
}
