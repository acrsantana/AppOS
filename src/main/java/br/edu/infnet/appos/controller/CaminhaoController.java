package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.CaminhaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {

    @Autowired
    CaminhaoService caminhaoService;
    static Logger logger = LoggerFactory.getLogger(CaminhaoController.class);
    String mensagem;
    String tipo;
    boolean exibirMensagem = false;
    @GetMapping
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        logger.info("Buscando lista de caminhões");
        model.addAttribute("listagem", caminhaoService.findAll(usuario));
        if (exibirMensagem){
            model.addAttribute("mensagem", mensagem);
            model.addAttribute("tipo", tipo);
            exibirMensagem = false;
        }
        return "caminhao/lista";
    }

    @GetMapping("{id}/excluir")
    public String excluiCaminhao(@PathVariable Integer id){
        logger.info("Excluir caminhão {}", id);
        try {
            caminhaoService.delete(id);
        }catch (VeiculoEmUsoException e){
            exibirMensagem = true;
            mensagem = e.getMessage();
            tipo = "alert-danger";
            logger.error(e.getMessage());
        }
        return "redirect:/caminhao";
    }

    @GetMapping("/cadastro")
    public String telaCadastro(){
        return "caminhao/cadastro";
    }
    @PostMapping("/cadastro") public String cadastrar(Caminhao caminhao, @SessionAttribute("usuario") Usuario usuario) {
        caminhao.setUsuario(usuario);
        logger.info("Inserindo o caminhão {} no banco de dados", caminhao.getMarca() + " " + caminhao.getModelo());
        caminhaoService.add(caminhao);
        return "redirect:/caminhao";
    }

}
