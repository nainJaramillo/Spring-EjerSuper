package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroe {
    private String id;
    private String nombre;
    private String apodo;
    private Franquicia franquicia;
    private int poder;

}
