package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.EspecialidadService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
@CrossOrigin(origins = "http://localhost:4200")

public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;


    @PostMapping("/crear")
    public Especialidad crearEspecialidad(@RequestBody Especialidad especialidad) throws AttributeException {
        return especialidadService.crearEspecialidad(especialidad);
    }

    @PutMapping("/actualizar")
    public Especialidad actualizarEspecialidad(@RequestBody Especialidad especialidad) throws AttributeException{
        return especialidadService.actualizarEspecialidad(especialidad);
    }

    @DeleteMapping("/{especialidadId}")
    public void eliminarEspecialidad(@PathVariable Integer especialidadId) throws AttributeException {
        especialidadService.eliminarEspecialidad(especialidadId);
    }

    @GetMapping("/{especialidadId}")
    public Especialidad obtenerEspecialidadPorId(@PathVariable Integer especialidadId) throws AttributeException{
        return especialidadService.obtenerEspecialidadPorId(especialidadId);
    }

    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidades() throws AttributeException {
        System.out.println("errorlistando esp");
        return especialidadService.listarEspecialidades();
    }
}
