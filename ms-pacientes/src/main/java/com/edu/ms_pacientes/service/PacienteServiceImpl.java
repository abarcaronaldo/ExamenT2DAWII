package com.edu.ms_pacientes.service;

import com.edu.ms_pacientes.dto.PacienteRequest;
import com.edu.ms_pacientes.entity.Paciente;
import com.edu.ms_pacientes.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente registrarPaciente(PacienteRequest dto) {
        if(pacienteRepository.findByDni(dto.getDni()).isPresent()) {
            throw new RuntimeException("El paciente con este DNI ya se encuentra registrado.");
        }
        Paciente paciente = new Paciente();
        paciente.setDni(dto.getDni());
        paciente.setNombreCompleto(dto.getNombreCompleto());
        paciente.setTelefono(dto.getTelefono());
        paciente.setCorreo(dto.getCorreo());
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> obtenerPorDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

}
