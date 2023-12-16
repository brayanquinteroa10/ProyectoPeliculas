package com.projects.peliculas.services;

import com.projects.peliculas.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {
    void save(Pelicula pelicula);

    Pelicula findById(Long id);

    void delete(Long id);

    List<Pelicula> findAll();
}
