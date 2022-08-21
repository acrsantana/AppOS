package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Solicitante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/solicitante")
public class SolicitanteController {
    private static List<Solicitante> solicitantes;
    @GetMapping
    public String telaLista(Model model){
        solicitantes = new ArrayList<>();
        Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
        solicitantes.add(s1);
        Solicitante s2 = new Solicitante("Tiago Alcantara", "(11) 11111-1111", false);
        solicitantes.add(s2);
        Solicitante s3 = new Solicitante("Luna Luneta", "(21) 22222-2222", true);
        solicitantes.add(s3);
        model.addAttribute("listagem", solicitantes);
        return "solicitante/lista";
    }
}
