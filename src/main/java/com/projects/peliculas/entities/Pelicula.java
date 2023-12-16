package com.projects.peliculas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PELICULAS")
@Data
public class Pelicula implements Serializable {

    @Serial
    private static final long serialVersionUID = 1613353642718039833L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo no debe ser vacío.")
    private String nombre;

    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message= "El campo no es válido.")
    private Date fechaEstreno;

    @ManyToOne
    @NotNull(message= "El campo no es válido.")
    private Genero genero;

    @ManyToMany
    private List<Actor> protagonistas;

    private String imagen;
}
