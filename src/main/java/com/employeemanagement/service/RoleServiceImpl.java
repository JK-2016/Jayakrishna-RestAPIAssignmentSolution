package com.employeemanagement.service;

import com.employeemanagement.dao.RoleRepository;
import com.employeemanagement.dao.entity.Role;

public class RoleServiceImpl {
    private RoleRepository roleRepository;
    public Role addRole(Role role){

        return roleRepository.save(role);
    }

}
