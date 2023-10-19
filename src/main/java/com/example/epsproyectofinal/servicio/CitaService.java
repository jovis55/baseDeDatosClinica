package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Cita;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.CitaRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CitaService implements CitaIn {

    private CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita crearCita(Cita cita) throws AttributeException {
        return citaRepository.save(cita);
    }

    @Override
    public Cita actualizarCita(Cita cita) throws AttributeException {
        Optional<Cita> citaOptional = citaRepository.findById(cita.getIdCita());
        if (citaOptional.isPresent()) {
            return citaRepository.save(cita);
        } else {
            throw new AttributeException("Cita no encontrada en la base de datos.");
        }
    }

    @Override
    public Cita obtenerCita (int idCita) throws AttributeException {
        Optional<Cita> citaOptional = citaRepository.findById(idCita);
        if (citaOptional.isPresent()) {
            return citaOptional.get();
        } else {
            throw new AttributeException("Cita no encontrada en la base de datos.");
        }
    }

    @Override
    public void eliminarCita (int idCita) throws AttributeException {
        if (existeCita(idCita)) {
            citaRepository.deleteById(idCita);
        } else {
            throw new AttributeException("Cita no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeCita (int idCita) {
        return citaRepository.existsById(idCita);
    }

    @Override
    public List<Cita> listarCitas() throws AttributeException {
        try {
            return citaRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las citas.");
        }
    }
}

