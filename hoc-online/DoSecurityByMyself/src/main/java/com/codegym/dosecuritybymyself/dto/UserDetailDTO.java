package com.codegym.dosecuritybymyself.dto;

import com.codegym.dosecuritybymyself.model.User;
import com.codegym.dosecuritybymyself.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailDTO implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserDetailDTO(User user, List<UserRole> userRoles){
        username = user.getUsername();
        password = user.getPassword();
        userRoles.forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        });
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
