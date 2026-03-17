package com.example.demo.repository;

import com.example.demo.model.SuperHeroe;

import java.util.List;
import java.util.Optional;

public interface SuperHeroeRepository {
    void save (SuperHeroe s);
    Optional<SuperHeroe> findById(String id);
    List<SuperHeroe> listAll();
}
