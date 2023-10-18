package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface EspecialidadIn {

    Especialidad crearEspecialidad(Especialidad especialidad)  throws AttributeException;
    Especialidad actualizarEspecialidad(Especialidad especialidad) throws AttributeException;
    void eliminarEspecialidad(Integer EspecialidadId) throws AttributeException;
    Especialidad obtenerEspecialidadPorId(Integer EspecialidadId) throws AttributeException;
    List<Especialidad> listarEspecialidades() throws AttributeException;
}

