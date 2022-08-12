package br.edu.infnet.appos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @GetMapping
    public String telaLista(){
        return "carro/lista";
    }
}
