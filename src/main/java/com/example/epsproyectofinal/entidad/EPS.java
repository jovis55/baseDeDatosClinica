package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@ToString

public class EPS {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idEPS", length = 10, nullable = false)
    private int idEPS;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy="eps")
    private List<Paciente> pacienteList;
}