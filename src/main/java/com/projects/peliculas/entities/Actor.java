package com.projects.peliculas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ACTORES")
@Data
public class Actor implements Serializable {

    @Serial
    private static final long serialVersionUID = 655559342282613694L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "url_imagen")
    private String urlImagen;


}
