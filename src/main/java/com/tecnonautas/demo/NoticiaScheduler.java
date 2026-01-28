package com.tecnonautas.demo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Component
public class NoticiaScheduler {

    private final NoticiaRepository repository;

    private final List<FeedSource> feeds = List.of(
        new FeedSource(
            "https://www.inovacaotecnologica.com.br/boletim/rss.xml",
            "Inovação Tecnológica"
        ),
        new FeedSource(
            "https://techcrunch.com/feed/",
            "TechCrunch"
        )
    );

    public NoticiaScheduler(NoticiaRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 0 6,12,18,23 * * *")
    public void atualizarNoticias() {
        System.out.println("Iniciando ciclo de atualização de notícias");

        for (FeedSource feed : feeds) {
            processarFeed(feed);
        }

        System.out.println("Ciclo de atualização finalizado");
    }

    public void processarFeed(FeedSource feedSource) {
        try {
            URL feedUrl = new URL(feedSource.getUrl());
            System.out.println("Processando feed: " + feedSource.getFonte());

            SyndFeed feed = new SyndFeedInput().build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {

                if (repository.findByLink(entry.getLink()).isEmpty()) {

                    Noticia noticia = new Noticia();
                    noticia.setTitulo(entry.getTitle());
                    noticia.setLink(entry.getLink());
                    noticia.setFonte(feedSource.getFonte());

                    if (entry.getPublishedDate() != null) {
                        noticia.setDataPublicacao(
                            entry.getPublishedDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                        );
                    } else {
                        noticia.setDataPublicacao(
                            LocalDateTime.now(ZoneId.of("UTC"))
                        );
                    }

                    noticia.setKeywords(
                        List.of("ia", "machine learning", "artificial intelligence")
                    );

                    noticia.setCreatedAt(
                        LocalDateTime.now(ZoneId.of("UTC"))
                    );

                    repository.save(noticia);
                }
            }

            System.out.println("Notícias atualizadas com sucesso!");

        } catch (FeedException | IOException | IllegalArgumentException e) {
            System.err.println(
                "Erro ao processar feed " + feedSource.getFonte() + ": " + e.getMessage()
            );
        }
    }
}