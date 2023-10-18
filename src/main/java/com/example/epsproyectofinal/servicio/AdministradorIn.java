package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Administrador;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface AdministradorIn {

    Administrador crearAdministrador(Administrador administrador) throws AttributeException;
    Administrador actualizarAdministrador(Administrador administrador) throws AttributeException;
    Administrador obtenerAdministradorPorId(String administradorId) throws AttributeException;
    List<Administrador> listarAdministradores();
    void eliminarAdministrador(String administradorId) throws AttributeException;
    boolean existeAdministrador(String administradorId);
}
