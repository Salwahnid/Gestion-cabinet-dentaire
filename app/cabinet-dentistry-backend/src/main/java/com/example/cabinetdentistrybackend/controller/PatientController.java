package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.Patient;
import com.example.cabinetdentistrybackend.model.PatientRegistrationRequest;
import com.example.cabinetdentistrybackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient1")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRegistrationRequest request) {
        Patient patient = request.getPatientRequest();
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient existingPatient = patientService.updatePatient(id, patient);
        if (existingPatient == null) {
            return ResponseEntity.notFound().build();
        }
        patient.setId(id);
        return ResponseEntity.ok(patientService.createOrUpdatePatient(patient));

    }


}
