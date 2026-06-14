package com.edu.ms_citas.repository;

import com.edu.ms_citas.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    Optional<Cita> findByNumeroCita(String numeroCita);
}
