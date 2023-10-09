package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.EpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class EpsService implements EpsIn{
    @Autowired
    EpsRepository epsRepository;
}
