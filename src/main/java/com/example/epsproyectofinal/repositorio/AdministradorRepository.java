package com.example.epsproyectofinal.repositorio;

import com.example.epsproyectofinal.entidad.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
    Administrador findByNombre(String nombreUsuario);
}
