package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Alergia;
import com.example.epsproyectofinal.repositorio.AlergiaRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AlergiaService implements AlergiaIn{


   private final AlergiaRepository alergiaRepository;
    @Autowired
   public AlergiaService(AlergiaRepository alergiaRepository){
       this.alergiaRepository= alergiaRepository;
   }

    @Override
    public Alergia crearAlergia(Alergia alergia) throws AttributeException {
        try {
            return alergiaRepository.save(alergia);
        } catch (Exception e) {
            throw new AttributeException("No se pudo crear la alergia");
        }
    }

    @Override
    public Alergia actualizarAlergia(Alergia alergia) throws AttributeException {
        try {
            return alergiaRepository.save(alergia);
        } catch (Exception e) {
            throw new AttributeException("No se pudo actualizar la alergia");
        }
    }

    @Override
    public void eliminarAlergia(Integer alergiaId) throws AttributeException {
        try {
            alergiaRepository.deleteById(alergiaId);
        } catch (Exception e) {
            throw new AttributeException("No se pudo eliminar la alergia");
        }
    }

    @Override
    public Alergia obtenerAlergiaPorId(Integer alergiaId) throws AttributeException {
        Optional<Alergia> alergiaOptional = alergiaRepository.findById(alergiaId);
        if (alergiaOptional.isPresent()) {
            return alergiaOptional.get();
        } else {
            throw new AttributeException("Alergia no encontrada");
        }
    }

    @Override
    public List<Alergia> listarAlergias() throws AttributeException {
        try {
            return alergiaRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las alergias");
        }
    }
}
