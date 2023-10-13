package br.mic.financiamento_coletivo.repository;


import br.mic.financiamento_coletivo.model.Jogo;
import br.mic.financiamento_coletivo.model.Rifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long>
{
    // Adicione métodos personalizados de consulta, se necessário
    @Query("SELECT j FROM Jogo j WHERE j.fk_id_rifa = :fkIdRifa")
    List<Jogo> findByFkIdRifa(@Param("fkIdRifa") int fkIdRifa);
}

