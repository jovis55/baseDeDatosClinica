package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccionesRepository extends JpaRepository<Acciones, Integer> {


    boolean existsById(int idAccion);

}
