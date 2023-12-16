package com.projects.peliculas.services;

import com.projects.peliculas.entities.Genero;

import java.util.List;

public interface IGeneroService {
    void save(Genero genero);

    Genero findById(Long id);

    void delete(Long id);

    List<Genero> findAll();

}
