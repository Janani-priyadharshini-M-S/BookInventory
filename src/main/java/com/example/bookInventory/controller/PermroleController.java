
package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Permrole;
import com.example.bookInventory.service.PermroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/permrole")
public class PermroleController {

    @Autowired
    private PermroleService permroleService;

    // GET all permroles
    @GetMapping("/all")
    public ResponseEntity<List<Permrole>> getAllPermroles() {
        return ResponseEntity.ok(permroleService.getAllPermroles());
    }

    // GET permrole by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPermroleById(@PathVariable Long id) {
        Permrole role = permroleService.getPermroleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "NOTFOUND",
                "message", "Perm Role not found"
            ));
        }
    }

    // POST add new permrole
    @PostMapping("/add")
    public ResponseEntity<?> addPermrole(@RequestBody Permrole permrole) {
        Permrole result = permroleService.addPermrole(permrole);

        if (result != null) {
            return ResponseEntity.ok(Map.of(
                "code", "POSTSUCCESS",
                "message", "Perm\nRole added\nsuccessfully"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of(
                "code", "ADDFAILS",
                "message", "Perm\nRole already exist"
            ));
        }
    }

    // PUT update permrole by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePermrole(@PathVariable Long id, @RequestBody Permrole updatedPermrole) {
        Permrole role = permroleService.updatePermrole(id, updatedPermrole);

        if (role != null) {
            return ResponseEntity.ok(Map.of(
                "code", "UPDATESUCCESS",
                "message", "Perm Role updated successfully"
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "UPDATEFAILS",
                "message", "Perm Role not found"
            ));
        }
    }
}
