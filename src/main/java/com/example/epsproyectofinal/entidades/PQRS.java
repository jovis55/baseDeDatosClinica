package com.example.epsproyectofinal.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQRS implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idPQRS", length = 10, nullable = false)
    private int idPQRS;

    @Column(name="fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name="descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    private Cita cita;

    @ManyToOne
    private Administrador administrador;

    @OneToMany(mappedBy = "pqrs")
    private List<Acciones> accionesList ;

}