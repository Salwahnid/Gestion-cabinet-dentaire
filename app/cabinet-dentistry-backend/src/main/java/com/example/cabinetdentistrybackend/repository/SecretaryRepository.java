package com.example.cabinetdentistrybackend.repository;


import com.example.cabinetdentistrybackend.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    Optional<Secretary> findByUsername(String email);

    Optional<Secretary> findByEmail( String email);
}

