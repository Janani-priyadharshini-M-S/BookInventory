
package com.example.bookInventory.repository;

import com.example.bookInventory.entity.Permrole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermroleRepository extends JpaRepository<Permrole, Long> {
    Permrole findByRoleName(String roleName);
}
