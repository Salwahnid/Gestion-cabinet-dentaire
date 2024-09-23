package com.example.cabinetdentistrybackend.repository;


import com.example.cabinetdentistrybackend.model.DoctorAssistant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorAssistantRepository extends JpaRepository<DoctorAssistant, Long> {

    Optional<DoctorAssistant> findByUsername(String email);

    Optional<DoctorAssistant> findByEmail( String email);
}
