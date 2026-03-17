package com.example.demo.Service;

import com.example.demo.exceptions.DuplicadoException;
import com.example.demo.exceptions.NoEncontradoException;
import com.example.demo.model.SuperHeroe;
import com.example.demo.repository.SuperHeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class SuperHeroesServiceImpl {

    @Autowired
    private SuperHeroeRepository superHeroeRepository;

    public SuperHeroesServiceImpl(SuperHeroeRepository superHeroeRepository) {
        this.superHeroeRepository = superHeroeRepository;
    }
    public void registrarSuperheroe(SuperHeroe s){
        if (s.getNombre() == null || s.getNombre().isBlank()){
            throw new IllegalArgumentException("Null/Vacio");
        }
        if (superHeroeRepository.findById(s.getId()).isEmpty()){
            throw new NoEncontradoException("No encontrado");
        }
        if (superHeroeRepository.findById(s.getId()).isPresent()){
            throw new DuplicadoException("Duplicado");
        }
        superHeroeRepository.save(s);
    }
    public void buscarPorFranquicia(String franquicia){
        if (franquicia== null || franquicia.isBlank()){
            throw new IllegalArgumentException("Franquicia vacia");
        }
        Optional<SuperHeroe> lista= superHeroeRepository.findById(franquicia);

        if (lista.isEmpty()){
            throw new NoEncontradoException("No hay superhéroes de esa franquicia");
        }
    }
    public void buscarPorNombre(SuperHeroe s){

        if (s.getNombre() == null || s.getNombre().isBlank()) {
            throw new IllegalArgumentException("Nombre vacío");
        }
        Optional<SuperHeroe> encontrado = superHeroeRepository.findById(s.getNombre());
        if (encontrado.isEmpty()) {
            throw new NoEncontradoException("No encontrado");
        }
    }
}
