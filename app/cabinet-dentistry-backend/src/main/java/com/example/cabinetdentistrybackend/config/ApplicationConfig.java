package com.example.cabinetdentistrybackend.config;//package com.example.cabinetdentistrybackend.config;


import com.example.cabinetdentistrybackend.auditing.ApplicationAuditAware;
import com.example.cabinetdentistrybackend.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final DoctorOwnerRepository doctorOwnerRepository;
    private final DoctorAssistantRepository doctorAssistantRepository;
    private final AssistantRepository assistantRepository;
    private final SecretaryRepository secretaryRepository;
    private final PatientRepository patientRepository;


    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(
                doctorOwnerRepository,
                doctorAssistantRepository,
                assistantRepository,
                secretaryRepository,
                patientRepository
        );
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public ApplicationAuditAware auditorAware() {
        return new ApplicationAuditAware();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
