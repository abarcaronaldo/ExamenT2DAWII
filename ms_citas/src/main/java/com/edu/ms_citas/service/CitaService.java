package com.edu.ms_citas.service;

import com.edu.ms_citas.dto.CitaRequest;
import com.edu.ms_citas.entity.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    Cita registrarCita(CitaRequest dto);
    List<Cita> obtenerTodos();
    Optional<Cita> obtenerPorNumeroCita(String numeroCita);
}
