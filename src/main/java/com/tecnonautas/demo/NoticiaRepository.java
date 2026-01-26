package com.tecnonautas.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    Optional<Noticia> findByLink(String link);
}

