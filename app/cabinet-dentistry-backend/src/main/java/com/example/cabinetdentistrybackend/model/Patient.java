package com.example.cabinetdentistrybackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("PATIENT")
public class Patient extends BaseUser{


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Appointment> appointments;



    public Patient(String firstname, String lastname, String email, String password, RoleType roletype) {
        super(firstname, lastname, email, password, roletype); // Appel du constructeur de la classe de base

    }

}

