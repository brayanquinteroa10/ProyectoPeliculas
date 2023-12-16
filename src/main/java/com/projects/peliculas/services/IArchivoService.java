package com.projects.peliculas.services;


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;

public interface IArchivoService {

    void guardar(String archivo, InputStream bytes);

    void eliminar(String archivo);

    ResponseEntity<Resource> get(String archivo);
}
