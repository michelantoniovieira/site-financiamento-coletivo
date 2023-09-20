package br.mic.financiamento_coletivo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RifaController
{


    @GetMapping("/index")
    public String listar()
    {
        return "index";
    }
}
