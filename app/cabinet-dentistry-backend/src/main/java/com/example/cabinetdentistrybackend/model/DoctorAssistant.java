package com.example.cabinetdentistrybackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Entity
@Setter
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("DOCTOR_ASSISTANT")

public class DoctorAssistant extends BaseUser {


    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private String specialization;



    public DoctorAssistant(String firstname, String lastname, String email, String password, RoleType roletype, String specialization) {
        super(firstname, lastname, email, password, roletype); // Appel du constructeur de la classe de base
        this.specialization = specialization;
    }






}
