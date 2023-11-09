package com.example.epsproyectofinal.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

public class Cita implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCita", length = 10, nullable = false)
    private int idCita;

    @Column(name="motivoCita", length = 400, nullable = false)
    private String motivoCita;

    @Column(name="consultorio", length = 100, nullable = false)
    private String consultorio;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @ManyToOne
    private Especialidad especialidad;

    @Column(name="fechaCreacion", nullable = true)
    private LocalDateTime fechaCreacion;

    @Column(name="fechaCita", nullable = true)
    private LocalDateTime fechaCita;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrsList ;



    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;



}