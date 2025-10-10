package com.example.bookInventory.service;

import java.util.List;
import com.example.bookInventory.entity.State;

public interface StateService {
    boolean addState(State state);
    List<State> getAllState();
    State getStateByCode(String code);
    State updateStateName(String code, String name);
}
