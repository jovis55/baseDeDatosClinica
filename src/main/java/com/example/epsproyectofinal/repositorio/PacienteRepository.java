package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
