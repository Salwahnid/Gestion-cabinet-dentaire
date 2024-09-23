package com.example.cabinetdentistrybackend.auth;

import com.example.cabinetdentistrybackend.config.JwtService;
import com.example.cabinetdentistrybackend.model.*;
import com.example.cabinetdentistrybackend.repository.*;
import com.example.cabinetdentistrybackend.token.Token;
import com.example.cabinetdentistrybackend.token.TokenRepository;
import com.example.cabinetdentistrybackend.token.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PatientRepository patientRepository;
    private final DoctorOwnerRepository doctorOwnerRepository;
    private final DoctorAssistantRepository doctorAssistantRepository;
    private final AssistantRepository assistantRepository;
    private final SecretaryRepository secretaryRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        BaseUser user;
        switch (request.getRoletype()) {
            case DOCTOR_OWNER:
                user = new DoctorOwner(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getRoletype(),
                        request.getSpecialization()
                );
                break;
            case PATIENT:
                user = new Patient(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getRoletype()
                );
                break;
            case DOCTOR_ASSISTANT:
                user = new DoctorAssistant(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getRoletype(),
                        request.getSpecialization()

                );
                break;
            case ASSISTANT:
                user = new Assistant(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getRoletype()
                );
                break;
            case SECRETARY:
                user = new Secretary(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getRoletype()
                );
                break;

            default:
                throw new IllegalArgumentException("Invalid role type");
        }

        BaseUser savedUser = saveUser(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        BaseUser user = findUserByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private BaseUser saveUser(BaseUser user) {
        if (user instanceof DoctorOwner) {
            return doctorOwnerRepository.save((DoctorOwner) user);
        } else if (user instanceof Patient) {
            return patientRepository.save((Patient) user);
        }
        // Ajoutez des cas pour DoctorAssistant, Secretary, etc.
        throw new IllegalArgumentException("Unknown user type");
    }

    private BaseUser findUserByEmail(String email) {
        BaseUser user = doctorOwnerRepository.findByEmail(email).orElse(null);
        if (user == null) {
            user = patientRepository.findByEmail(email).orElse(null);
        }        if (user == null) {
            user = assistantRepository.findByEmail(email).orElse(null);
        }        if (user == null) {
            user = doctorAssistantRepository.findByEmail(email).orElse(null);
        }        if (user == null) {
            user = secretaryRepository.findByEmail(email).orElse(null);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    private void saveUserToken(BaseUser user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(BaseUser user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            BaseUser user = findUserByEmail(userEmail);
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
