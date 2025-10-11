
package com.example.bookInventory.service;

import com.example.bookInventory.entity.Permrole;

import java.util.List;

public interface PermroleService {
    List<Permrole> getAllPermroles();
    Permrole getPermroleById(Long id);
    Permrole addPermrole(Permrole permrole);
    Permrole updatePermrole(Long id, Permrole updatedPermrole);
    Permrole getPermroleByRoleName(String roleName);
}
