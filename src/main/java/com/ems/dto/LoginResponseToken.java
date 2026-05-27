package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseToken {
    private String accessToken;
    private String refreshToken;
}
