package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Administrador;
import com.example.epsproyectofinal.repositorio.AdministradorRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AdministradorService implements AdministradorIn {

    private AdministradorRepository administradorRepository;

    @Autowired
   public AdministradorService(AdministradorRepository administradorRepository){
        this.administradorRepository= administradorRepository;
    }

    @Override
    public Administrador crearAdministrador(Administrador administrador) throws AttributeException {
        // Verifica si ya existe un administrador con el mismo nombre de usuario
        Administrador administradorExistente = administradorRepository.findByNombreUsuario(administrador.getNombre());

        if (administradorExistente != null) {
            throw new AttributeException("Ya existe un administrador con este nombre de usuario.") {
            };
        }

        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(Administrador administrador) throws AttributeException {
        Optional<Administrador> administradorExistente = administradorRepository.findById(administrador.getIdUsuario());
        if (administradorExistente.isPresent()) {
            return administradorRepository.save(administrador);
        } else {
            throw new AttributeException("Administrador no encontrado en la base de datos.");
        }
    }

    @Override
    public Administrador obtenerAdministradorPorId(String administradorId) throws AttributeException {
        Optional<Administrador> administradorOptional = administradorRepository.findById(administradorId);
        if (administradorOptional.isPresent()) {
            return administradorOptional.get();
        } else {
            throw new AttributeException("Administrador no encontrado en la base de datos.");
        }
    }

    @Override
    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public void eliminarAdministrador(String administradorId) throws AttributeException {
        if (existeAdministrador(administradorId)) {
            administradorRepository.deleteById(administradorId);
        } else {
            throw new AttributeException("Administrador no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existeAdministrador(String administradorId) {
        return administradorRepository.existsById(administradorId);
    }
}
