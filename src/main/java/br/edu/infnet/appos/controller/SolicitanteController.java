package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/solicitante")
public class SolicitanteController {

    Logger logger = LoggerFactory.getLogger(SolicitanteController.class);
    private static Map<Integer, Solicitante> mapaSolicitante = new HashMap<>();
    private static Integer id = 1;
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "solicitante/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiSolicitante(@PathVariable Integer id){
        logger.info("Excluir solicitante {}", id);
        mapaSolicitante.remove(id);
        return new RedirectView("/solicitante");
    }

    private Collection<Solicitante> pegaLista(){
        return mapaSolicitante.values();
    }
    public static void adicionaSolicitante(Solicitante solicitante, String mensagem){
        solicitante.setId(id++);
        mapaSolicitante.put(solicitante.getId(), solicitante);
        AppImpressao.relatorio(solicitante, mensagem);
    }
}
