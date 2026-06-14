package com.edu.ms_citas.service;

import com.edu.ms_citas.client.PacienteClient;
import com.edu.ms_citas.dto.CitaRequest;
import com.edu.ms_citas.entity.Cita;
import com.edu.ms_citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteClient pacienteClient;

    @Override
    public Cita registrarCita(CitaRequest dto) {
        try {
            pacienteClient.obtenerPorCodigo(dto.getPacienteId());

            Cita cita = new Cita();
            cita.setNumeroCita(dto.getNumeroCita());
            cita.setFecha(dto.getFecha());
            cita.setHora(dto.getHora());
            cita.setEspecialidad(dto.getEspecialidad());
            cita.setPacienteId(dto.getPacienteId());
            cita.setEstado("PENDIENTE");
            return citaRepository.save(cita);

        } catch (Exception e) {
            throw new RuntimeException("Error: El código de paciente "
                    + dto.getPacienteId() + " no existe en el sistema. No se puede agendar la cita.");
        }
    }

    @Override
    public List<Cita> obtenerTodos() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> obtenerPorNumeroCita(String numeroCita) {
        return citaRepository.findByNumeroCita(numeroCita);
    }
}
