package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Consulta;
import com.example.epsproyectofinal.repositorio.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;


import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ConsultaService implements ConsultaIn {

    private ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta crearConsulta (Consulta consulta) throws AttributeException {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta actualizarConsulta (Consulta consulta) throws AttributeException {
        Optional<Consulta> consultaOptional = consultaRepository.findById(consulta.getIdConsulta());
        if (consultaOptional.isPresent()) {
            return consultaRepository.save(consulta);
        } else {
            throw new AttributeException("Consulta no encontrada en la base de datos.");
        }
    }

    @Override
    public Consulta obtenerConsulta (int idConsulta) throws AttributeException {
        Optional<Consulta> consultaOptional = consultaRepository.findById(idConsulta);
        if (consultaOptional.isPresent()) {
            return consultaOptional.get();
        } else {
            throw new AttributeException("Consulta no encontrada en la base de datos.");
        }
    }

    @Override
    public void eliminarConsultas (int idConsulta) throws AttributeException {
        if (existeConsulta (idConsulta)) {
            consultaRepository.deleteById(idConsulta);
        } else {
            throw new AttributeException("Consulta no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeConsulta (int idConsulta) {
        return consultaRepository.existsById(idConsulta);
    }

    @Override
    public List<Consulta> listarConsultas() throws AttributeException {
        try {
            return consultaRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las consultas.");
        }
    }
}