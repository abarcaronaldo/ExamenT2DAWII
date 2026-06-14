package com.edu.ms_citas.controller;
import com.edu.ms_citas.dto.CitaRequest;
import com.edu.ms_citas.entity.Cita;
import com.edu.ms_citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody CitaRequest dto) {
        try {
            Cita nuevaCita = citaService.registrarCita(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listarTodos() {
        return ResponseEntity.ok(citaService.obtenerTodos());
    }

    @GetMapping("/{numeroCita}")
    public ResponseEntity<?> obtenerPorNumeroCita(@PathVariable String numeroCita) {
        return citaService.obtenerPorNumeroCita(numeroCita)
                .map(cita -> ResponseEntity.ok(cita))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
