package com.projects.peliculas.services;

import com.projects.peliculas.dao.IPeliculaRepository;
import com.projects.peliculas.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    private final IPeliculaRepository peliculaRepository;

    public PeliculaService(IPeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public void save(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula findById(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) peliculaRepository.findAll();
    }
}
