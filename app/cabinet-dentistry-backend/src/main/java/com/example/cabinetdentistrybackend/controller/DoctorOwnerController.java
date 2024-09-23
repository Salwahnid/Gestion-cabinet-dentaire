package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.*;
import com.example.cabinetdentistrybackend.service.DoctorOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor-owner")
public class DoctorOwnerController {

    @Autowired
    private DoctorOwnerService doctorOwnerService;

    @PostMapping("/profile")
    public ResponseEntity<DoctorOwner> createProfile(@RequestBody DoctorOwner doctorOwner) {
        DoctorOwner createdDoctorOwner = doctorOwnerService.createProfile(doctorOwner);
        return ResponseEntity.ok(createdDoctorOwner);
    }

    // Obtenir le profil du doctorOwner
    @GetMapping("/profile/{id}")
    public ResponseEntity<DoctorOwner> getProfile(@PathVariable Long id) {
        DoctorOwner doctorOwner = doctorOwnerService.getProfile(id);
        return doctorOwner != null ? ResponseEntity.ok(doctorOwner) : ResponseEntity.notFound().build();
    }

    // Mettre à jour le profil du doctorOwner
    @PatchMapping("/profile/{id}")
    public ResponseEntity<DoctorOwner> updateProfile(@PathVariable Long id, @RequestBody DoctorOwner doctorOwnerDetails) {
        DoctorOwner updatedDoctorOwner = doctorOwnerService.updateProfile(id, doctorOwnerDetails);
        return updatedDoctorOwner != null ? ResponseEntity.ok(updatedDoctorOwner) : ResponseEntity.notFound().build();
    }
//
//    // Ajouter un secrétaire
//    @PostMapping("/secretaries")
//    public ResponseEntity<Secretary> addSecretary(@RequestBody Secretary secretary) {
//        Secretary savedSecretary = doctorOwnerService.addSecretary(secretary);
//        return ResponseEntity.ok(savedSecretary);
//    }
//
//    // Désactiver un secrétaire
//    @PutMapping("/secretaries/{id}/deactivate")
//    public ResponseEntity<Void> deactivateSecretary(@PathVariable Long id) {
//        doctorOwnerService.deactivateSecretary(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Modifier un secrétaire
//    @PatchMapping("/secretaries/{id}")
//    public ResponseEntity<Secretary> patchSecretary(@PathVariable Long id, @RequestBody Secretary secretaryDetails) {
//        Secretary updatedSecretary = doctorOwnerService.updateSecretary(id, secretaryDetails);
//        return updatedSecretary != null ? ResponseEntity.ok(updatedSecretary) : ResponseEntity.notFound().build();
//    }
//
//    // Visualiser tous les secrétaires
//    @GetMapping("/secretaries")
//    public ResponseEntity<List<Secretary>> getAllSecretaries() {
//        List<Secretary> secretaries = doctorOwnerService.getAllSecretaries();
//        return ResponseEntity.ok(secretaries);
//    }
//
//    // Visualiser un secrétaire par ID
//    @GetMapping("/secretaries/{id}")
//    public ResponseEntity<Secretary> getSecretaryById(@PathVariable Long id) {
//        Secretary secretary = doctorOwnerService.getSecretaryById(id);
//        return secretary != null ? ResponseEntity.ok(secretary) : ResponseEntity.notFound().build();
//    }
//
//    // Ajouter un client
//    @PostMapping("/clients")
//    public ResponseEntity<Patient> addClient(@RequestBody Patient patient) {
//        Patient savedPatient = doctorOwnerService.addClient(patient);
//        return ResponseEntity.ok(savedPatient);
//    }
//
//    // Modifier un client
//    @PatchMapping("/clients/{id}")
//    public ResponseEntity<Patient> patchClient(@PathVariable Long id, @RequestBody Patient patientDetails) {
//        Patient updatedPatient = doctorOwnerService.updateClient(id, patientDetails);
//        return updatedPatient != null ? ResponseEntity.ok(updatedPatient) : ResponseEntity.notFound().build();
//    }
//
//    // Visualiser tous les clients
//    @GetMapping("/clients")
//    public ResponseEntity<List<Patient>> getAllClients() {
//        List<Patient> patients = doctorOwnerService.getAllClients();
//        return ResponseEntity.ok(patients);
//    }
//
//    // Visualiser un client par ID
//    @GetMapping("/clients/{id}")
//    public ResponseEntity<Patient> getClientById(@PathVariable Long id) {
//        Patient patient = doctorOwnerService.getClientById(id);
//        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
//    }
//
//    // Ajouter un assistant
//    @PostMapping("/assistants")
//    public ResponseEntity<Assistant> addAssistant(@RequestBody Assistant assistant) {
//        Assistant savedAssistant = doctorOwnerService.addAssistant(assistant);
//        return ResponseEntity.ok(savedAssistant);
//    }
//
//    // Modifier un assistant
//    @PatchMapping("/assistants/{id}")
//    public ResponseEntity<Assistant> patchAssistant(@PathVariable Long id, @RequestBody Assistant assistantDetails) {
//        Assistant updatedAssistant = doctorOwnerService.updateAssistant(id, assistantDetails);
//        return updatedAssistant != null ? ResponseEntity.ok(updatedAssistant) : ResponseEntity.notFound().build();
//    }
//
//    // Visualiser tous les assistants
//    @GetMapping("/assistants")
//    public ResponseEntity<List<Assistant>> getAllAssistants() {
//        List<Assistant> assistants = doctorOwnerService.getAllAssistants();
//        return ResponseEntity.ok(assistants);
//    }
//
//    // Visualiser un assistant par ID
//    @GetMapping("/assistants/{id}")
//    public ResponseEntity<Assistant> getAssistantById(@PathVariable Long id) {
//        Assistant assistant = doctorOwnerService.getAssistantById(id);
//        return assistant != null ? ResponseEntity.ok(assistant) : ResponseEntity.notFound().build();
//    }
//
//    // Ajouter un doctor assistant
//    @PostMapping("/doctor-assistants")
//    public ResponseEntity<DoctorAssistant> addDoctorAssistant(@RequestBody DoctorAssistant doctorAssistant) {
//        DoctorAssistant savedDoctorAssistant = doctorOwnerService.addDoctorAssistant(doctorAssistant);
//        return ResponseEntity.ok(savedDoctorAssistant);
//    }
//
//    // Modifier un doctor assistant
//    @PatchMapping("/doctor-assistants/{id}")
//    public ResponseEntity<DoctorAssistant> patchDoctorAssistant(@PathVariable Long id, @RequestBody DoctorAssistant doctorAssistantDetails) {
//        DoctorAssistant updatedDoctorAssistant = doctorOwnerService.updateDoctorAssistant(id, doctorAssistantDetails);
//        return updatedDoctorAssistant != null ? ResponseEntity.ok(updatedDoctorAssistant) : ResponseEntity.notFound().build();
//    }
//    // Visualiser tous les doctor assistants
//    @GetMapping("/doctor-assistants")
//    public ResponseEntity<List<DoctorAssistant>> getAllDoctorAssistants() {
//        List<DoctorAssistant> doctorAssistants = doctorOwnerService.getAllDoctorAssistants();
//        return ResponseEntity.ok(doctorAssistants);
//    }
//
//    // Visualiser un doctor assistant par ID
//    @GetMapping("/doctor-assistants/{id}")
//    public ResponseEntity<DoctorAssistant> getDoctorAssistantById(@PathVariable Long id) {
//        DoctorAssistant doctorAssistant = doctorOwnerService.getDoctorAssistantById(id);
//        return doctorAssistant != null ? ResponseEntity.ok(doctorAssistant) : ResponseEntity.notFound().build();
//    }
}
