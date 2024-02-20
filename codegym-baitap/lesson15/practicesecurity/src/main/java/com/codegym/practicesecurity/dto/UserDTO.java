package com.codegym.practicesecurity.dto;

import com.codegym.practicesecurity.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDTO implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> roles = new ArrayList<>();

    public UserDTO(User user){
        username = user.getUsername();
        password = user.getPassword();
        user.getRoles().forEach(role -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });
    }

    public UserDTO(){}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
