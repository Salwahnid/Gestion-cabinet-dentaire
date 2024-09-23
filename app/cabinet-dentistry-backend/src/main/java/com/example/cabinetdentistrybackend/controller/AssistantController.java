package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.Assistant;
import com.example.cabinetdentistrybackend.service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
public class AssistantController {

    @Autowired
    private AssistantService assistantService;

    // Ajouter un assistant
    @PostMapping("/assistants")
    public ResponseEntity<Assistant> addAssistant(@RequestBody Assistant assistant) {
        Assistant savedAssistant = assistantService.addAssistant(assistant);
        return ResponseEntity.ok(savedAssistant);
    }

    // Modifier un assistant
    @PatchMapping("/assistants/{id}")
    public ResponseEntity<Assistant> patchAssistant(@PathVariable Long id, @RequestBody Assistant assistantDetails) {
        Assistant updatedAssistant = assistantService.updateAssistant(id, assistantDetails);
        return updatedAssistant != null ? ResponseEntity.ok(updatedAssistant) : ResponseEntity.notFound().build();
    }

    // Visualiser tous les assistants
    @GetMapping("/assistants")
    public ResponseEntity<List<Assistant>> getAllAssistants() {
        List<Assistant> assistants = assistantService.getAllAssistants();
        return ResponseEntity.ok(assistants);
    }

    // Visualiser un assistant par ID
    @GetMapping("/assistants/{id}")
    public ResponseEntity<Assistant> getAssistantById(@PathVariable Long id) {
        Assistant assistant = assistantService.getAssistantById(id);
        return assistant != null ? ResponseEntity.ok(assistant) : ResponseEntity.notFound().build();
    }

}
