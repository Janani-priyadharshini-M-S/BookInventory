package com.example.bookInventory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.State;
import com.example.bookInventory.repository.StateRepository;
import com.example.bookInventory.service.StateService;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public boolean addState(State state) {
        // Validate state code length before saving
        if (state.getStateCode().length() > 2) {
            throw new IllegalArgumentException("State code must be 2 characters or less.");
        }

        // Check if state already exists
        if (stateRepository.existsById(state.getStateCode())) {
            return false;
        }

        stateRepository.save(state);
        return true;
    }

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public State getStateByCode(String code) {
        return stateRepository.findById(code).orElse(null);
    }

    @Override
    public State updateStateName(String code, String name) {
        State state = stateRepository.findById(code).orElse(null);
        if (state != null) {
            state.setStateName(name);
            return stateRepository.save(state);
        }
        return null;
    }
}