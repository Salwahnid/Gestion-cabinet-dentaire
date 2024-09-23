package com.example.cabinetdentistrybackend.repository;


import com.example.cabinetdentistrybackend.model.DoctorOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorOwnerRepository extends JpaRepository<DoctorOwner, Long> {
    Optional<DoctorOwner> findByUsername(String email);

    Optional<DoctorOwner> findByEmail(String email);
}
