package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.service.CarroService;
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
@RequestMapping("/carro")
public class CarroController {

    static Logger logger = LoggerFactory.getLogger(CarroController.class);

    @Autowired
    private CarroService carroService;
    @GetMapping
    public String telaLista(Model model){

        model.addAttribute("listagem", carroService.findAll());
        return "carro/lista";
    }

    @GetMapping("{id}/excluir")
    public RedirectView excluiCarro(@PathVariable Integer id){
        logger.info("Excluir carro {}", id);
        carroService.delete(id);
        return new RedirectView("/carro");
    }

    @GetMapping("cadastro")
    public String telaCadastro(){
        return "carro/cadastro";
    }
    @PostMapping("cadastro")
    public String adicionar(HttpServletRequest request){
        carroService.add(request);
        return "redirect:/carro";
    }
}
