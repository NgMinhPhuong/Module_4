package com.codegym.testjpamanytomany.repository;

import com.codegym.testjpamanytomany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
