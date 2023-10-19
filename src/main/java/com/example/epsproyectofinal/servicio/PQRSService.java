package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.PQRS;
import com.example.epsproyectofinal.repositorio.PQRSRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class PQRSService implements PQRSIn {
    @Autowired
    PQRSRepository pqrsRepository;

    @Override
    public PQRS crearPQRS(PQRS pqrs) throws Exception {
        try{
            return pqrsRepository.save(pqrs);
        }
        catch (Exception e){
            throw new AttributeException("No se ha podido registrar el PQRS en la base de datos");
        }
    }

    @Override
    public PQRS modificarPQRS(PQRS pqrs) throws Exception {
        if(pqrsRepository.findById(pqrs.getIdPQRS()).isPresent()){
            return pqrsRepository.save(pqrs);
        }
        else{
            throw new AttributeException("No se ha encontrado el PQRS en la base de datos");
        }
    }

    @Override
    public void eliminarPQRS(PQRS pqrs) throws Exception {
        if(pqrsRepository.findById(pqrs.getIdPQRS()).isPresent()){
            pqrsRepository.deleteById(pqrs.getIdPQRS());
        }
        else{
            throw new AttributeException("No se ha encontrado el PQRS en la base de datos");
        }

    }

    @Override
    public List<PQRS> listarPQRS() {
        return pqrsRepository.findAll();
    }
}
