package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Ciudad;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface CiudadIn {

    Ciudad crearCiudad (Ciudad ciudad) throws AttributeException;
    Ciudad actualizarCiudad (Ciudad ciudad) throws AttributeException;
    Ciudad obtenerCiudad (int idCiudad) throws AttributeException;
    List<Ciudad> listarCiudad () throws AttributeException;
    void eliminarCiudad (int idCiudad) throws AttributeException;
    boolean existeCiudad (int idCiudad);

}
