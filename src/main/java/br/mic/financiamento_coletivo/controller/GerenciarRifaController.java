package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.repository.RifaRepository;
import br.mic.financiamento_coletivo.service.RifaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class GerenciarRifaController {
    private final RifaService rifaService;
    private final RifaRepository rifaRepository;

    @Autowired
    public GerenciarRifaController(RifaService rifaService, RifaRepository rifaRepository) {
        this.rifaService = rifaService;
        this.rifaRepository = rifaRepository;
    }

    @GetMapping("/gerenciarRifa")
    public String gerenciarRifaPage() {
        return "gerenciarRifa";
    }

    @PostMapping("/gerenciarRifa")
    public String cadastrarRifa(@RequestParam("preco") BigDecimal preco,
                                @RequestParam("premio") String premio,
                                @RequestParam("regulamento") String regulamento,
                                @RequestParam("quantidade_numeros_rifa") int quantidade_numeros_rifa,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {
        // Crie um objeto Rifa com os parâmetros recebidos
        Rifa novaRifa = new Rifa(preco, premio, regulamento, quantidade_numeros_rifa);

        // Chame um serviço ou repositório para salvar a nova rifa no banco de dados
        rifaService.salvarRifa(novaRifa); // Supondo que você tenha um serviço chamado rifaService

        // Redirecione para a página principal
        return "redirect:/gerenciarRifa";
    }

    @GetMapping("/criarRifa")
    public String criarRifaPage() {
        return "criarRifa";
    }

    @GetMapping("/listarRifa")
    public String listarRifaPage(Model model) {
        List<Rifa> rifas = rifaRepository.findAll();
        model.addAttribute("rifas", rifas);
        return "listarRifa"; // Nome da página HTML
    }
}
