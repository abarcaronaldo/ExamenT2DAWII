package com.edu.ms_pacientes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    private String telefono;

    @Column(unique = true)
    private String correo;
}
