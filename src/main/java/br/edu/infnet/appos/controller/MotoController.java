package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/moto")
public class MotoController {

    private static Map<Integer, Moto> mapaMoto = new HashMap<>();
    private static Integer id = 1;

    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "moto/lista";
    }

    public static void adicionaMoto(Moto moto, String mensagem){
        moto.setId(id++);
        mapaMoto.put(moto.getId(), moto);
        AppImpressao.relatorio(moto, mensagem);
    }

    private Collection<Moto> pegaLista(){
        return mapaMoto.values();
    }
}
