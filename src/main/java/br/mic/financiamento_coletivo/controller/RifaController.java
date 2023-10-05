package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.service.RifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RifaController
{

    @Autowired
    private RifaService rifaService; // Suponha que você tenha um serviço para as rifas

    @GetMapping("/rifa")
    public String paginaRifa(Model model) {
        List<String> codigosRifa = rifaService.obterCodigosRifa(); // Obtém os códigos das rifas do serviço

        // Adicione a lista de códigos de rifas ao modelo
        model.addAttribute("codigosRifa", codigosRifa);

        // Adicione o objeto 'selectedRifa' ao modelo, mesmo que seja apenas um objeto vazio
        model.addAttribute("selectedRifa", new Rifa()); // Substitua 'Rifa' pelo nome da sua classe de rifa

        // Retorne o nome da sua página HTML (paginaRifa.html)
        return "rifa";
    }
}
