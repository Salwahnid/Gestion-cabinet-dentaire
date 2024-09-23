package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.Payment;
import com.example.cabinetdentistrybackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Payment>> getPaymentsByPatient(@PathVariable Long patientId) {
        List<Payment> payments = paymentService.getPaymentsByPatient(patientId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
