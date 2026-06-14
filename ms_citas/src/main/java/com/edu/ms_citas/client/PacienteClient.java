package com.edu.ms_citas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pacientes")
public interface PacienteClient {
    @GetMapping("/api/pacientes/{codigo}")
    ResponseEntity<?> obtenerPorCodigo(@PathVariable("codigo") Long codigo);
}
