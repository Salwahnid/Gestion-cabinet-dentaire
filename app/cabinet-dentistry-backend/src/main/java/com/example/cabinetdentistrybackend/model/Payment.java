package com.example.cabinetdentistrybackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String status;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private PaymentMethod paymentMethod;

    // Getters et Setters
}

