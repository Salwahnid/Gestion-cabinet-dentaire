package com.example.cabinetdentistrybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CabinetDentistryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabinetDentistryBackendApplication.class, args);
	}

}
