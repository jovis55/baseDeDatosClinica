package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query
    Paciente findByNombre(String nombre);

}
