package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.MotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/moto")
public class MotoController {
    static Logger logger = LoggerFactory.getLogger(MotoController.class);

    @Autowired
    private MotoService motoService;

    @GetMapping
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        logger.info("Buscando lista de motos");
        model.addAttribute("listagem", motoService.findAll(usuario));
        return "moto/lista";
    }

    @GetMapping("{id}/excluir")
    public String excluiMoto(@PathVariable Integer id){
        logger.info("Excluir moto {}", id);
        motoService.delete(id);
        return "redirect:/moto";
    }

    @GetMapping("/cadastro")
    public String telaCadastro(){
        return "moto/cadastro";
    }

    @PostMapping("/cadastro") public String cadastrar(Moto moto, @SessionAttribute("usuario") Usuario usuario) {
        moto.setUsuario(usuario);
        logger.info("Inserindo solicitante no banco de dados");
        motoService.add(moto);
        return "redirect:/moto";
    }
}
