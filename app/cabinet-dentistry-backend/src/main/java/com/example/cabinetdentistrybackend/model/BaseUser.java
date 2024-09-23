package com.example.cabinetdentistrybackend.model;

import jakarta.persistence.*;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@DiscriminatorColumn(name = "user_type")
public abstract class BaseUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    @Column(unique = true)

    private String email;


    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType roletype;

    private String phoneNumber;

    private Date birthdate;

    private String cin;

    @Column(name = "first_login", columnDefinition = "boolean default true")
    private boolean firstLogin = true;

    public BaseUser(String firstname, String lastname, String email, String password, RoleType roletype) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roletype = roletype;
        this.username = email;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> "ROLE_" + roletype.name());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
