package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface EpsIn {
    EPS crearEPS(EPS EPS)  throws AttributeException;
    EPS actualizarEPS(EPS EPS) throws AttributeException;
    void eliminarEPS(Integer EPSId) throws AttributeException;
    EPS obtenerEPSPorId(Integer EPSId) throws AttributeException;
    List<EPS> listarEPS() throws AttributeException;
}
