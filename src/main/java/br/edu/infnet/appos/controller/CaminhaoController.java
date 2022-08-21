package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Caminhao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {

    public static List<Caminhao> caminhoes;
    @GetMapping
    public String telaLista(Model model){
        caminhoes = new ArrayList<>();

        Caminhao c1 = new Caminhao("Baú", 1000.0f, 7.0f);
        c1.setMarca("Mercedez Benz");
        c1.setModelo("Refrigerado");
        c1.setAnoFabricacao(2020);
        caminhoes.add(c1);

        Caminhao c2 = new Caminhao("Carreta", 2000.0f, 10.0f);
        c2.setMarca("Hyundai");
        c2.setModelo("Aberto");
        c2.setAnoFabricacao(2022);
        caminhoes.add(c2);

        Caminhao c3 = new Caminhao("Bitrem", 4000.0f, 12.0f);
        c3.setMarca("Volkswagen");
        c3.setModelo("Super");
        c3.setAnoFabricacao(2010);
        caminhoes.add(c3);

        model.addAttribute("listagem", caminhoes);
        return "caminhao/lista";
    }
}
