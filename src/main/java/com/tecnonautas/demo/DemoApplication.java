package com.tecnonautas.demo;

import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    @PostConstruct
        @SuppressWarnings("unused")
    void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

	@Bean
        @SuppressWarnings("unused")
    CommandLineRunner run(NoticiaScheduler scheduler) {
        return args -> {
            System.out.println("Populando notícias iniciais...");
            scheduler.atualizarNoticias();
        };
    }

}
