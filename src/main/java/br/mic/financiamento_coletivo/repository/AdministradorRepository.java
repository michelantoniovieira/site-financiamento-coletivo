package br.mic.financiamento_coletivo.repository;

import br.mic.financiamento_coletivo.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Integer>
{
    Administrador findByEmail(String email);
}
