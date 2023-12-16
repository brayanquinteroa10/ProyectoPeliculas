package com.projects.peliculas.dao;

import com.projects.peliculas.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {

}
