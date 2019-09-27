package com.example.learnspringbootsecurityjwt.service.impl;

import com.example.learnspringbootsecurityjwt.model.Role;
import com.example.learnspringbootsecurityjwt.repository.RoleRepository;
import com.example.learnspringbootsecurityjwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
