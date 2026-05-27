package com.ems.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name="email_verification_tokens")
public class EmailVerificationToken extends BaseEntity {

    @Column(nullable = false, unique = true, length = 255)
    private String token;

    @Column(name = "expry_time")
    private LocalDateTime expiryTime;

    @Column(nullable = false)
    private boolean verified = false;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
