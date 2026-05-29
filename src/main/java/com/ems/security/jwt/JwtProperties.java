package com.ems.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.jwt")
public record JwtProperties(
    String secret,
    String issuer,
    long accessTokenLifeCycleSeconds,
    long refreshTokenTtlSeconds,
    String refreshCookieName,
    boolean cookieHttpOnly,
    boolean cookieSecure,
    String cookieSameSite,
    String cookieDomain
) {

}
