package com.edu.ms_citas;

import com.edu.ms_citas.entity.Cita;
import com.edu.ms_citas.repository.CitaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class MsCitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCitasApplication.class, args);
    }
}
