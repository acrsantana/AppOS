package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.*;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    Logger logger = LoggerFactory.getLogger(OrdemServicoController.class);
    private static Map<Integer, OrdemServico> mapaOS = new HashMap<>();
    private static Integer id = 1;

    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "ordemServico/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiOS(@PathVariable Integer id){
        logger.info("Excluir ordem de serviço {}", id);
        mapaOS.remove(id);
        return new RedirectView("/ordemServico");
    }

    public static void adicionaOS(OrdemServico os, String mensagem){
        os.setId(id++);
        mapaOS.put(os.getId(), os);
        AppImpressao.relatorio(os, mensagem);
    }

    private Collection<OrdemServico> pegaLista(){
        return mapaOS.values();
    }
}
