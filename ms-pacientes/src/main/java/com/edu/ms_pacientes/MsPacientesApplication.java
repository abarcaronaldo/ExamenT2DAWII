package com.edu.ms_pacientes;

import com.edu.ms_pacientes.entity.Paciente;
import com.edu.ms_pacientes.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsPacientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPacientesApplication.class, args);
	}

    @Bean
    public CommandLineRunner cargarDatosDePrueba(PacienteRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Paciente(null, "71234567", "Juan Perez Gomez", "987654321", "juan.perez@gmail.com"));
                repository.save(new Paciente(null, "40876543", "Maraa Flores Rojas", "912345678", "maria.flores@gmail.com"));

                System.out.println("Datos cargados en la bd");
            }
        };
    }

}
