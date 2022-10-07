package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.VeiculoEmUsoException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.CarroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carro")
public class CarroController {

    static Logger logger = LoggerFactory.getLogger(CarroController.class);
    String mensagem;
    String tipo;
    boolean exibirMensagem = false;

    @Autowired
    private CarroService carroService;
    @GetMapping
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        logger.info("Buscando lista de carros");
        model.addAttribute("listagem", carroService.findAll(usuario));
        if (exibirMensagem){
            model.addAttribute("mensagem", mensagem);
            model.addAttribute("tipo", tipo);
            exibirMensagem = false;
        }
        return "carro/lista";
    }

    @GetMapping("{id}/excluir")
    public String excluiCarro(@PathVariable Integer id, Model model){
        logger.info("Excluir carro {}", id);
        try {
            carroService.delete(id);
        } catch (VeiculoEmUsoException e) {
            exibirMensagem = true;
            mensagem = e.getMessage();
            tipo = "alert-danger";
            logger.error(e.getMessage());
        }

        return "redirect:/carro";
    }

    @GetMapping("cadastro")
    public String telaCadastro(){
        return "carro/cadastro";
    }
    @PostMapping("cadastro")
    public String adicionar(Carro carro, @SessionAttribute("usuario") Usuario usuario){
        carro.setUsuario(usuario);
        logger.info("Adicionando o carro {} ao banco de dados", carro.getMarca() + " " + carro.getModelo());
        carroService.add(carro);
        return "redirect:/carro";
    }
}
