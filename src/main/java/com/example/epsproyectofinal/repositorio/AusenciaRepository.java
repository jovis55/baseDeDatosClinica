package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Ausencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AusenciaRepository extends JpaRepository<Ausencia, Integer> {
    Ausencia findByMedicoIdUsuario(String medicoIdUsuario);
}
