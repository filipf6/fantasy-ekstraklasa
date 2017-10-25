package com.pk.fantasyekstraklasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FantasyEkstraklasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyEkstraklasaApplication.class, args);
	}
}
