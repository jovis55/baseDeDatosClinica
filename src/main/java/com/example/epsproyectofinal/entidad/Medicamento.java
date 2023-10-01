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
public class Medicamento implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMedicamento", length = 10, nullable = false)
    private int idMedicamento;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "medicamento_consulta",
            joinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName =  "idMedicamento"),
            inverseJoinColumns = @JoinColumn(name = "consulta_id", referencedColumnName = "idConsulta")
    )
    private List<Consulta> consultaList;




}
