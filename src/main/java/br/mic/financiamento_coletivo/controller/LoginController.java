package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Usuario;
import br.mic.financiamento_coletivo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, @RequestParam("senha") String senha, RedirectAttributes redirectAttributes, HttpSession session)
    {
        boolean autenticacaoValida = usuarioService.verificarCredenciais(email, senha);

        if (autenticacaoValida) {
            // Autenticação bem-sucedida
            Usuario usuario = usuarioService.buscarUsuarioPorLogin(email);

            // Define o ID do usuário na sessão para ser acessado posteriormente
            session.setAttribute("idUsuario", usuario.getId());
            session.setAttribute("emailUsuario", usuario.getEmail());

            // Define o ID do usuário no campo hidden do formulário
            redirectAttributes.addFlashAttribute("idUsuario", usuario.getId());

            // Redireciona para a página principal
            return "redirect:/gerenciarRifa";
        }
        else
        {
            // Autenticação falhou, redireciona de volta para a página de login com uma mensagem de erro
            redirectAttributes.addFlashAttribute("erro", "Credenciais inválidas. Tente novamente.");
            return "redirect:/login";
        }
    }
}
