package com.edu.ms_citas.dto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class CitaRequest {

    private String numeroCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String especialidad;
    private Long pacienteId;
}
