package com.example.cabinetdentistrybackend.repository;


import com.example.cabinetdentistrybackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUsername(String email);

    Optional<Patient> findByEmail(String email);
}
