package com.example.learnspringbootsecurityjwt.service;

import com.example.learnspringbootsecurityjwt.model.Role;


public interface RoleService {
    Role findRoleByName(String roleName);
}
