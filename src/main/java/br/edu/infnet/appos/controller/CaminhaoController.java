package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Veiculo;
import br.edu.infnet.appos.model.service.CaminhaoService;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {

    @Autowired
    CaminhaoService caminhaoService;
    static Logger logger = LoggerFactory.getLogger(CaminhaoController.class);
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", caminhaoService.findAll());
        return "caminhao/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiCaminhao(@PathVariable Integer id){
        logger.info("Excluir caminhão {}", id);
        caminhaoService.delete(id);
        return new RedirectView("/caminhao");
    }

    @GetMapping("/cadastro")
    public String telaCadastro(){
        return "caminhao/cadastro";
    }
    @PostMapping("/cadastro") public String cadastrar(HttpServletRequest request) {
        logger.info("Inserindo solicitante no banco de dados");
        caminhaoService.add(request);
        return "redirect:/caminhao";
    }

}
