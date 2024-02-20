package com.codegym.dosecuritybymyself.repository;

import com.codegym.dosecuritybymyself.model.User;
import com.codegym.dosecuritybymyself.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query(value = "select * from user_role where user_id = ?1", nativeQuery = true)
    List<UserRole> findAllByUser(Long user_id);
}
