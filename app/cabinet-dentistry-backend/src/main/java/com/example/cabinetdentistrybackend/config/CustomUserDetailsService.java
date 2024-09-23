package com.example.cabinetdentistrybackend.config;

import com.example.cabinetdentistrybackend.repository.*;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorOwnerRepository doctorOwnerRepository;
    private final DoctorAssistantRepository doctorAssistantRepository;
    private final AssistantRepository assistantRepository;
    private final SecretaryRepository secretaryRepository;
    private final PatientRepository patientRepository;

    public CustomUserDetailsService(
            DoctorOwnerRepository doctorOwnerRepository,
            DoctorAssistantRepository doctorAssistantRepository,
            AssistantRepository assistantRepository,
            SecretaryRepository secretaryRepository,
            PatientRepository patientRepository) {
        this.doctorOwnerRepository = doctorOwnerRepository;
        this.doctorAssistantRepository = doctorAssistantRepository;
        this.assistantRepository = assistantRepository;
        this.secretaryRepository = secretaryRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = doctorOwnerRepository.findByEmail(email).orElse(null);
        if (user == null) {
            user = doctorAssistantRepository.findByEmail(email).orElse(null);
        }
        if (user == null) {
            user = assistantRepository.findByEmail(email).orElse(null);
        }
        if (user == null) {
            user = secretaryRepository.findByEmail(email).orElse(null);
        }
        if (user == null) {
            user = patientRepository.findByEmail(email).orElse(null);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return user;
    }
}
