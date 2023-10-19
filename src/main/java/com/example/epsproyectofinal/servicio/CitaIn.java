package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Cita;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CitaIn {

    Cita crearCita (Cita cita) throws AttributeException;
    Cita actualizarCita (Cita cita) throws AttributeException;
    Cita obtenerCita (int idCita) throws AttributeException;
    List<Cita> listarCitas() throws AttributeException;
    void eliminarCita (int idCita) throws AttributeException;
    boolean existeCita (int idCita);

}
