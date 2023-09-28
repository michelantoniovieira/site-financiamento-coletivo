package br.mic.financiamento_coletivo.repository;

import br.mic.financiamento_coletivo.model.Rifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RifaRepository extends JpaRepository<Rifa, Integer> {
    // Métodos do repositório, se houver
}
