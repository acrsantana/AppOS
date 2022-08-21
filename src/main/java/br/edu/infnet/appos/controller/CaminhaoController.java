package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Veiculo;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {

    private static Map<Integer, Caminhao> mapaCaminhao = new HashMap<>();
    private static Integer id = 1;
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "caminhao/lista";
    }
    public static void adicionaCaminhao(Caminhao caminhao, String mensagem){
        caminhao.setId(id++);
        mapaCaminhao.put(caminhao.getId(), caminhao);
        AppImpressao.relatorio(caminhao, mensagem);
    }

    private Collection<Caminhao> pegaLista(){
        return mapaCaminhao.values();
    }
}
