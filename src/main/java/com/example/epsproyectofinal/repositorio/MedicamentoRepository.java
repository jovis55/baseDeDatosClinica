package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

}
