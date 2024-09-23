package com.example.cabinetdentistrybackend.repository;


import com.example.cabinetdentistrybackend.model.Assistant;
import com.example.cabinetdentistrybackend.model.DoctorOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssistantRepository extends JpaRepository<Assistant, Long> {
    Optional<Assistant> findByUsername(String email);

    Optional<Assistant> findByEmail( String email);
}
