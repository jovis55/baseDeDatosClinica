package com.example.epsproyectofinal;

import com.example.epsproyectofinal.entidad.Paciente;
import com.example.epsproyectofinal.repositorio.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class EpsProyectoFinalApplicationTests {

    PacienteRepository pacienteRepository;

    @Test
    @Sql("classpath:dataSet.sql")
    public void obtenerPorNombre(){
        Paciente paciente= pacienteRepository.findByNombre("Juan");
        System.out.println(paciente);
    }

    @Test
    @Sql("classpath:dataSet:sql")
    public void obtenerPorIdUsuario(){
        Paciente paciente = pacienteRepository.findByUsuarioId("1234");
        System.out.println(paciente);
    }
}
