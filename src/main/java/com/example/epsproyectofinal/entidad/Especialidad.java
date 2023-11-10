package com.example.epsproyectofinal.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Especialidad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEspecialidad", length = 10, nullable = false)
    private int idEspecialidad;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicoList;




}