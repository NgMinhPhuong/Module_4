package com.codegym.practicesecurity.service;

import com.codegym.practicesecurity.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends UserDetailsService {

}
