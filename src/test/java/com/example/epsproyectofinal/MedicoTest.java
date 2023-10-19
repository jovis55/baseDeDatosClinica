package com.example.epsproyectofinal;

import com.example.epsproyectofinal.entidad.Medico;
import com.example.epsproyectofinal.repositorio.MedicoRepository;
import com.example.epsproyectofinal.servicio.MedicoIn;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//evitar crear campos nuevos para una entidad
@SpringBootTest
class MedicoTest {

    @Autowired
    private  MedicoIn medicoService;

    @Autowired
    private MedicoRepository medicoRepository;

    @Test
    //@Sql("classpath:dataset.sql")
    public void obtnerByespecialidad() throws AttributeException {
        String especialidadBuscada = "Cardiologia";

        List<Medico> medicosEncontrados = medicoService.obtenerMedicoByEspecialidad(especialidadBuscada);

        assertEquals(2, medicosEncontrados.size());
        assertEquals("Dr. Smith", medicosEncontrados.get(0).getNombre());

    }

    @Test
    //@Sql("classpath:dataset.sql")
    public void listarMedico() throws AttributeException {
        List<Medico> medicosEncontrados = medicoService.listarMedicos();

        assertEquals(2, medicosEncontrados.size());
        assertEquals("Dr. Smith", medicosEncontrados.get(0).getNombre());

    }
}
