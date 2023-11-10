package com.example.epsproyectofinal.entidad;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
public class Paciente extends Usuario implements Serializable {


    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name="fechaNacimiento", nullable = true)
    private Date fechaNacimiento;


    @ManyToOne(fetch = FetchType.EAGER)
    private EPS eps;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaList ;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoSangre", length = 10, nullable = false)
    private TipoSangre tipoSangre;


    @Column(name = "imagen_url", length = 200, nullable = true)
    private String imagenUrl;


    @ManyToMany(fetch =  FetchType.EAGER)
    private List<Alergia> alergiaList;

}