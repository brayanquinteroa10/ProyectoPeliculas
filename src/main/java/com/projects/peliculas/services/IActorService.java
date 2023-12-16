package com.projects.peliculas.services;

import com.projects.peliculas.entities.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findAll();

    List<Actor> findActorsById(List<Long> ids);
}
