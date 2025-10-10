package com.example.bookInventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class State {

    @Id
    @Column(name = "state_code", length = 2) // restrict to 2 characters
    private String stateCode;

    @Column(name = "state_name")
    private String stateName;

    // Getters and Setters
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}