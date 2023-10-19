package com.example.epsproyectofinal;
import com.example.epsproyectofinal.entidad.Especialidad;
import com.example.epsproyectofinal.entidad.Medicamento;
import com.example.epsproyectofinal.servicio.EspecialidadIn;
import com.example.epsproyectofinal.servicio.MedicamentoIn;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//evitar crear campos nuevos para una entidad
@SpringBootTest
class EspecialidadTest {

    @Autowired
    private EspecialidadIn especialidadService;

    @Test
    public void obtenerEspecialidades() throws AttributeException {
        List<Especialidad> especialidadesEncontradas = especialidadService.listarEspecialidades();
        assertEquals(5, especialidadesEncontradas.size());
    }
}