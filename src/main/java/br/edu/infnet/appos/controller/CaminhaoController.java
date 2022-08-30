package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Veiculo;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {

    private static Map<Integer, Caminhao> mapaCaminhao = new HashMap<>();
    private static Integer id = 1;
    static Logger logger = LoggerFactory.getLogger(CaminhaoController.class);
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "caminhao/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiCaminhao(@PathVariable Integer id){
        logger.info("Excluir caminhão {}", id);
        mapaCaminhao.remove(id);
        return new RedirectView("/caminhao");
    }

    public static void adicionaCaminhao(Caminhao caminhao, String mensagem){
        caminhao.setId(id++);
        mapaCaminhao.put(caminhao.getId(), caminhao);
        try {
            AppImpressao.relatorio(caminhao, mensagem);
        } catch (ProblemasNaLeituraDoArquivoException e) {
            logger.error(e.getMessage());
        }
    }

    private Collection<Caminhao> pegaLista(){
        return mapaCaminhao.values();
    }
}
