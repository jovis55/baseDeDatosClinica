package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.PQRS;

import java.util.List;

public interface PQRSIn {

    PQRS crearPQRS(PQRS pqrs) throws Exception;

    PQRS modificarPQRS(PQRS pqrs) throws Exception;

    void eliminarPQRS(PQRS pqrs) throws Exception;

    List<PQRS> listarPQRS();
}
