package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Solicitante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/solicitante")
public class SolicitanteController {
    private static Map<Integer, Solicitante> mapaSolicitante = new HashMap<>();
    private static Integer id = 1;
    @GetMapping
    public String telaLista(Model model){

        Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
        s1.setId(id++);
        mapaSolicitante.put(s1.getId(), s1);

        Solicitante s2 = new Solicitante("Tiago Alcantara", "(11) 11111-1111", false);
        s2.setId(id++);
        mapaSolicitante.put(s2.getId(), s2);

        Solicitante s3 = new Solicitante("Luna Luneta", "(21) 22222-2222", true);
        s3.setId(id++);
        mapaSolicitante.put(s3.getId(), s3);

        model.addAttribute("listagem", pegaLista());
        return "solicitante/lista";
    }

    private Collection<Solicitante> pegaLista(){
        return mapaSolicitante.values();
    }
}
