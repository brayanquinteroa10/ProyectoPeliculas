package com.projects.peliculas.dao;

import com.projects.peliculas.entities.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor, Long> {
}
