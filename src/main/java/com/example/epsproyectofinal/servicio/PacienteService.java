package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Paciente;
import com.example.epsproyectofinal.repositorio.PacienteRepository;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.AttributeInUseException;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements PacienteIn{
    @Autowired
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        try{
            return pacienteRepository.save(paciente);
        }
        catch (Exception e) {
            System.out.println("No se ha podido registrar el paciente en la abse de datos");
            return null;
        }
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) throws Exception {
        if (pacienteRepository.findById(paciente.getIdUsuario()).isPresent()){
            return pacienteRepository.save(paciente);
        }
        else{
            throw new AttributeException("El paciente no existe en la base de datos");
        }
    }

    @Override
    public void eliminarPaciente(Paciente paciente) throws Exception {
        if(pacienteRepository.existsById(paciente.getIdUsuario())){
            pacienteRepository.deleteById(paciente.getIdUsuario());
        }
        else{
            throw new AttributeException("El paciente no existe en la base de datos");
        }
    }

    @Override
    public Paciente obtenerPacienteporId(String idUsuario) throws Exception {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(idUsuario);
        if(pacienteOptional.isPresent()){
            return pacienteOptional.get();
        }
        else{
            throw new AttributeException("El paciente no existe en la abse de datos");
        }
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
}
