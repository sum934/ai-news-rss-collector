package com.tecnonautas.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticiaController {
    
    private final NoticiaRepository repository;

    public NoticiaController(NoticiaRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/noticias")
    public List<Noticia> getNoticias() {
        return repository.findAll();
    }
}