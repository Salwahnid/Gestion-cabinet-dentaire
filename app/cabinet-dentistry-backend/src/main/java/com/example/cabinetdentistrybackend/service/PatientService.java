package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.Patient;
import com.example.cabinetdentistrybackend.model.RoleType;
import com.example.cabinetdentistrybackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Patient addPatient(Patient patient) {
        patient.setPassword("patient");
        String encodedPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encodedPassword);
        patient.setRoletype(RoleType.valueOf("PATIENT"));
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            if (patientDetails.getFirstname() != null) {
                patient.setFirstname(patientDetails.getFirstname());
            }
            if (patientDetails.getLastname() != null) {
                patient.setLastname(patientDetails.getLastname());
            }
            if (patientDetails.getUsername() != null) {
                patient.setUsername(patientDetails.getUsername());
            }
            if (patientDetails.getPassword() != null) {
                patient.setPassword(patientDetails.getPassword());
            }
            if (patientDetails.getPhoneNumber() != null) {
                patient.setPhoneNumber(patientDetails.getPhoneNumber());
            }
            if (patientDetails.getBirthdate() != null) {
                patient.setBirthdate(patientDetails.getBirthdate());
            }
            if (patientDetails.getEmail() != null) {
                patient.setEmail(patientDetails.getEmail());
            }
            if (patientDetails.getCin() != null) {
                patient.setCin(patientDetails.getCin());
            }
            if (patientDetails.isFirstLogin() != patient.isFirstLogin()) {
                patient.setFirstLogin(patientDetails.isFirstLogin());
            }
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }


    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }



    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    public Patient createOrUpdatePatient(Patient patient) {
        // Si le patient est nouveau ou si le mot de passe a changé, le crypter
        if (patient.getId() == null || (patient.getPassword() != null && !patient.getPassword().isEmpty())) {
            String encodedPassword = passwordEncoder.encode(patient.getPassword());
            patient.setPassword(encodedPassword);
        } else {
            // Sinon, ne pas modifier le mot de passe
            Optional<Patient> existingPatient = patientRepository.findById(patient.getId());
            if (existingPatient.isPresent()) {
                patient.setPassword(existingPatient.get().getPassword());
            }
        }
        return patientRepository.save(patient);
    }



}
