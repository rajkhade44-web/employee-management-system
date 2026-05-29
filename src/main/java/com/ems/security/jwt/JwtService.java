package com.ems.security.jwt;

import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.ems.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final String TYPE_ACCESS = "access";
    private static final String TYPE_REFRESH = "refresh";
    private static final String CLAIM_TOKEN_TYPE = "token_type";
    private static final String CLAIM_EMAIL = "email";
    private static final String CLAIM_ROLES = "roles";
    private static final String BEARER_PREFIX = "Bearer ";


    private final JwtProperties jwtProperties;
    private final SecretKey signingKey;

    public JwtService(SecretKey signKey, JwtProperties jwtProperties) {
        byte[] secretBytes = Decoders.BASE64.decode(jwtProperties.secret());
        this.signingKey = Keys.hmacShaKeyFor(secretBytes);
        this.jwtProperties = jwtProperties;
    }

    public String generateAccessToken(User user) {
        long nowMs = System.currentTimeMillis();
        long expMs = nowMs + (jwtProperties.accessTokenLifeCycleSeconds() * 1000L);
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(jwtProperties.issuer())
                .subject(user.getId().toString())
                .claim(CLAIM_EMAIL, user.getEmail())
                .claim(CLAIM_ROLES, user.getRole().name())
                .issuedAt(new Date(nowMs))
                .expiration(new Date(expMs))
                .signWith(signingKey)
                .compact();
    }
    
    public String generateRefreshToken(User user) {
        long nowMs = System.currentTimeMillis();
        long expMs = nowMs + (jwtProperties.refreshTokenTtlSeconds() * 1000L);
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(jwtProperties.issuer())
                .subject(user.getId().toString())
                .issuedAt(new Date(nowMs))
                .expiration(new Date(expMs))
                .signWith(signingKey)
                .compact();
    }
    
    public Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .requireIssuer(jwtProperties.issuer())
                    .verifyWith(signingKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("Invalid or expired jwt token: " + token);
        }
    }
    
    public String getEmailFromToken(String token) {
        return parseToken(token).get(CLAIM_EMAIL, String.class);
    }

    public Date getExpiredAtFromToken(String token) {
        return parseToken(token).getExpiration();
    }

    public boolean isAccessToken(String token) {
        return TYPE_ACCESS.equals(parseToken(token).get(CLAIM_TOKEN_TYPE, String.class));
    }

    public boolean isRefreshToken(String token) {
        return TYPE_REFRESH.equals(parseToken(token).get(CLAIM_TOKEN_TYPE, String.class));
    }

    public boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
