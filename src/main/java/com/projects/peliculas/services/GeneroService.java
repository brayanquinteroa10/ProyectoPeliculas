package com.projects.peliculas.services;

import com.projects.peliculas.dao.IGeneroRepository;
import com.projects.peliculas.entities.Genero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService{

    private final IGeneroRepository generoRepository;

    public GeneroService(IGeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public void save(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }
}
