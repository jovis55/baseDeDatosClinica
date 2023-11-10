package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.entidad.Cita;
import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.entidad.Paciente;
import com.example.epsproyectofinal.servicio.*;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{idCita}")
    public ResponseEntity<String> eliminarCita(@PathVariable int idCita) {
        try {
            citaService.eliminarCita(idCita);
            return ResponseEntity.ok("Cita eliminada correctamente.");
        } catch (AttributeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCita(@RequestBody Cita cita) {
        try {
            Paciente paciente = this.pacienteService.obtenerPacienteporId(cita.getPaciente().getIdUsuario());

            // Verificar si el paciente ya tiene 3 citas
            if (paciente.getCitaList() != null && paciente.getCitaList().size() >= 3) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El paciente ya tiene 3 citas y no puede agendar más.");
            }

            // Continuar con la creación de la cita
            Cita nuevaCita = citaService.crearCita(cita);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
        } catch (AttributeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la cita.");
        }
    }




}

