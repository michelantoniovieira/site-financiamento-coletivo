package br.mic.financiamento_coletivo.repository;


import br.mic.financiamento_coletivo.model.Jogo;
import br.mic.financiamento_coletivo.model.Rifa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long>
{
    // Adicione métodos personalizados de consulta, se necessário
    List<Jogo> findByRifa(Rifa rifa);
}

