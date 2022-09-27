package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller @RequestMapping("/solicitante") public class SolicitanteController {

    @Autowired SolicitanteService solicitanteService;
    static Logger logger = LoggerFactory.getLogger(SolicitanteController.class);

    @GetMapping public String telaLista(Model model) {
        List<Solicitante> solicitantes = solicitanteService.findAll();
        model.addAttribute("listagem", solicitantes);
        return "solicitante/lista";
    }

    @GetMapping("/cadastro")
    public String telaCadastro(){
        return "solicitante/cadastro";
    }
    @PostMapping("/cadastro") public String cadastrar(@RequestParam String nome, @RequestParam String telefone, @RequestParam boolean vip) {
        logger.info("Inserindo solicitante no banco de dados");
        try {
            solicitanteService.add(new Solicitante(nome, telefone, vip));
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }
        return "redirect:/solicitante";
    }

    @GetMapping("{id}/excluir") public String excluiSolicitante(@PathVariable String id) {
        logger.info("Excluir solicitante {}", id);
        solicitanteService.delete(Integer.parseInt(id));
        return "redirect:/solicitante";
    }

}
