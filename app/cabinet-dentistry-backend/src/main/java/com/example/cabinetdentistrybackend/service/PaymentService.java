package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.Payment;
import com.example.cabinetdentistrybackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        // Logique pour créer et enregistrer un paiement
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByPatient(Long patientId) {
        // Logique pour récupérer les paiements d'un patient
        return paymentRepository.findByPatientId(patientId);
    }
}

