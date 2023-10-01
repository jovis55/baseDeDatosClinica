package com.example.epsproyectofinal.entidad;

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

public class Paciente extends Usuario implements Serializable {
    @Column(name="imageByte", length = 500, nullable = false)
    private byte[] imageByte;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name="fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @ManyToOne
    private EPS eps;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaList ;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "alergia_Paciente",
            joinColumns = @JoinColumn(name = "paciente_id", referencedColumnName =  "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "alergia_id", referencedColumnName = "idAlergia")
    )
    private List<Alergia> alergiaList;
    @MapsId
    @JoinColumn(name = "idUsuario") // Nombre de la columna en Medico que se mapeará al ID de Usuario
    private String idUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoSangre", length = 10, nullable = false)
    private TipoSangre tipoSangre;


}