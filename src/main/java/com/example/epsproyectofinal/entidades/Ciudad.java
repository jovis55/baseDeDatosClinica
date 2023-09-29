package com.example.epsproyectofinal.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idCiudad", length = 10, nullable = false)
    private int idCiudad;

    @Column(name="nombre", length = 40, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Medico> medicoList;

    @OneToMany(mappedBy = "ciudad")
    private List<Paciente> pacienteList ;


}