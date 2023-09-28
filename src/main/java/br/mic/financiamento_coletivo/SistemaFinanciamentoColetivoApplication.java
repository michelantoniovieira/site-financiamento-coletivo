package br.mic.financiamento_coletivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.mic.financiamento_coletivo.model")
@EnableJpaRepositories("br.mic.financiamento_coletivo.repository")
@ComponentScan("br.mic.financiamento_coletivo")
public class SistemaFinanciamentoColetivoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaFinanciamentoColetivoApplication.class, args);
    }
}
