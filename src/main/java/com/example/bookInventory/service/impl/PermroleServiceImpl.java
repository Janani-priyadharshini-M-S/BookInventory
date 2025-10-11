
package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.Permrole;
import com.example.bookInventory.repository.PermroleRepository;
import com.example.bookInventory.service.PermroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermroleServiceImpl implements PermroleService {

    @Autowired
    private PermroleRepository permroleRepository;

    @Override
    public List<Permrole> getAllPermroles() {
        return permroleRepository.findAll();
    }

    @Override
    public Permrole getPermroleById(Long id) {
        return permroleRepository.findById(id).orElse(null);
    }

    @Override
    public Permrole addPermrole(Permrole permrole) {
        Permrole existing = permroleRepository.findByRoleName(permrole.getRoleName());
        if (existing != null) {
            return null;
        }
        return permroleRepository.save(permrole);
    }

    @Override
    public Permrole updatePermrole(Long id, Permrole updatedPermrole) {
        Permrole existing = permroleRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRoleName(updatedPermrole.getRoleName());
            existing.setDescription(updatedPermrole.getDescription());
            return permroleRepository.save(existing);
        }
        return null;
    }

    @Override
    public Permrole getPermroleByRoleName(String roleName) {
        return permroleRepository.findByRoleName(roleName);
    }
}
