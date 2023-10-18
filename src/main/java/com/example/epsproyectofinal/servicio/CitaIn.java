package com.example.epsproyectofinal.servicio;

@Service
public interface CitaIn {

    Cita crearCita (Cita cita) throws AttributeException;
    Cita actualizarCita (Cita cita) throws AttributeException;
    Cita obtenerCita (int idCita) throws AttributeException;
    List<Cita> listarCitas() throws AttributeException;
    void eliminarCita (int idCita) throws AttributeException;
    boolean existeCita (int idCita);

}
