package com.edu.ms_pacientes.dto;

import lombok.Data;

@Data
public class PacienteRequest {
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private String correo;
}
