package com.example.cabinetdentistrybackend.controller;

import com.example.cabinetdentistrybackend.model.Folder;
import com.example.cabinetdentistrybackend.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @GetMapping("/patient/{patientId}")
    public List<Folder> getFoldersByPatientId(@PathVariable Long patientId) {
        return folderService.getFoldersByPatientId(patientId);
    }

    @PostMapping
    public Folder createFolder(@RequestBody Folder folder) {
        return folderService.createOrUpdateFolder(folder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable Long id, @RequestBody Folder folder) {
        Folder existingFolder = folderService.getFolderById(id);
        if (existingFolder == null) {
            return ResponseEntity.notFound().build();
        }
        folder.setId(id);
        return ResponseEntity.ok(folderService.createOrUpdateFolder(folder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolder(@PathVariable Long id) {
        Folder existingFolder = folderService.getFolderById(id);
        if (existingFolder == null) {
            return ResponseEntity.notFound().build();
        }
        folderService.deleteFolder(id);
        return ResponseEntity.noContent().build();
    }
}
