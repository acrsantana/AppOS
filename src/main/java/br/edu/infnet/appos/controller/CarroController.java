package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Carro;
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
@RequestMapping("/carro")
public class CarroController {

    static Logger logger = LoggerFactory.getLogger(CarroController.class);
    private static Map<Integer, Carro> mapaCarro = new HashMap<>();
    private static Integer id = 1;
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", pegaLista());
        return "carro/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiCarro(@PathVariable Integer id){
        logger.info("Excluir carro {}", id);
        mapaCarro.remove(id);
        return new RedirectView("/carro");
    }

    public static void adicionaCarro(Carro carro, String mensagem){
        carro.setId(id++);
        mapaCarro.put(carro.getId(), carro);

        try {
            AppImpressao.relatorio(carro, mensagem);
        } catch (ProblemasNaLeituraDoArquivoException e) {
            logger.error(e.getMessage());
        }
    }

    private Collection<Carro> pegaLista(){
        return mapaCarro.values();
    }
}
