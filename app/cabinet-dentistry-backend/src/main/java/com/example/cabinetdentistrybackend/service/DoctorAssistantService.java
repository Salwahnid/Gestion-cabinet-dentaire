package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.DoctorAssistant;
import com.example.cabinetdentistrybackend.model.RoleType;
import com.example.cabinetdentistrybackend.repository.DoctorAssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorAssistantService {

    @Autowired
    private DoctorAssistantRepository doctorAssistantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public DoctorAssistant addDoctorAssistant(DoctorAssistant doctorAssistant) {
        String encodedPassword = passwordEncoder.encode(doctorAssistant.getPassword());
        doctorAssistant.setPassword(encodedPassword);
        if (doctorAssistant.getRoletype() == null) {
            doctorAssistant.setRoletype(RoleType.valueOf("DOCTOR_ASSISTANT"));
        }
        return doctorAssistantRepository.save(doctorAssistant);
    }

    public DoctorAssistant updateDoctorAssistant(Long id, DoctorAssistant doctorAssistantDetails) {
        Optional<DoctorAssistant> optionalDoctorAssistant = doctorAssistantRepository.findById(id);

        if (optionalDoctorAssistant.isPresent()) {
            DoctorAssistant doctorAssistant = optionalDoctorAssistant.get();
            if (doctorAssistantDetails.getFirstname() != null) {
                doctorAssistant.setFirstname(doctorAssistantDetails.getFirstname());
            }
            if (doctorAssistantDetails.getLastname() != null) {
                doctorAssistant.setLastname(doctorAssistantDetails.getLastname());
            }
            if (doctorAssistantDetails.getUsername() != null) {
                doctorAssistant.setUsername(doctorAssistantDetails.getUsername());
            }
            if (doctorAssistantDetails.getPassword() != null) {
                doctorAssistant.setPassword(doctorAssistantDetails.getPassword());
            }
            if (doctorAssistantDetails.getPhoneNumber() != null) {
                doctorAssistant.setPhoneNumber(doctorAssistantDetails.getPhoneNumber());
            }
            if (doctorAssistantDetails.getBirthdate() != null) {
                doctorAssistant.setBirthdate(doctorAssistantDetails.getBirthdate());
            }
            if (doctorAssistantDetails.getEmail() != null) {
                doctorAssistant.setEmail(doctorAssistantDetails.getEmail());
            }
            if (doctorAssistantDetails.getCin() != null) {
                doctorAssistant.setCin(doctorAssistantDetails.getCin());
            }
            if (doctorAssistantDetails.isFirstLogin() != doctorAssistant.isFirstLogin()) {
                doctorAssistant.setFirstLogin(doctorAssistantDetails.isFirstLogin());
            }
            return doctorAssistantRepository.save(doctorAssistant);
        } else {
            return null;
        }
    }

    public List<DoctorAssistant> getAllDoctorAssistants() {
        return doctorAssistantRepository.findAll();
    }

    public DoctorAssistant getDoctorAssistantById(Long id) {
        return doctorAssistantRepository.findById(id).orElse(null);
    }
}
