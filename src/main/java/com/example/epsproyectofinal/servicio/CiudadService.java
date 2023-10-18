package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class CiudadService implements CiudadIn {

    private CiudadRepository ciudadRepository;

    @Autowired
    public ciudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Ciudad crearCiudad (Ciudad ciudad) throws AttributeException {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad (Ciudad ciudad) throws AttributeException {
        Optional<Ciudad> ciudadOptional = ciudadRepository.findById(ciudad.getIdCiudad());
        if (ciudadOptional.isPresent()) {
            return ciudadRepository.save(ciudad);
        } else {
            throw new AttributeException("Ciudad no encontrada en la base de datos.");
        }
    }

    @Override
    public Ciudad obtenerCiudad (int idCiudad) throws AttributeException {
        Optional<Ciudad> ciudadOptional = ciudadRepository.findById(idCiudad);
        if (ciudadOptional.isPresent()) {
            return ciudadOptional.get();
        } else {
            throw new AttributeException("Ciudad no encontrada en la base de datos.");
        }
    }

    @Override
    public void eliminarCiudad (int idCiudad) throws AttributeException {
        if (existeCiudad(idCiudad)) {
            ciudadRepository.deleteById(idCiudad);
        } else {
            throw new AttributeException("Ciudad no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeCiudad (int idCiudad) {
        return ciudadRepository.existsById(idCiudad);
    }

    @Override
    public List<Ciudad> listarCiudad () throws AttributeException {
        try {
            return ciudadRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las ciudades.");
        }
    }
}