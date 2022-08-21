package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Moto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/moto")
public class MotoController {

    private static List<Moto> motos;

    @GetMapping
    public String telaLista(Model model){
        motos = new ArrayList<>();

        Moto m1 = new Moto(125, "Scooter", 2);
        m1.setMarca("Honda");
        m1.setModelo("PCX");
        m1.setAnoFabricacao(2020);
        motos.add(m1);

        Moto m2 = new Moto(600, "Cafe Racer", 2);
        m2.setMarca("Kawasaki");
        m2.setModelo("Ninja");
        m2.setAnoFabricacao(2020);
        motos.add(m2);

        Moto m3 = new Moto(1000, "Super Esportiva", 2);
        m3.setMarca("Honda");
        m3.setModelo("CBR");
        m3.setAnoFabricacao(2020);
        motos.add(m3);

        model.addAttribute("listagem", motos);
        return "moto/lista";
    }
}
