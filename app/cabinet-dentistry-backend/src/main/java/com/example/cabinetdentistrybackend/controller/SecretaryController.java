package com.example.cabinetdentistrybackend.controller;



import com.example.cabinetdentistrybackend.model.Secretary;
import com.example.cabinetdentistrybackend.model.SecretaryRegistrationRequest;
import com.example.cabinetdentistrybackend.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;



    @PostMapping
    public ResponseEntity<Secretary> addSecretary(@RequestBody SecretaryRegistrationRequest request) {
        Secretary secretary = request.getSecretaryRequest();
        Secretary savedSecretary = secretaryService.addSecretary(secretary);
        return ResponseEntity.ok(savedSecretary);
    }

    // Désactiver un secrétaire
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateSecretary(@PathVariable Long id) {
        secretaryService.deactivateSecretary(id);
        return ResponseEntity.noContent().build();
    }

    // Modifier un secrétaire
    @PatchMapping("/{id}")
    public ResponseEntity<Secretary> patchSecretary(@PathVariable Long id, @RequestBody Secretary secretaryDetails) {
        Secretary updatedSecretary = secretaryService.updateSecretary(id, secretaryDetails);
        return updatedSecretary != null ? ResponseEntity.ok(updatedSecretary) : ResponseEntity.notFound().build();
    }

    // Visualiser tous les secrétaires
    @GetMapping
    public ResponseEntity<List<Secretary>> getAllSecretaries() {
        List<Secretary> secretaries = secretaryService.getAllSecretaries();
        return ResponseEntity.ok(secretaries);
    }

    // Visualiser un secrétaire par ID
    @GetMapping("{id}")
    public ResponseEntity<Secretary> getSecretaryById(@PathVariable Long id) {
        Secretary secretary = secretaryService.getSecretaryById(id);
        return secretary != null ? ResponseEntity.ok(secretary) : ResponseEntity.notFound().build();
    }
}

