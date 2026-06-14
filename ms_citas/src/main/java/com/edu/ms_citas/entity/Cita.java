package com.edu.ms_citas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @Column(name = "numero_cita", nullable = false, unique = true, length = 20)
    private String numeroCita;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}
