package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.SolicitanteEmUsoException;
import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Usuario;
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
    String mensagem;
    String tipo;
    boolean exibirMensagem = false;
    @GetMapping public String telaLista(Model model, @SessionAttribute("usuario")Usuario usuario) {
        List<Solicitante> solicitantes = solicitanteService.findAll(usuario);
        model.addAttribute("listagem", solicitantes);
        if (exibirMensagem){
            model.addAttribute("mensagem", mensagem);
            model.addAttribute("tipo", tipo);
            exibirMensagem = false;
        }
        return "solicitante/lista";
    }

    @GetMapping("/cadastro")
    public String telaCadastro(){
        return "solicitante/cadastro";
    }
    @PostMapping("/cadastro") public String cadastrar(Solicitante solicitante, @SessionAttribute("usuario")Usuario usuario) {
        solicitante.setUsuario(usuario);
        logger.info("Inserindo solicitante {} no banco de dados", solicitante.getNome());
        solicitanteService.add(solicitante);
        return "redirect:/solicitante";
    }

    @GetMapping("{id}/excluir") public String excluiSolicitante(@PathVariable String id) {
        logger.info("Excluir solicitante {}", id);
        try {
            solicitanteService.delete(Integer.parseInt(id));
        } catch (SolicitanteEmUsoException e) {
            exibirMensagem = true;
            mensagem = e.getMessage();
            tipo = "alert-danger";
            logger.error(e.getMessage());
        }
        return "redirect:/solicitante";
    }

}
