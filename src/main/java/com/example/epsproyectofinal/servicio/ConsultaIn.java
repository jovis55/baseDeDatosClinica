package com.example.epsproyectofinal.servicio;

@Service
public interface ConsultaIn {

    Consulta crearConsulta (Consulta consulta) throws AttributeException;
    Consulta actualizarConsulta (Consulta consulta) throws AttributeException;
    Consulta obtenerConsulta (int idConsulta) throws AttributeException;
    List<Consulta> listarConsultas () throws AttributeException;
    void eliminarConsultas (int idConsulta) throws AttributeException;
    boolean existeConsulta (int idConsulta);

}
