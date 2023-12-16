package com.projects.peliculas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "GENEROS")
@Data
public class Genero implements Serializable {

    @Serial
    private static final long serialVersionUID= -3289978933086042812L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
