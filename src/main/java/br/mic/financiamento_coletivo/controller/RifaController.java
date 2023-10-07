package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.service.RifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RifaController
{

    @Autowired
    private RifaService rifaService; // Suponha que você tenha um serviço para as rifas

    @GetMapping("/rifa")
    public String paginaRifa(@RequestParam(name = "id_rifa", required = false) Integer id_rifa, Model model) {
        List<String> codigosRifa = rifaService.obterCodigosRifa(); // Obtém os códigos das rifas do serviço
        model.addAttribute("codigosRifa", codigosRifa);

        if (id_rifa != null) {
            Rifa rifa = rifaService.obterRifaPorId(id_rifa);
            model.addAttribute("rifa", rifa);
        } else {
            // Adicione um objeto vazio Rifa ao modelo
            model.addAttribute("rifa", new Rifa()); // Substitua 'Rifa' pelo nome da sua classe de rifa
        }

        // Adicione o objeto 'selectedRifa' ao modelo, mesmo que seja apenas um objeto vazio
        model.addAttribute("selectedRifa", new Rifa()); // Substitua 'Rifa' pelo nome da sua classe de rifa

        return "rifa";
    }

}
