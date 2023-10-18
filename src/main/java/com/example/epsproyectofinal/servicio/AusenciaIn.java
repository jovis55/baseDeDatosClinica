package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Ausencia;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface AusenciaIn {
    Ausencia crearAusencia(Ausencia ausencia) throws AttributeException;
    Ausencia actualizarAusencia(Ausencia ausencia) throws AttributeException;
    Ausencia obtenerAusenciaPorId(int ausenciaId)throws AttributeException;
    Ausencia listarAusenciasPorMedico(String medicoId) throws AttributeException;
    void eliminarAusencia(int ausenciaId) throws AttributeException;
    boolean existeAusencia(int ausenciaId) throws AttributeException ;
}
