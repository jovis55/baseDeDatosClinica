package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Medicamento;
import com.example.epsproyectofinal.repositorio.MedicamentoRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class MedicamentoService implements MedicamentoIn{
    @Autowired
    MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) throws AttributeException {
        try {
            return medicamentoRepository.save(medicamento);
        } catch (Exception e) {
            throw new AttributeException("No se pudo crear el medicamento");
        }
    }

    @Override
    public Medicamento actualizarMedicamento(Medicamento medicamento) throws AttributeException {
        try {
            return medicamentoRepository.save(medicamento);
        } catch (Exception e) {
            throw new AttributeException("No se pudo actualizar el medicamento");
        }
    }

    @Override
    public void eliminarMedicamento(Integer medicamentoId) throws AttributeException {
        try {
            medicamentoRepository.deleteById(medicamentoId);
        } catch (Exception e) {
            throw new AttributeException("No se pudo eliminar el medicamento");
        }
    }

    @Override
    public Medicamento obtenerMedicamentoPorId(Integer medicamentoId) throws AttributeException {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(medicamentoId);
        if (medicamentoOptional.isPresent()) {
            return medicamentoOptional.get();
        } else {
            throw new AttributeException("Medicamento no encontrada");
        }
    }

    @Override
    public List<Medicamento> listarMedicamento() throws AttributeException {
        try {
            return medicamentoRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar los medicamentos");
        }
    }
}
