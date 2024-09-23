package com.example.cabinetdentistrybackend.repository;

import com.example.cabinetdentistrybackend.model.SessionTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionTreatmentRepository extends JpaRepository<SessionTreatment, Long> {
    List<SessionTreatment> findByFolderId(Long appointmentId);
}
