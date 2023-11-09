package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.repositorio.EspecialidadRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class EspecialidadService implements EspecialidadIn {
    @Autowired
    EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) throws AttributeException {
        try {
            return especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new AttributeException("No se pudo crear la especialidad");
        }
    }

    @Override
    public Especialidad actualizarEspecialidad(Especialidad especialidad) throws AttributeException {
        try {
            return especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new AttributeException("No se pudo actualizar la especialidad");
        }
    }

    @Override
    public void eliminarEspecialidad(Integer especialidadId) throws AttributeException {
        try {
            especialidadRepository.deleteById(especialidadId);
        } catch (Exception e) {
            throw new AttributeException("No se pudo eliminar la especialidad");
        }
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(Integer especialidadId) throws AttributeException {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(especialidadId);
        if (especialidadOptional.isPresent()) {
            return especialidadOptional.get();
        } else {
            throw new AttributeException("Especialidad no encontrada");
        }
    }

    @Override
    public List<Especialidad> listarEspecialidades() throws AttributeException {
        try {

            return especialidadRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las especialidades");
        }
    }
}
