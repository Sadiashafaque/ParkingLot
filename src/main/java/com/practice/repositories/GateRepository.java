package com.practice.repositories;

import com.practice.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    Map<Long, Gate> gates = new HashMap<Long, Gate>();

    public Optional<Gate> findGateById(long id) {
        if(gates.containsKey(id))
        {
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }
}
