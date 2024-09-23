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
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@DiscriminatorValue("ASSISTANT")
public class Assistant extends BaseUser {





    @ManyToOne
    @JoinColumn(name = "doctorOwner_id", nullable = false)
    private DoctorOwner doctorOwner;

//    @OneToMany(mappedBy = "assistant", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Appointment> appointments;


    public Assistant(String firstname, String lastname, String email, String password, RoleType roletype) {
        super(firstname, lastname, email, password, roletype); // Appel du constructeur de la classe de base
    }

    public Assistant() {

    }




}
