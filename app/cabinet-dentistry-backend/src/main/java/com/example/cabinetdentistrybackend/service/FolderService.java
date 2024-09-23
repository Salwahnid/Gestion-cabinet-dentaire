package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.Folder;
import com.example.cabinetdentistrybackend.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public List<Folder> getFoldersByPatientId(Long patientId) {
        return folderRepository.findByPatientId(patientId);
    }

    public Folder createOrUpdateFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }

    public Folder getFolderById(Long id) {
        return folderRepository.findById(id).orElse(null);
    }
}
