package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Disponibilidad;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

public interface DisponibilidadIn {

    Disponibilidad crearDisponibilidad (Disponibilidad disponibilidad) throws AttributeException;
    Disponibilidad actualizarDisponibilidad (Disponibilidad disponibilidad) throws AttributeException;
    Disponibilidad obtenerDisponibilidad (int idDisponibilidad) throws AttributeException;
    void eliminarDisponibilidad (int idDisponibilidad) throws AttributeException;
    boolean existeDisponibilidad (int idDisponibilidad);


}
