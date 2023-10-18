package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

@Service
public interface AccionesIn {
    Acciones crearAccion(Acciones accion) throws AttributeException;
    Acciones actualizarAccion(Acciones accion) throws AttributeException;
    Acciones obtenerAccionPorId(int accionId) throws AttributeException;
    void eliminarAccion(int accionId) throws AttributeException;

    boolean existeAccion(int idAccion);
}
