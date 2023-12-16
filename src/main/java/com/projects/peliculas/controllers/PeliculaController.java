package com.projects.peliculas.controllers;

import com.projects.peliculas.entities.Pelicula;
import com.projects.peliculas.services.IActorService;
import com.projects.peliculas.services.IArchivoService;
import com.projects.peliculas.services.IGeneroService;
import com.projects.peliculas.services.IPeliculaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class PeliculaController {

    private final IPeliculaService peliculaService;
    private final IGeneroService generoService;
    private final IActorService actorService;
    private final IArchivoService archivoService;

    public PeliculaController(IPeliculaService peliculaService, IGeneroService generoService, IActorService actorService, IArchivoService archivoService) {
        this.peliculaService = peliculaService;
        this.generoService = generoService;
        this.actorService = actorService;
        this.archivoService = archivoService;
    }

    @GetMapping("/pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Nueva película");
        return "pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String editar(@PathVariable(name = "id") Long id, Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Editar película");
        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name = "ids") String ids, Model model, @RequestParam("archivo") MultipartFile imagen) {

        if (br.hasErrors()) {
            model.addAttribute("generos", generoService.findAll());
            model.addAttribute("actores", actorService.findAll());
            model.addAttribute("titulo", "Nueva película");
            return "pelicula";
        }

        if(!imagen.isEmpty()){
            String archivo = pelicula.getNombre() + getExtension(imagen.getOriginalFilename());
            pelicula.setImagen(archivo);
            try {
                archivoService.guardar(archivo, imagen.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            pelicula.setImagen("_default.jpg");
        }

        List<Long> idsActores;
        if (!ids.isEmpty()) {
            idsActores = Arrays.stream(ids.split(","))
                    .filter(str -> !str.isEmpty())
                    .map(Long::parseLong)
                    .toList();
        } else {
            model.addAttribute("error", "Se requiere al menos un ID de actor.");
            model.addAttribute("generos", generoService.findAll());
            model.addAttribute("actores", actorService.findAll());
            model.addAttribute("titulo", "Nueva película");
            return "pelicula";
        }
        pelicula.setProtagonistas(actorService.findActorsById(idsActores));
        peliculaService.save(pelicula);
        return "redirect:home";
    }

    @GetMapping({"/", "/home", "/index"})
    public String home(Model model) {
        model.addAttribute("peliculas", peliculaService.findAll());
        model.addAttribute("msj", "La app está en mantenimiento.");
        model.addAttribute("tipoMsj", "danger");
        return "home";
    }

    private String getExtension(String archivo){
        return archivo.substring(archivo.lastIndexOf("."));
    }

}
