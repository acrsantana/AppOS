package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired VeiculoService veiculoService;
    static Logger logger = LoggerFactory.getLogger(VeiculoController.class);
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", veiculoService.findAll());
        return "veiculo/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluir(@PathVariable Integer id){
        logger.info("Excluir veículo {}", id);
        veiculoService.delete(id);
        return new RedirectView("/veiculo");
    }

}
