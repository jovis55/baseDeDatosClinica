package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Cita;
import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.entidad.Paciente;
import com.example.epsproyectofinal.servicio.*;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = "http://localhost:4200")

public class CitaController {
    @Autowired
    CitaService citaService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    EspecialidadService especialidadService;

    @PostMapping("/crear")
    public Cita crearCita(@RequestBody Cita cita) throws AttributeException, Exception {
        System.out.println(cita.getConsultorio());
        System.out.println(cita.getMotivoCita());
        System.out.println(cita.getFechaCita());
        System.out.println(cita.getPaciente().getIdUsuario());
        Cita cita2 = new Cita();
        /**
        //cita2.setFechaCita(cita.getFechaCita());
        cita2.setMotivoCita(cita.getMotivoCita());
        cita2.setEstado(cita.getEstado());
        //cita2.setFechaCreacion(cita.getFechaCreacion());
        cita2.setConsultorio(cita.getConsultorio());

        Paciente  paciente =new Paciente();
        Medico medico = new Medico();
        cita2.setMedico(medico);
        cita2.getMedico().setIdUsuario(cita.getMedico().getIdUsuario());
        Especialidad especialidad = new Especialidad();
        cita2.setEspecialidad(especialidad);
        cita2.getEspecialidad().setIdEspecialidad(cita.getEspecialidad().getIdEspecialidad());

        cita2.setPaciente(paciente);
        cita2.getPaciente().setIdUsuario(cita.getPaciente().getIdUsuario());
         */
        return citaService.crearCita(cita);
    }
}

