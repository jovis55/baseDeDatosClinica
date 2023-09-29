package com.example.epsproyectofinal.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Acciones implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idAccion", length = 10, nullable = false)
    private int idAccion;

    @Column(name = "mensajeUsuario", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "mensajeAdministrador", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    private PQRS pqrs;
}