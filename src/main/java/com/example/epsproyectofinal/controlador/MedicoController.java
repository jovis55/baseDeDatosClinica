package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.entidad.Paciente;
import com.example.epsproyectofinal.servicio.AccionesService;
import com.example.epsproyectofinal.servicio.MedicamentoService;
import com.example.epsproyectofinal.servicio.MedicoService;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "http://localhost:4200")


public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping(path = "/{idUsuario}")
    public Medico obtenerPorId(@PathVariable String idUsuario) throws Exception {
        Optional<Medico> clienteOptional = Optional.ofNullable(medicoService.obtenerMedicoPorId(idUsuario));

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new AttributeException("Nose pudo encontrar el medico");
        }
    }
    @GetMapping("/listar")
    public List<Medico> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @DeleteMapping("/{medicoId}")
    public void eliminarMedicos(@PathVariable String medicoId) throws AttributeException {
        medicoService.eliminarMedicos(medicoId);
    }

    @GetMapping("/existemedico/{medicoId}")
    public boolean existemedico(@PathVariable String medicoId) {
        return medicoService.existemedico(medicoId);
    }

    @GetMapping("/byEspecialidad/{especialidad}")
    public List<Medico> obtenerMedicoByEspecialidad(@PathVariable String especialidad) {
        return medicoService.obtenerMedicoByEspecialidad(especialidad);
    }
    @GetMapping("/espe/{idEspecialidad}")
    public List<Medico> obtenerMedicoByEspecialidadId(@PathVariable int idEspecialidad) {
        List <Medico> medicoList = medicoService.obtenerMedicoByEspecialidadId(idEspecialidad);

        return medicoList;
    }
}
