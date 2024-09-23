package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.DoctorOwner;
import com.example.cabinetdentistrybackend.repository.DoctorOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorOwnerService {

    @Autowired
    private DoctorOwnerRepository doctorOwnerRepository;

    public DoctorOwner createProfile(DoctorOwner doctorOwner) {
        return doctorOwnerRepository.save(doctorOwner);
    }

    public DoctorOwner getProfile(Long id) {
        return doctorOwnerRepository.findById(id).orElse(null);
    }

    public DoctorOwner updateProfile(Long id, DoctorOwner doctorOwnerDetails) {
        DoctorOwner existingDoctorOwner = doctorOwnerRepository.findById(id).orElse(null);
        if (existingDoctorOwner != null) {
            existingDoctorOwner.setFirstname(doctorOwnerDetails.getFirstname());
            existingDoctorOwner.setLastname(doctorOwnerDetails.getLastname());
            existingDoctorOwner.setEmail(doctorOwnerDetails.getEmail());
            existingDoctorOwner.setPhoneNumber(doctorOwnerDetails.getPhoneNumber());
            return doctorOwnerRepository.save(existingDoctorOwner);
        } else {
            return null;
        }
    }
}

























//
//import com.example.cabinetdentistrybackend.model.*;
//import com.example.cabinetdentistrybackend.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DoctorOwnerService {
//
//    @Autowired
//    private SecretaryRepository secretaryRepository;
//
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @Autowired
//    private DoctorAssistantRepository doctorAssistantRepository;
//
//    @Autowired
//    private AssistantRepository assistantRepository;
//
//    @Autowired
//    private DoctorOwnerRepository doctorOwnerRepository;
//
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public DoctorOwner createProfile(DoctorOwner doctorOwner) {
//        return doctorOwnerRepository.save(doctorOwner);
//    }
//
//    public DoctorOwner getProfile(Long id) {
//        return doctorOwnerRepository.findById(id).orElse(null);
//    }
//
//    public DoctorOwner updateProfile(Long id, DoctorOwner doctorOwnerDetails) {
//        DoctorOwner existingDoctorOwner = doctorOwnerRepository.findById(id).orElse(null);
//        if (existingDoctorOwner != null) {
//            // Mettez à jour les champs nécessaires
//            existingDoctorOwner.setFirstname(doctorOwnerDetails.getFirstname());
//            existingDoctorOwner.setLastname(doctorOwnerDetails.getLastname());
//            existingDoctorOwner.setEmail(doctorOwnerDetails.getEmail());
//            existingDoctorOwner.setPhoneNumber(doctorOwnerDetails.getPhoneNumber());
//            // Ajoutez d'autres champs nécessaires
//            return doctorOwnerRepository.save(existingDoctorOwner);
//        } else {
//            return null;
//        }
//    }
//
//    // Ajouter un secrétaire
//    @Transactional
//    public Secretary addSecretary(Secretary secretary) {
//        String encodedPassword = passwordEncoder.encode(secretary.getPassword());
//        secretary.setPassword(encodedPassword);
//        return secretaryRepository.save(secretary);
//    }
//
//    // Désactiver un secrétaire
//    public void deactivateSecretary(Long id) {
//        Optional<Secretary> secretary = secretaryRepository.findById(id);
//        if (secretary.isPresent()) {
//            Secretary sec = secretary.get();
//            sec.setActive(false);
//            secretaryRepository.save(sec);
//        }
//    }
//
//    // Ajouter un client
//    @Transactional
//    public Patient addClient(Patient patient) {
//        String encodedPassword = passwordEncoder.encode(patient.getPassword());
//        patient.setPassword(encodedPassword);
//        return patientRepository.save(patient);
//    }
//
//    // Ajouter un assistant
//    @Transactional
//    public Assistant addAssistant(Assistant assistant) {
//        String encodedPassword = passwordEncoder.encode(assistant.getPassword());
//        assistant.setPassword(encodedPassword);
//        return assistantRepository.save(assistant);
//    }
//
//    // Ajouter un doctor assistant
//    @Transactional
//    public DoctorAssistant addDoctorAssistant(DoctorAssistant doctorAssistant) {
//        String encodedPassword = passwordEncoder.encode(doctorAssistant.getPassword());
//        doctorAssistant.setPassword(encodedPassword);
//        return doctorAssistantRepository.save(doctorAssistant);
//    }
//
//    // Modifier les informations d'un secrétaire
//    public Secretary updateSecretary(Long id, Secretary secretaryDetails) {
//        Optional<Secretary> optionalSecretary = secretaryRepository.findById(id);
//
//        if (optionalSecretary.isPresent()) {
//            Secretary secretary = optionalSecretary.get();
//            // Mettre à jour uniquement les champs non nuls du secrétaire avec les détails fournis
//            if (secretaryDetails.getFirstname() != null) {
//                secretary.setFirstname(secretaryDetails.getFirstname());
//            }
//            if (secretaryDetails.getLastname() != null) {
//                secretary.setLastname(secretaryDetails.getLastname());
//            }
//            if (secretaryDetails.getUsername() != null) {
//                secretary.setUsername(secretaryDetails.getUsername());
//            }
//            if (secretaryDetails.getPassword() != null) {
//                secretary.setPassword(secretaryDetails.getPassword());
//            }
//            if (secretaryDetails.getPhoneNumber() != null) {
//                secretary.setPhoneNumber(secretaryDetails.getPhoneNumber());
//            }
//            if (secretaryDetails.getBirthdate() != null) {
//                secretary.setBirthdate(secretaryDetails.getBirthdate());
//            }
//            if (secretaryDetails.getEmail() != null) {
//                secretary.setEmail(secretaryDetails.getEmail());
//            }
//            if (secretaryDetails.getCin() != null) {
//                secretary.setCin(secretaryDetails.getCin());
//            }
//            if (secretaryDetails.isFirstLogin() != secretary.isFirstLogin()) {
//                secretary.setFirstLogin(secretaryDetails.isFirstLogin());
//            }
//            // Sauvegarder les modifications
//            return secretaryRepository.save(secretary);
//        } else {
//            return null;
//        }
//    }
//
//
//    // Modifier les informations d'un client
//    public Patient updateClient(Long id, Patient patientDetails) {
//        Optional<Patient> optionalClient = patientRepository.findById(id);
//
//        if (optionalClient.isPresent()) {
//            Patient patient = optionalClient.get();
//            if (patientDetails.getFirstname() != null) {
//                patient.setFirstname(patientDetails.getFirstname());
//            }
//            if (patientDetails.getLastname() != null) {
//                patient.setLastname(patientDetails.getLastname());
//            }
//            if (patientDetails.getUsername() != null) {
//                patient.setUsername(patientDetails.getUsername());
//            }
//            if (patientDetails.getPassword() != null) {
//                patient.setPassword(patientDetails.getPassword());
//            }
//            if (patientDetails.getPhoneNumber() != null) {
//                patient.setPhoneNumber(patientDetails.getPhoneNumber());
//            }
//            if (patientDetails.getBirthdate() != null) {
//                patient.setBirthdate(patientDetails.getBirthdate());
//            }
//            if (patientDetails.getEmail() != null) {
//                patient.setEmail(patientDetails.getEmail());
//            }
//            if (patientDetails.getCin() != null) {
//                patient.setCin(patientDetails.getCin());
//            }
//            if (patientDetails.isFirstLogin() != patient.isFirstLogin()) {
//                patient.setFirstLogin(patientDetails.isFirstLogin());
//            }
//            return patientRepository.save(patient);
//        } else {
//            return null;
//        }
//    }
//
//    // Modifier les informations d'un assistant
//    public Assistant updateAssistant(Long id, Assistant assistantDetails) {
//        Optional<Assistant> optionalAssistant = assistantRepository.findById(id);
//
//        if (optionalAssistant.isPresent()) {
//            Assistant assistant = optionalAssistant.get();
//            if (assistantDetails.getFirstname() != null) {
//                assistant.setFirstname(assistantDetails.getFirstname());
//            }
//            if (assistantDetails.getLastname() != null) {
//                assistant.setLastname(assistantDetails.getLastname());
//            }
//            if (assistantDetails.getUsername() != null) {
//                assistant.setUsername(assistantDetails.getUsername());
//            }
//            if (assistantDetails.getPassword() != null) {
//                assistant.setPassword(assistantDetails.getPassword());
//            }
//            if (assistantDetails.getPhoneNumber() != null) {
//                assistant.setPhoneNumber(assistantDetails.getPhoneNumber());
//            }
//            if (assistantDetails.getBirthdate() != null) {
//                assistant.setBirthdate(assistantDetails.getBirthdate());
//            }
//            if (assistantDetails.getEmail() != null) {
//                assistant.setEmail(assistantDetails.getEmail());
//            }
//            if (assistantDetails.getCin() != null) {
//                assistant.setCin(assistantDetails.getCin());
//            }
//            if (assistantDetails.isFirstLogin() != assistant.isFirstLogin()) {
//                assistant.setFirstLogin(assistantDetails.isFirstLogin());
//            }
//            return assistantRepository.save(assistant);
//        } else {
//            return null;
//        }
//    }
//
//    // Modifier les informations d'un doctor assistant
//    public DoctorAssistant updateDoctorAssistant(Long id, DoctorAssistant doctorAssistantDetails) {
//        Optional<DoctorAssistant> optionalDoctorAssistant = doctorAssistantRepository.findById(id);
//
//        if (optionalDoctorAssistant.isPresent()) {
//            DoctorAssistant doctorAssistant = optionalDoctorAssistant.get();
//            if (doctorAssistantDetails.getFirstname() != null) {
//                doctorAssistant.setFirstname(doctorAssistantDetails.getFirstname());
//            }
//            if (doctorAssistantDetails.getLastname() != null) {
//                doctorAssistant.setLastname(doctorAssistantDetails.getLastname());
//            }
//            if (doctorAssistantDetails.getUsername() != null) {
//                doctorAssistant.setUsername(doctorAssistantDetails.getUsername());
//            }
//            if (doctorAssistantDetails.getPassword() != null) {
//                doctorAssistant.setPassword(doctorAssistantDetails.getPassword());
//            }
//            if (doctorAssistantDetails.getPhoneNumber() != null) {
//                doctorAssistant.setPhoneNumber(doctorAssistantDetails.getPhoneNumber());
//            }
//            if (doctorAssistantDetails.getBirthdate() != null) {
//                doctorAssistant.setBirthdate(doctorAssistantDetails.getBirthdate());
//            }
//            if (doctorAssistantDetails.getEmail() != null) {
//                doctorAssistant.setEmail(doctorAssistantDetails.getEmail());
//            }
//            if (doctorAssistantDetails.getCin() != null) {
//                doctorAssistant.setCin(doctorAssistantDetails.getCin());
//            }
//            if (doctorAssistantDetails.isFirstLogin() != doctorAssistant.isFirstLogin()) {
//                doctorAssistant.setFirstLogin(doctorAssistantDetails.isFirstLogin());
//            }
//            return doctorAssistantRepository.save(doctorAssistant);
//        } else {
//            return null;
//        }
//    }
//
//    // Visualiser tous les secrétaires
//    public List<Secretary> getAllSecretaries() {
//        return secretaryRepository.findAll();
//    }
//
//    // Visualiser tous les clients
//    public List<Patient> getAllClients() {
//        return patientRepository.findAll();
//    }
//
//    // Visualiser tous les assistants
//    public List<Assistant> getAllAssistants() {
//        return assistantRepository.findAll();
//    }
//
//    // Visualiser tous les doctor assistants
//    public List<DoctorAssistant> getAllDoctorAssistants() {
//        return doctorAssistantRepository.findAll();
//    }
//
//    // Visualiser un secrétaire par ID
//    public Secretary getSecretaryById(Long id) {
//        return secretaryRepository.findById(id).orElse(null);
//    }
//
//    // Visualiser un client par ID
//    public Patient getClientById(Long id) {
//        return patientRepository.findById(id).orElse(null);
//    }
//
//    // Visualiser un assistant par ID
//    public Assistant getAssistantById(Long id) {
//        return assistantRepository.findById(id).orElse(null);
//    }
//
//    // Visualiser un doctor assistant par ID
//    public DoctorAssistant getDoctorAssistantById(Long id) {
//        return doctorAssistantRepository.findById(id).orElse(null);
//    }
//}
