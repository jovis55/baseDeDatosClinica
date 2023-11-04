package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Medico extends Usuario implements Serializable {


    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="telefono", length = 20, nullable = false)
    private String telefono;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "medico")
    private List<Ausencia> ausenciaList ;

    @OneToMany(mappedBy = "medico")
    private List<Disponibilidad> disponibilidadList ;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citaList ;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "medico_id", referencedColumnName =  "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id", referencedColumnName = "idEspecialidad")
    )
    private List<Especialidad> especialidades;


    @Column(name = "imagenUrl", length = 200, nullable = true)
    private String imagenUrl;



}