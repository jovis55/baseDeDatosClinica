package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ausencia implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAusencia", length = 10, nullable = false)
    private int idAusencia;

    @Column(name="fechaAusencia", nullable = false)
    private Date fechaAusencia;

    @Column(name="estadoAusencia", length = 10, nullable = false)
    private String estadoAusencia;

    @ManyToOne
    private Medico medico;

}