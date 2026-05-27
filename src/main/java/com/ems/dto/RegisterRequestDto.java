package com.ems.dto;

import com.ems.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
