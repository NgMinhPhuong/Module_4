package com.codegym.dosecuritybymyself.service.impl;

import com.codegym.dosecuritybymyself.dto.UserDetailDTO;
import com.codegym.dosecuritybymyself.model.User;
import com.codegym.dosecuritybymyself.model.UserRole;
import com.codegym.dosecuritybymyself.repository.IUserRepository;
import com.codegym.dosecuritybymyself.repository.IUserRoleRepository;
import com.codegym.dosecuritybymyself.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService implements IUserDetailService {
    private IUserRepository iUserRepository;

    private IUserRoleRepository iUserRoleRepository;


    public UserDetailService(IUserRepository iUserRepository, IUserRoleRepository iUserRoleRepository) {
        this.iUserRepository = iUserRepository;
        this.iUserRoleRepository = iUserRoleRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 = iUserRepository.findByUsername(username);
        List<UserRole> userRoles = iUserRoleRepository.findAllByUser(user1.getId());
        UserDetailDTO userDetailDTO = new UserDetailDTO(user1, userRoles);
        return userDetailDTO;

    }
}
