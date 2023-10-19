package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Administrador;
import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.MedicoRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoService implements MedicoIn{

    private final MedicoRepository medicoRepository;

    @Override
    public Medico crearMedico(Medico medico) throws AttributeException {
        Optional<Medico> medicoExistente = medicoRepository.findById(medico.getIdUsuario());

        if (medicoExistente != null) {
            throw new AttributeException("Ya existe un administrador con este nombre de usuario.") {
            };
        }

        return medicoRepository.save(medico);
    }

    @Override
    public Medico actualizarMedico(Medico medico) throws AttributeException {
        Optional<Medico> guardado = medicoRepository.findById(medico.getIdUsuario());
        if (guardado.isPresent()) {
            return medicoRepository.save(medico);
        } else {
            throw new AttributeException("Medico no encontrado en la base de datos.");
        }
    }

    @Override
    public Medico obtenerMedicoPorId(String medicoId) throws AttributeException {
        Optional<Medico> medicoOptional = medicoRepository.findById(medicoId);
        if (medicoOptional.isPresent()) {
            return medicoOptional.get();
        } else {
            throw new AttributeException("Medico no encontrado en la base de datos.");
        }
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public void eliminarMedicos(String medicoId) throws AttributeException {
        if (existemedico(medicoId)) {
            medicoRepository.deleteById(medicoId);
        } else {
            throw new AttributeException("Medico no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existemedico(String medicoId) {
        return medicoRepository.existsById(medicoId);
    }

    @Override
    public List<Medico> obtenerMedicoByEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidadesNombre(especialidad);
    }


}
