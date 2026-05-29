package com.ems.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ems.entity.User;

import lombok.Getter;

public class CustomUserDetails implements UserDetails {
    
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
            new SimpleGrantedAuthority("ROLE_"+user.getRole().name())
        );
    }

     @Override
    public String getPassword() {
        return user.getPassword();
    }

    /*
     * USERNAME
     * WE ARE USING EMAIL
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /*
     * ACCOUNT NON EXPIRED
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * ACCOUNT NON LOCKED
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
     * CREDENTIALS NON EXPIRED
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * ACCOUNT ENABLED
     */
    @Override
    public boolean isEnabled() {

        return user.getIsEmailVerified();
    }

}
