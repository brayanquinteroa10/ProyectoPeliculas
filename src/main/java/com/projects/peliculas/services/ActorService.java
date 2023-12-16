package com.projects.peliculas.services;

import com.projects.peliculas.dao.IActorRepository;
import com.projects.peliculas.entities.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public List<Actor> findActorsById(List<Long> ids) {
        return (List<Actor>) actorRepository.findAllById(ids);
    }
}
