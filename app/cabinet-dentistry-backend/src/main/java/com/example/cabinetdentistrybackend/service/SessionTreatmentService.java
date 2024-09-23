package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.SessionTreatment;
import com.example.cabinetdentistrybackend.repository.SessionTreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class SessionTreatmentService {

    @Autowired
    private SessionTreatmentRepository sessionTreatmentRepository;

    public SessionTreatment createOrUpdateSessionTreatment(SessionTreatment sessionTreatment) {
        return sessionTreatmentRepository.save(sessionTreatment);
    }

    public List<SessionTreatment> getAllSessionTreatments() {
        return sessionTreatmentRepository.findAll();
    }

    public Optional<SessionTreatment> getSessionTreatmentById(Long id) {
        return sessionTreatmentRepository.findById(id);
    }

    public void deleteSessionTreatment(Long id) {
        sessionTreatmentRepository.deleteById(id);
    }

    public List<SessionTreatment> getSessionTreatmentsByFolderId(Long folderId) {
        return sessionTreatmentRepository.findByFolderId(folderId);
    }
}

