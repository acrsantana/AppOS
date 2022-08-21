package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/moto")
public class MotoController {
    Logger logger = LoggerFactory.getLogger(MotoController.class);
    private static Map<Integer, Moto> mapaMoto = new HashMap<>();
    private static Integer id = 1;

    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "moto/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiMoto(@PathVariable Integer id){
        logger.info("Excluir moto {}", id);
        mapaMoto.remove(id);
        return new RedirectView("/moto");
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
