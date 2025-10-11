
package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permrole")
public class Permrole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roleName;

    private String description;

    // Default constructor
    public Permrole() {}

    // Parameterized constructor
    public Permrole(Long id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString method
    @Override
    public String toString() {
        return "Permrole [id=" + id + ", roleName=" + roleName + ", description=" + description + "]";
    }
}
