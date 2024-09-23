package com.example.cabinetdentistrybackend.service;

import com.example.cabinetdentistrybackend.model.RoleType;
import com.example.cabinetdentistrybackend.model.Secretary;
import com.example.cabinetdentistrybackend.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Secretary addSecretary(Secretary secretary) {
        secretary.setPassword("secretary");
        String encodedPassword = passwordEncoder.encode(secretary.getPassword());
        secretary.setPassword(encodedPassword);
        if (secretary.getRoletype() == null) {
            secretary.setRoletype(RoleType.valueOf("SECRETARY")); // ou un autre RoleType par défaut
        }
        return secretaryRepository.save(secretary);
    }

    public void deactivateSecretary(Long id) {
        Optional<Secretary> secretary = secretaryRepository.findById(id);
        if (secretary.isPresent()) {
            Secretary sec = secretary.get();
            sec.setActive(false);
            secretaryRepository.save(sec);
        }
    }

    public Secretary updateSecretary(Long id, Secretary secretaryDetails) {
        Optional<Secretary> optionalSecretary = secretaryRepository.findById(id);

        if (optionalSecretary.isPresent()) {
            Secretary secretary = optionalSecretary.get();
            if (secretaryDetails.getFirstname() != null) {
                secretary.setFirstname(secretaryDetails.getFirstname());
            }
            if (secretaryDetails.getLastname() != null) {
                secretary.setLastname(secretaryDetails.getLastname());
            }
            if (secretaryDetails.getUsername() != null) {
                secretary.setUsername(secretaryDetails.getUsername());
            }
            if (secretaryDetails.getPassword() != null) {
                secretary.setPassword(secretaryDetails.getPassword());
            }
            if (secretaryDetails.getPhoneNumber() != null) {
                secretary.setPhoneNumber(secretaryDetails.getPhoneNumber());
            }
            if (secretaryDetails.getBirthdate() != null) {
                secretary.setBirthdate(secretaryDetails.getBirthdate());
            }
            if (secretaryDetails.getEmail() != null) {
                secretary.setEmail(secretaryDetails.getEmail());
            }
            if (secretaryDetails.getCin() != null) {
                secretary.setCin(secretaryDetails.getCin());
            }
            if (secretaryDetails.isFirstLogin() != secretary.isFirstLogin()) {
                secretary.setFirstLogin(secretaryDetails.isFirstLogin());
            }
            return secretaryRepository.save(secretary);
        } else {
            return null;
        }
    }

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Secretary getSecretaryById(Long id) {
        return secretaryRepository.findById(id).orElse(null);
    }
}
