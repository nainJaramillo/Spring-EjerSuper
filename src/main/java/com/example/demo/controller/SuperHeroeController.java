package com.example.demo.controller;

import com.example.demo.Service.SuperHeroesServiceImpl;
import com.example.demo.model.SuperHeroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperHeroeController {
    @Autowired
    private SuperHeroesServiceImpl superHeroesServiceImpl;
    @PostMapping("/SuperHeroes/guardar")
    public String saveHero(@ModelAttribute SuperHeroe superHeroe, Model model){
        model.addAttribute("Guardar Heroe", superHeroe);
        return "SuperHeroes";
    }

    @GetMapping("/SuperHeroes/{nombre}")
    public String listadoHeroes(Model model, @PathVariable("nombre") String nombre){
        model.addAttribute("title", "lista heroes, name:" + nombre );
        return "listadoHeroes";
    }

}
