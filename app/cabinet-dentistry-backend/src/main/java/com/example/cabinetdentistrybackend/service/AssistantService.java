package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.Assistant;
import com.example.cabinetdentistrybackend.model.RoleType;
import com.example.cabinetdentistrybackend.repository.AssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Assistant addAssistant(Assistant assistant) {
        String encodedPassword = passwordEncoder.encode(assistant.getPassword());
        assistant.setPassword(encodedPassword);
        if (assistant.getRoletype() == null) {
            assistant.setRoletype(RoleType.valueOf("ASSISTANT"));
        }
        return assistantRepository.save(assistant);
    }

    public Assistant updateAssistant(Long id, Assistant assistantDetails) {
        Optional<Assistant> optionalAssistant = assistantRepository.findById(id);

        if (optionalAssistant.isPresent()) {
            Assistant assistant = optionalAssistant.get();
            if (assistantDetails.getFirstname() != null) {
                assistant.setFirstname(assistantDetails.getFirstname());
            }
            if (assistantDetails.getLastname() != null) {
                assistant.setLastname(assistantDetails.getLastname());
            }
            if (assistantDetails.getUsername() != null) {
                assistant.setUsername(assistantDetails.getUsername());
            }
            if (assistantDetails.getPassword() != null) {
                assistant.setPassword(assistantDetails.getPassword());
            }
            if (assistantDetails.getPhoneNumber() != null) {
                assistant.setPhoneNumber(assistantDetails.getPhoneNumber());
            }
            if (assistantDetails.getBirthdate() != null) {
                assistant.setBirthdate(assistantDetails.getBirthdate());
            }
            if (assistantDetails.getEmail() != null) {
                assistant.setEmail(assistantDetails.getEmail());
            }
            if (assistantDetails.getCin() != null) {
                assistant.setCin(assistantDetails.getCin());
            }
            if (assistantDetails.isFirstLogin() != assistant.isFirstLogin()) {
                assistant.setFirstLogin(assistantDetails.isFirstLogin());
            }
            return assistantRepository.save(assistant);
        } else {
            return null;
        }
    }

    public List<Assistant> getAllAssistants() {
        return assistantRepository.findAll();
    }

    public Assistant getAssistantById(Long id) {
        return assistantRepository.findById(id).orElse(null);
    }
}
