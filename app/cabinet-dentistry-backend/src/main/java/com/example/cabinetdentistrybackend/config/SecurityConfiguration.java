package com.example.cabinetdentistrybackend.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfiguration {



  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req ->
                    req
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers("/doctor-owner/**").hasAnyRole("DOCTOR_OWNER")
                            .requestMatchers("/doctor-assistant/**").hasAnyRole("DOCTOR_ASSISTANT","DOCTOR_OWNER")
                            .requestMatchers("/secretary/**").hasRole("DOCTOR_OWNER")
                            .requestMatchers("/patient1/**").hasAnyRole("SECRETARY","DOCTOR_OWNER")
                            .requestMatchers("/assistant/**").hasRole("DOCTOR_OWNER")
                            .requestMatchers("/appointments/**").hasAnyRole("PATIENT","SECRETARY","ASSISTANT","DOCTOR_OWNER")
                            .requestMatchers("/folders/**").hasAnyRole("SECRETARY","ASSISTANT","DOCTOR_OWNER")
                            .requestMatchers("/session-treatments/**").hasAnyRole("PATIENT","DOCTOR_OWNER")
                            .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout(logout ->
                    logout.logoutUrl("/logout")
                            .addLogoutHandler(logoutHandler)
                            .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
            )
    ;

    return http.build();
  }
}
