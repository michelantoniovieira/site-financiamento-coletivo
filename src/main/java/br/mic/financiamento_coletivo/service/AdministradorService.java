package br.mic.financiamento_coletivo.service;

import br.mic.financiamento_coletivo.model.Administrador;
import br.mic.financiamento_coletivo.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService
{

    @Autowired
    private AdministradorRepository administradorRepository;

    public boolean verificarCredenciais(String email, String senha) {
        // Consulta o usuário pelo nome de usuário (username)
        Administrador usuario = administradorRepository.findByEmail(email);

        if (usuario != null) {
            // Verifica se a senha fornecida corresponde à senha armazenada no usuário
            return usuario.getSenha().equals(senha);
        }

        // Caso o usuário não seja encontrado, retorna false
        return false;
    }

    public Administrador buscarUsuarioPorLogin(String email) {
        return administradorRepository.findByEmail(email);
    }
}