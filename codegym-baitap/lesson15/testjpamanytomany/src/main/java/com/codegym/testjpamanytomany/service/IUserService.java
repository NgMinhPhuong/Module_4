package com.codegym.testjpamanytomany.service;

import com.codegym.testjpamanytomany.model.User;

public interface IUserService {
    User findById(Long id);
}
