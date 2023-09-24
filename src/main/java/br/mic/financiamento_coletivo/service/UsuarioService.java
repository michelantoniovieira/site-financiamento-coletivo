package br.mic.financiamento_coletivo.service;

import br.mic.financiamento_coletivo.model.Usuario;
import br.mic.financiamento_coletivo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean verificarCredenciais(String email, String senha) {
        // Consulta o usuário pelo nome de usuário (username)
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            // Verifica se a senha fornecida corresponde à senha armazenada no usuário
            return usuario.getSenha().equals(senha);
        }

        // Caso o usuário não seja encontrado, retorna false
        return false;
    }

    public Usuario buscarUsuarioPorLogin(String email) {
        return usuarioRepository.findByEmail(email);
    }
}