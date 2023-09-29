package com.example.epsproyectofinal.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Administrador extends Usuario implements Serializable {
    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "administrador")
    private List<PQRS> pqrsList ;

}