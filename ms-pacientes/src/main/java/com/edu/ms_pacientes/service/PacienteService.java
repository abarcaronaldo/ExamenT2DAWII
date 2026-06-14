package com.edu.ms_pacientes.service;

import com.edu.ms_pacientes.dto.PacienteRequest;
import com.edu.ms_pacientes.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente registrarPaciente(PacienteRequest dto);
    List<Paciente> obtenerTodos();
    Optional<Paciente> obtenerPorDni(String dni);
}
