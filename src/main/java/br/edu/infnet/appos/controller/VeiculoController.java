package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired VeiculoService veiculoService;
    static Logger logger = LoggerFactory.getLogger(VeiculoController.class);
    String mensagem;
    String tipo;
    boolean exibirMensagem = false;
    @GetMapping
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        logger.info("Buscando lista de veículos");
        model.addAttribute("listagem", veiculoService.findAll(usuario));
        if (exibirMensagem){
            model.addAttribute("mensagem", mensagem);
            model.addAttribute("tipo", tipo);
            exibirMensagem = false;
        }
        return "veiculo/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluir(@PathVariable Integer id){
        logger.info("Excluir veículo {}", id);
        try {
            veiculoService.delete(id);
        } catch (VeiculoEmUsoException e) {
            exibirMensagem = true;
            mensagem = e.getMessage();
            tipo = "alert-danger";
            logger.error(e.getMessage());
        }
        return new RedirectView("/veiculo");
    }

}
