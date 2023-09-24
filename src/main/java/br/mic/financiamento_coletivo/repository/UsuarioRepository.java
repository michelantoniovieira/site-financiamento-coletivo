package br.mic.financiamento_coletivo.repository;

import br.mic.financiamento_coletivo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>
{
    Usuario findByEmail(String email);
}
