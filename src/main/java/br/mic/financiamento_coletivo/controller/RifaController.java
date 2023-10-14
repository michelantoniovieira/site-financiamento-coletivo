package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Jogo;
import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.repository.JogoRepository;
import br.mic.financiamento_coletivo.service.RifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RifaController
{

    @Autowired
    private RifaService rifaService; // Suponha que você tenha um serviço para as rifas
    @Autowired
    private JogoRepository jogoRepository; // Injete o JogoRepository para acessar os jogos

    @GetMapping("/rifa")
    public String paginaRifa(@RequestParam(name = "id_rifa", required = false) Integer id_rifa, Model model)
    {
        List<String> codigosRifa = rifaService.obterCodigosRifa();
        model.addAttribute("codigosRifa", codigosRifa);

        if (id_rifa != null)
        {
            Rifa rifa = rifaService.obterRifaPorId(id_rifa);
            model.addAttribute("rifa", rifa);

            List<Integer> numerosSelecionados = rifaService.obterNumerosSelecionados(id_rifa);
            model.addAttribute("numerosSelecionados", numerosSelecionados);
        } else
        {
            model.addAttribute("rifa", new Rifa());
        }

        model.addAttribute("selectedRifa", new Rifa());

        return "rifa";
    }

/*
    @RestController
    @RequestMapping("/consultar-jogo")
    public class ConsultarJogoController {
        @Autowired
        private JogoRepository jogoRepository;

        @GetMapping
        public List<Jogo> consultarNumerosPorTelefone(@RequestParam("telefone") String numeroTelefone) {
            List<Jogo> jogos = jogoRepository.findByTelefone(numeroTelefone);
            return jogos;
        }
    }
 */

    @RestController
    @RequestMapping("/consultar-jogo")
    public class ConsultarJogoController {
        @Autowired
        private JogoRepository jogoRepository;

        @GetMapping
        public List<Jogo> consultarNumerosPorTelefone(@RequestParam("fk_id_rifa") int fk_id_rifa, @RequestParam("telefone") String numeroTelefone) {
            List<Jogo> jogos = jogoRepository.findByRifaIdAndTelefone(fk_id_rifa, numeroTelefone);
            return jogos;
        }
    }
}
