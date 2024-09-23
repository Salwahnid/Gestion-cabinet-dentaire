package com.example.cabinetdentistrybackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("DOCTOR_OWNER")
public class DoctorOwner extends BaseUser {


    @Column(nullable = false)
    private String specialization;



    public DoctorOwner(String firstname, String lastname, String email, String password, RoleType roletype, String specialization) {

        super(firstname, lastname, email, password, roletype); // Appel du constructeur de la classe de base
        this.specialization = specialization;

    }









}
