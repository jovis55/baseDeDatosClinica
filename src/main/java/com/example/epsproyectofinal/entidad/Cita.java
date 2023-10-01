package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Cita extends Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idCita", length = 10, nullable = false)
    private int idCita;

    @Column(name="motivoCita", length = 100, nullable = false)
    private String motivoCita;

    @Column(name="consultorio", length = 100, nullable = false)
    private String consultorio;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @Column(name="fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name="fechaCita", nullable = false)
    private LocalDateTime fechaCita;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrsList ;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;



}