package com.example.epsproyectofinal;


import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.entidad.Medicamento;
import com.example.epsproyectofinal.servicio.EpsIn;
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
class MedicamentoTest {

    @Autowired
    private MedicamentoIn medicamentoService;

    @Test
    public void obtenerMedicamentos() throws AttributeException {
        List<Medicamento> medicamentosEncontrados = medicamentoService.listarMedicamento();
        assertEquals(4, medicamentosEncontrados.size());
    }
}
