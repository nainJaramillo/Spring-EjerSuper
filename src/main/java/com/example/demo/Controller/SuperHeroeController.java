package com.example.demo.Controller;

import com.example.demo.Service.SuperHeroesService;

@Controller
public class SuperHeroeController {
    @AutoWired
    private SuperHeroesService superHeroesService;
    @GetMapping("/superheroes")
}
