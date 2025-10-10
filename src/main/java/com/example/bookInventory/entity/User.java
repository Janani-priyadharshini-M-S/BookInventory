package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "LastName", length = 30)
    private String lastName;

    @Column(name = "FirstName", length = 20)
    private String firstName;

    @Column(name = "PhoneNumber", length = 14)
    private String phoneNumber;

    @Column(name = "UserName", length = 30)
    private String userName;

    @Column(name = "Password", length = 30)
    private String password;

    @Column(name = "RoleNumber")
    private Integer roleNumber;

    // Constructors
    public User() {}

    public User(Integer userId, String lastName, String firstName, String phoneNumber,
                String userName, String password, Integer roleNumber) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.roleNumber = roleNumber;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(Integer roleNumber) {
        this.roleNumber = roleNumber;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName +
               ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password +
               ", roleNumber=" + roleNumber + "]";
    }
}
