package br.mic.financiamento_coletivo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RifaController
{

    @GetMapping("/rifa")
    public String rifaPage()
    {
        return "rifa";
    }
}
