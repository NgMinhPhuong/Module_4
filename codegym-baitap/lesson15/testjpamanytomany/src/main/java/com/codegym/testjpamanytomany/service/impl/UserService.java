package com.codegym.testjpamanytomany.service.impl;

import com.codegym.testjpamanytomany.model.User;
import com.codegym.testjpamanytomany.repository.IUserRepository;
import com.codegym.testjpamanytomany.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).get();
    }
}
