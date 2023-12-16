package com.projects.peliculas.controllers;

import com.projects.peliculas.services.IArchivoService;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArchivoController {
    private final IArchivoService archivoService;

    public ArchivoController(IArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    @GetMapping("/archivo")
    public ResponseEntity<Resource> get(@RequestParam("n") String archivo){
        return archivoService.get(archivo);
    }
}
