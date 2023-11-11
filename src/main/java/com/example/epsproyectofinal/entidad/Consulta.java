package com.example.epsproyectofinal.entidad;

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
public class Consulta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idConsulta", length = 10, nullable = false)
    private int idConsulta;

    @Column(name="sintomas", length = 100, nullable = false)
    private String sintomas;

    @Column(name="diagnostico", length = 100, nullable = false)
    private String diagnostico;

    @Column(name="tratamiento", length = 100, nullable = false)
    private String tratamiento;

    @Column(name="medicamentosOpcional", length = 100, nullable = true)
    private String medicamentosOpcional;

    @ManyToMany(mappedBy = "consultaList")
    private List<Medicamento> medicamentoList;

    @OneToOne
    @JoinColumn(name = "idCita")
    @JsonManagedReference // Evita la recursión infinita
    private Cita cita;





}