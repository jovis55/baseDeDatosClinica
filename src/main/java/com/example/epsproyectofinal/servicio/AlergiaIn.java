package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Alergia;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface AlergiaIn {
    Alergia crearAlergia(Alergia alergia)  throws AttributeException;
    Alergia actualizarAlergia(Alergia alergia) throws AttributeException;
    void eliminarAlergia(Integer alergiaId) throws AttributeException;
    Alergia obtenerAlergiaPorId(Integer alergiaId) throws AttributeException;
    List<Alergia> listarAlergias() throws AttributeException;

}
