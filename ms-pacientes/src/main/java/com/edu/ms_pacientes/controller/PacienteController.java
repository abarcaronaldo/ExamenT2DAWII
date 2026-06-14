package com.edu.ms_pacientes.controller;

import com.edu.ms_pacientes.dto.PacienteRequest;
import com.edu.ms_pacientes.entity.Paciente;
import com.edu.ms_pacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody PacienteRequest dto) {
        try {
            Paciente nuevoPaciente = pacienteService.registrarPaciente(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.obtenerTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obtenerPorCodigo(@PathVariable Long codigo) {
        return pacienteService.buscarPorCodigo(codigo)
                .map(paciente -> ResponseEntity.ok(paciente))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
