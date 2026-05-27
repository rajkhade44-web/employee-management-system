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
@Table(name="password_reset_tokens")
public class PasswordResetToken extends BaseEntity {
    @Column(nullable = false,unique = true,length = 255)
    private String token;

    @Column(name = "expiry_time", nullable = false)
    private LocalDateTime expiryTime;

    @Column(nullable = false)
    private Boolean used = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user; 
}
