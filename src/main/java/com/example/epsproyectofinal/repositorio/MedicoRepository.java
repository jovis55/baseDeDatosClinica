package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, String> {
    @Query("SELECT m FROM Medico m JOIN m.especialidades e WHERE e.nombre = :nombreEspecialidad")
    List<Medico> findByEspecialidadesNombre(@Param("nombreEspecialidad") String nombreEspecialidad);

}
