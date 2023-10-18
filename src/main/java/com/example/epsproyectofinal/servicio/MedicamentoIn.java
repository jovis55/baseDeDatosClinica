package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Medicamento;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;

import java.util.List;

public interface MedicamentoIn {

    Medicamento crearMedicamento(Medicamento medicamento)  throws AttributeException;
    Medicamento actualizarMedicamento(Medicamento medicamento) throws AttributeException;
    void eliminarMedicamento(Integer medicamentoId) throws AttributeException;
    Medicamento obtenerMedicamentoPorId(Integer medicamentoId) throws AttributeException;
    List<Medicamento> listarMedicamento() throws AttributeException;
}
