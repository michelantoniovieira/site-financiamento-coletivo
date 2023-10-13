package br.mic.financiamento_coletivo.repository;


import br.mic.financiamento_coletivo.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long>
{
    // Métodos de consulta personalizados, se necessário
}
