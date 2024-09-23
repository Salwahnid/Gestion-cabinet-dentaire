package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.SessionTreatment;
import com.example.cabinetdentistrybackend.service.SessionTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/session-treatments")
public class SessionTreatmentController {

    @Autowired
    private SessionTreatmentService sessionTreatmentService;

    @GetMapping
    public List<SessionTreatment> getAllSessionTreatments() {
        return sessionTreatmentService.getAllSessionTreatments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionTreatment> getSessionTreatmentById(@PathVariable Long id) {
        Optional<SessionTreatment> sessionTreatment = sessionTreatmentService.getSessionTreatmentById(id);
        return sessionTreatment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SessionTreatment createSessionTreatment(@RequestBody SessionTreatment sessionTreatment) {
        return sessionTreatmentService.createOrUpdateSessionTreatment(sessionTreatment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionTreatment> updateSessionTreatment(@PathVariable Long id, @RequestBody SessionTreatment sessionTreatment) {
        Optional<SessionTreatment> existingSessionTreatment = sessionTreatmentService.getSessionTreatmentById(id);
        if (existingSessionTreatment.isPresent()) {
            sessionTreatment.setId(id);
            return ResponseEntity.ok(sessionTreatmentService.createOrUpdateSessionTreatment(sessionTreatment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessionTreatment(@PathVariable Long id) {
        sessionTreatmentService.deleteSessionTreatment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/folder/{folderId}")
    public List<SessionTreatment> getSessionTreatmentsByFolderId(@PathVariable Long folderId) {
        return sessionTreatmentService.getSessionTreatmentsByFolderId(folderId);
    }
}
