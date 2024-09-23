package com.example.cabinetdentistrybackend.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;


@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("SECRETARY")
public class Secretary extends BaseUser{


    @Column(nullable = false)
    private boolean active = true; // Par défaut, le secrétaire est actif



    public Secretary(String firstname, String lastname, String email, String password, RoleType roletype) {
        super(firstname, lastname, email, password, roletype); // Appel du constructeur de la classe de base
    }






}

