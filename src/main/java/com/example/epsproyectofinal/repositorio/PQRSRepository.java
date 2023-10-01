package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PQRSRepository extends JpaRepository<PQRS, Integer> {

}
