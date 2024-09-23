package com.example.cabinetdentistrybackend.repository;
import com.example.cabinetdentistrybackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPatientId(Long patientId);
}

