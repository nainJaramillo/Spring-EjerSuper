package com.example.demo.Service;

import com.example.demo.Exceptions.DuplicadoException;
import com.example.demo.Exceptions.NoEncontradoException;
import com.example.demo.Model.SuperHeroe;
import com.example.demo.Repository.SuperHeroeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroesService {
    private final SuperHeroeRepository superHeroeRepository;

    public SuperHeroesService(SuperHeroeRepository superHeroeRepository) {
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
