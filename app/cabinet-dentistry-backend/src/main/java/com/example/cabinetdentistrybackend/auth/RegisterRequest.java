package com.example.cabinetdentistrybackend.auth;

import com.example.cabinetdentistrybackend.model.Role;
import com.example.cabinetdentistrybackend.model.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest  {

  private String firstname;
  private String lastname;
  private String email;
  private String specialization;
  private String password;
  private RoleType roletype;



}
