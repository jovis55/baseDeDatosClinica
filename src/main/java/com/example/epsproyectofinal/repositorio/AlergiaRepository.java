package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {
    
}
