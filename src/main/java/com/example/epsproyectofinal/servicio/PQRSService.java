package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.repositorio.AccionesRepository;
import com.example.epsproyectofinal.repositorio.PQRSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class PQRSService implements PQRSIn {
    @Autowired
    PQRSRepository pqrsRepository;
}
