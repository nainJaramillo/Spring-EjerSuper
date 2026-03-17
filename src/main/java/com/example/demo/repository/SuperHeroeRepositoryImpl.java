package com.example.demo.repository;

import com.example.demo.model.SuperHeroe;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SuperHeroeRepositoryImpl implements SuperHeroeRepository{
   private Map<String, SuperHeroe> datos= new HashMap<>();
    @Override
    public void save(SuperHeroe s) {
        datos.put(s.getId(), s);
    }

    @Override
    public Optional<SuperHeroe> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    @Override
    public List<SuperHeroe> listAll() {
        return new ArrayList<>(datos.values());
    }
}
