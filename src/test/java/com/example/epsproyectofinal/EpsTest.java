package com.example.epsproyectofinal;

import com.example.epsproyectofinal.entidad.EPS;
import com.example.epsproyectofinal.servicio.EpsIn;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//evitar crear campos nuevos para una entidad
@SpringBootTest
class EpsTest {

    @Autowired
    private EpsIn epsService;

    @Test
    public void obtenerEps() throws AttributeException {
        List<EPS> EpsEncontradas = epsService.listarEPS();
        assertEquals(3, EpsEncontradas.size());
    }
}
