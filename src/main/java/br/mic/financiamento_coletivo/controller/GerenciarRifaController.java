package br.mic.financiamento_coletivo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GerenciarRifaController
{
    @GetMapping("/gerenciarRifa")
    public String getenciarRifaPage()
    {
        return "gerenciarRifa";
    }
}
