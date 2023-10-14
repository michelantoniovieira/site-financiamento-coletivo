package br.mic.financiamento_coletivo.repository;


import br.mic.financiamento_coletivo.model.Jogo;
import br.mic.financiamento_coletivo.model.Rifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>
{
    // Adicione métodos personalizados de consulta, se necessário
    @Query("SELECT j FROM Jogo j WHERE j.fk_id_rifa = :fk_id_rifa")
    List<Jogo> findByFkIdRifa(@Param("fk_id_rifa") int fk_id_rifa);

    //List<Jogo> findByTelefone(String numeroTelefone);

    @Query("SELECT j FROM Jogo j WHERE j.fk_id_rifa = :fk_id_rifa AND j.telefone = :telefone")
    List<Jogo> findByRifaIdAndTelefone(@Param("fk_id_rifa") int fk_id_rifa, @Param("telefone") String telefone);



}

