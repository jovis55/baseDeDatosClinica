package com.example.epsproyectofinal.entidad;

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
@ToString
public class Alergia implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAlergia", length = 5, nullable = false)
    private Integer idAlergia;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="descripcion", length = 200, nullable = true)
    private String descripcion;

    @ManyToMany(mappedBy = "alergiaList", fetch =  FetchType.EAGER)
    private List<Paciente> pacienteList;


}