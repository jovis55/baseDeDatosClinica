package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Administrador;
import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface MedicoIn {
    Medico crearMedico(Medico medico) throws AttributeException;
    Medico actualizarMedico(Medico medico) throws AttributeException;
    Medico obtenerMedicoPorId(String medicoId) throws AttributeException;
    List<Medico> listarMedicos();
    void eliminarMedicos(String medicoId) throws AttributeException;
    boolean existemedico(String medicoId);
    List<Medico> obtenerMedicoByEspecialidad(String especialidad);
}
