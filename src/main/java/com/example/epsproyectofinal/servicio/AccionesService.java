package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AccionesService implements AccionesIn{

    private AccionesRepository accionesRepository;
    @Autowired
    public  AccionesService(AccionesRepository accionesRepository){
        this.accionesRepository = accionesRepository;
    }

    @Override
    public Acciones crearAccion(Acciones accion) {
        return accionesRepository.save(accion);
    }

    @Override
    public Acciones actualizarAccion(Acciones accion) throws AttributeException {
        Optional<Acciones> accionExistente = accionesRepository.findById(accion.getIdAccion());
        if (accionExistente.isPresent()) {
            return accionesRepository.save(accion);
        } else {
            throw new AttributeException("Accion no encontrada en la base de datos.");
        }
    }

    @Override
    public Acciones obtenerAccionPorId(int accionId) throws AttributeException {
        Optional<Acciones> accionOptional = accionesRepository.findById(accionId);
        if (accionOptional.isPresent()) {
            return accionOptional.get();
        } else {
            throw new AttributeException("Accion no encontrada en la base de datos.");
        }
    }



    @Override
    public void eliminarAccion(int accionId) throws AttributeException {
        if (existeAccion(accionId)) {
            accionesRepository.deleteById(accionId);
        } else {
            throw new AttributeException("Accion no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeAccion(int idAccion) {
        return accionesRepository.existsById(idAccion);
    }
}
