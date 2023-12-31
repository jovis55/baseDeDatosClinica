package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCiudad", length = 10, nullable = false)
    private int idCiudad;

    @Column(name="nombre", length = 40, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Medico> medicoList;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.EAGER)
    private List<Paciente> pacienteList ;


}