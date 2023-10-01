package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    
}
