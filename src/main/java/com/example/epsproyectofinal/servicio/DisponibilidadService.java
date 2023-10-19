package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Disponibilidad;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.DisponibilidadRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional

public class DisponibilidadService implements DisponibilidadIn{

    private DisponibilidadRepository disponibilidadRepository;

    @Autowired
    public DisponibilidadService(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }

    @Override
    public Disponibilidad crearDisponibilidad (Disponibilidad disponibilidad) throws AttributeException {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    public Disponibilidad actualizarDisponibilidad (Disponibilidad disponibilidad) throws AttributeException {
        Optional<Disponibilidad> disponibilidadOptional = disponibilidadRepository.findById(disponibilidad.getIdDisponibilidad());
        if (disponibilidadOptional.isPresent()) {
            return disponibilidadRepository.save(disponibilidad);
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }

    @Override
    public Disponibilidad obtenerDisponibilidad (int idDisponibilidad) throws AttributeException {
        Optional<Disponibilidad> disponibilidadOptional = disponibilidadRepository.findById(idDisponibilidad);
        if (disponibilidadOptional.isPresent()) {
            return disponibilidadOptional.get();
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }


    @Override
    public void eliminarDisponibilidad (int idDisponibilidad) throws AttributeException {
        if (existeDisponibilidad (idDisponibilidad)) {
            disponibilidadRepository.deleteById(idDisponibilidad);
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeDisponibilidad (int idDisponibilidad) {
        return disponibilidadRepository.existsById(idDisponibilidad);
    }
}