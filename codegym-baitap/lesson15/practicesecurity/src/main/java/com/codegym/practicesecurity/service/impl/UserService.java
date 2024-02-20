package com.codegym.practicesecurity.service.impl;

import com.codegym.practicesecurity.dto.UserDTO;
import com.codegym.practicesecurity.model.User;
import com.codegym.practicesecurity.repository.IUserRepository;
import com.codegym.practicesecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username).get();
        UserDTO userDTO = new UserDTO(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDTO, null, userDTO.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return userDTO;
    }
}
