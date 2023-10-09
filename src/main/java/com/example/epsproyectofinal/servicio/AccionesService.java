package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.repositorio.AccionesRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class AccionesService implements AccionesIn{
    @Autowired
    AccionesRepository accionesRepository;
}
