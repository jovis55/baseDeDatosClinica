package com.example.epsproyectofinal.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Consulta implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idConsulta", length = 10, nullable = false)
    private int idConsulta;

    @Column(name="sintomas", length = 100, nullable = false)
    private String sintomas;

    @Column(name="diagnostico", length = 100, nullable = false)
    private String diagnostico;

    @Column(name="tratamiento", length = 100, nullable = false)
    private String tratamiento;

    @ManyToMany(mappedBy = "consultaList")
    private List<Medicamento> medicamentoList;




}