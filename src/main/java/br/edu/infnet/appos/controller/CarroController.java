package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carro")
public class CarroController {
    private static List<Carro> carros;
    @GetMapping
    public String telaLista(Model model){
        carros = new ArrayList<>();
        Carro c1 = new Carro("Coupe", true, 2);
        c1.setMarca("Tesla");
        c1.setModelo("Model S");
        c1.setAnoFabricacao(2021);
        carros.add(c1);

        Carro c2 = new Carro("SUV", true, 4);
        c2.setMarca("Mercedez Benz");
        c2.setModelo("G63 AMG");
        c2.setAnoFabricacao(2022);
        carros.add(c2);

        Carro c3 = new Carro("Sedan", true, 4);
        c3.setMarca("Audi");
        c3.setModelo("A4");
        c3.setAnoFabricacao(2015);
        carros.add(c3);

        model.addAttribute("listagem", carros);
        return "carro/lista";
    }
}
