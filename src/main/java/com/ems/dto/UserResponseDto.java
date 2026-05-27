package com.ems.dto;

import com.ems.enums.AccountStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private AccountStatus accountStatus;
}
