package com.example.epsproyectofinal.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disponibilidad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idDisponibilidad", length = 10, nullable = false)
    private int idDisponibilidad;

    @Column(name="fecha", nullable = false)
    private Date fecha;

    @Column(name="hora", length = 100, nullable = false)
    private String hora;


    @ManyToOne
    private Medico medico;

}