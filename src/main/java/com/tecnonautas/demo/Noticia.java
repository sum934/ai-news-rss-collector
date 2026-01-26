package com.tecnonautas.demo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "noticias",
    indexes = {
        @Index(name = "idx_noticia_link", columnList = "link"),
        @Index(name = "idx_noticia_data_publicacao", columnList = "data_publicacao")
    })
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @Column(nullable = false, unique = true)
    private String link;
    private String fonte;
    @Column(nullable = false)
    private LocalDateTime dataPublicacao;

    @ElementCollection
    @CollectionTable(name = "noticia_keywords", joinColumns = @JoinColumn(name = "noticia_id"))
    @Column(name = "keyword")

    private List<String> keywords;

    private LocalDateTime createdAt;

    public Noticia() { }

    public Noticia(String titulo, String link, String fonte){
        this.titulo = titulo;
        this.link = link;
        this.fonte = fonte;
    }

    public String getTitulo() {
        return titulo;
    }
     public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
