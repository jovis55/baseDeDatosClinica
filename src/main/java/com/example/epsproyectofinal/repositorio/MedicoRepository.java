package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Acciones;
import com.example.epsproyectofinal.entidad.Medico;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository


public interface MedicoRepository extends JpaRepository<Medico, String> {
    @Query("SELECT m FROM Medico m JOIN m.especialidades e WHERE e.nombre = :nombreEspecialidad")
    List<Medico> findByEspecialidadesNombre(@Param("nombreEspecialidad") String nombreEspecialidad);


}
