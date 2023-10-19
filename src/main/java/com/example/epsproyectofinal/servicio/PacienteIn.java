package com.example.epsproyectofinal.servicio;

import com.example.epsproyectofinal.entidad.Paciente;

import java.util.List;

public interface PacienteIn {

    Paciente registrarPaciente(Paciente paciente) throws Exception;

    Paciente actualizarPaciente(Paciente paciente) throws Exception;

    void eliminarPaciente(Paciente paciente) throws Exception;

    Paciente obtenerPacienteporId(String idUsuario) throws Exception;

    List<Paciente> listarPacientes();
}
