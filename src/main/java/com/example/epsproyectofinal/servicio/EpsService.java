package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.repositorio.EpsRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class EpsService implements EpsIn{
    @Autowired
    EpsRepository epsRepository;

    public EpsService(EpsRepository epsRepository) {
        this.epsRepository = epsRepository;
    }

    @Override
    public EPS crearEPS (EPS EPS)throws AttributeException {
        try {
            return epsRepository.save(EPS);
        } catch (Exception e) {
            throw new AttributeException("No se pudo crear la EPS");
        }
    }

    @Override
    public EPS actualizarEPS(EPS EPS) throws AttributeException {
        try {
            return epsRepository.save(EPS);
        } catch (Exception e) {
            throw new AttributeException("No se pudo actualizar la EPS");
        }
    }

    @Override
    public void eliminarEPS(Integer EPSId) throws AttributeException {
        try {
            epsRepository.deleteById(EPSId);
        } catch (Exception e) {
            throw new AttributeException("No se pudo eliminar la EPS");
        }
    }

    @Override
    public EPS obtenerEPSPorId(Integer EPSId) throws AttributeException {
        Optional<EPS> EPSOptional = epsRepository.findById(EPSId);
        if (EPSOptional.isPresent()) {
            return EPSOptional.get();
        } else {
            throw new AttributeException("EPS no encontrada");
        }
    }

    @Override
    public List<EPS> listarEPS() throws AttributeException {
        try {
            return epsRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las EPS");
        }
    }


}
