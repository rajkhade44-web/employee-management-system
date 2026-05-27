package com.ems.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ems.enums.AccountStatus;
import com.ems.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "users",
    uniqueConstraints = { @UniqueConstraint(columnNames = "email") }
)
public class User extends BaseEntity{
    @Column(name = "full_name",length = 100,nullable = false)
    private String fullName;

    @Column(length = 150,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status",nullable = false)
    private AccountStatus accountStatus;

    @Column(name = "is_email_verified",nullable = false)
    private Boolean isEmailVerified = false;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}
