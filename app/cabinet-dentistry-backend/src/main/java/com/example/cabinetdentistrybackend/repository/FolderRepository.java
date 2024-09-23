package com.example.cabinetdentistrybackend.repository;

import com.example.cabinetdentistrybackend.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByPatientId(Long patientId);

}
