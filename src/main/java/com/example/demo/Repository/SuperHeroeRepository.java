package com.example.demo.Repository;

import com.example.demo.Model.SuperHeroe;

import java.util.List;
import java.util.Optional;

public interface SuperHeroeRepository {
    void save (SuperHeroe s);
    Optional<SuperHeroe> findById(String id);
    List<SuperHeroe> listAll();
}
