package com.example.cabinetdentistrybackend.auditing;


import com.example.cabinetdentistrybackend.model.*;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            return Optional.of(((CustomUserDetails) principal).getUsername());
        } else if (principal instanceof DoctorOwner) {
            return Optional.of(((DoctorOwner) principal).getEmail()); // ou getUsername() si c'est approprié
        } else if (principal instanceof Secretary) {
            return Optional.of(((Secretary) principal).getEmail()); // ou getUsername() si c'est approprié
        } else if (principal instanceof DoctorAssistant) {
            return Optional.of(((DoctorAssistant) principal).getEmail()); // ou getUsername() si c'est approprié
        } else if (principal instanceof Patient) {
            return Optional.of(((Patient) principal).getEmail()); // ou getUsername() si c'est approprié
        } else if (principal instanceof Assistant) {
            return Optional.of(((Assistant) principal).getEmail()); // ou getUsername() si c'est approprié
        }

        return Optional.empty();
    }
}
