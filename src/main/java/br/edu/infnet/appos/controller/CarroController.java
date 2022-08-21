package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/carro")
public class CarroController {
    private static Map<Integer, Carro> mapaCarro = new HashMap<>();
    private static Integer id = 1;
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "carro/lista";
    }

    public static void adicionaCarro(Carro carro, String mensagem){
        carro.setId(id++);
        mapaCarro.put(carro.getId(), carro);

        AppImpressao.relatorio(carro, mensagem);
    }

    private Collection<Carro> pegaLista(){
        return mapaCarro.values();
    }
}
