package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Ausencia;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.AusenciaRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AusenciaService implements AusenciaIn {

    private AusenciaRepository ausenciaRepository;

    @Autowired
    public AusenciaService(AusenciaRepository ausenciaRepository){
        this.ausenciaRepository= ausenciaRepository;
    }

    @Override
    public Ausencia crearAusencia(Ausencia ausencia) {
        return ausenciaRepository.save(ausencia);
    }

    @Override
    public Ausencia actualizarAusencia(Ausencia ausencia) throws AttributeException {
        Optional<Ausencia> ausenciaExistente = ausenciaRepository.findById(ausencia.getIdAusencia());
        if (ausenciaExistente.isPresent()) {
            return ausenciaRepository.save(ausencia);
        } else {
            throw new AttributeException("Ausencia no encontrada en la base de datos.");
        }
    }

    @Override
    public Ausencia obtenerAusenciaPorId(int ausenciaId) throws AttributeException {
        Optional<Ausencia> ausenciaOptional = ausenciaRepository.findById(ausenciaId);
        if (ausenciaOptional.isPresent()) {
            return ausenciaOptional.get();
        } else {
            throw new AttributeException("Ausencia no encontrada en la base de datos.");
        }
    }

    @Override
    public Ausencia listarAusenciasPorMedico(String medicoId) {
        Ausencia ausencia = ausenciaRepository.findByMedicoIdUsuario(medicoId);
        return ausencia;
    }

    @Override
    public void eliminarAusencia(int ausenciaId) throws AttributeException {
        if (existeAusencia(ausenciaId)) {
            ausenciaRepository.deleteById(ausenciaId);
        } else {
            throw new AttributeException("Ausencia no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeAusencia(int ausenciaId) {
        return ausenciaRepository.existsById(ausenciaId);
    }

}
