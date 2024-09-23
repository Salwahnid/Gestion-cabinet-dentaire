package com.example.cabinetdentistrybackend.controller;
import com.example.cabinetdentistrybackend.model.DoctorAssistant;
import com.example.cabinetdentistrybackend.model.DoctorOwner;
import com.example.cabinetdentistrybackend.repository.DoctorAssistantRepository;
import com.example.cabinetdentistrybackend.repository.DoctorOwnerRepository;
import com.example.cabinetdentistrybackend.service.DoctorAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctorAssistants")
public class DoctorAssistantController {

    @Autowired
    private DoctorAssistantService doctorAssistantService;

    // Ajouter un doctor assistant
    @PostMapping("/doctor-assistants")
    public ResponseEntity<DoctorAssistant> addDoctorAssistant(@RequestBody DoctorAssistant doctorAssistant) {
        DoctorAssistant savedDoctorAssistant = doctorAssistantService.addDoctorAssistant(doctorAssistant);
        return ResponseEntity.ok(savedDoctorAssistant);
    }

    // Modifier un doctor assistant
    @PatchMapping("/doctor-assistants/{id}")
    public ResponseEntity<DoctorAssistant> patchDoctorAssistant(@PathVariable Long id, @RequestBody DoctorAssistant doctorAssistantDetails) {
        DoctorAssistant updatedDoctorAssistant = doctorAssistantService.updateDoctorAssistant(id, doctorAssistantDetails);
        return updatedDoctorAssistant != null ? ResponseEntity.ok(updatedDoctorAssistant) : ResponseEntity.notFound().build();
    }
    // Visualiser tous les doctor assistants
    @GetMapping("/doctor-assistants")
    public ResponseEntity<List<DoctorAssistant>> getAllDoctorAssistants() {
        List<DoctorAssistant> doctorAssistants = doctorAssistantService.getAllDoctorAssistants();
        return ResponseEntity.ok(doctorAssistants);
    }

    // Visualiser un doctor assistant par ID
    @GetMapping("/doctor-assistants/{id}")
    public ResponseEntity<DoctorAssistant> getDoctorAssistantById(@PathVariable Long id) {
        DoctorAssistant doctorAssistant = doctorAssistantService.getDoctorAssistantById(id);
        return doctorAssistant != null ? ResponseEntity.ok(doctorAssistant) : ResponseEntity.notFound().build();
    }
}

