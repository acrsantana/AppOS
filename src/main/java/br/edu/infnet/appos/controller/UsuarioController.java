package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.UsuarioJaCadastradoException;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping()
    public String listar(Model model){
        logger.info("Buscando usuários cadastrados");
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/lista";
    }

    @GetMapping("/cadastro")
    public String paginaCadastro(){
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(HttpServletRequest request) {
        try {
            logger.info("Inserindo usuário no banco de dados");
            usuarioService.cadastrar(request);
            return "redirect:/";
        } catch (UsuarioJaCadastradoException e) {
             logger.error(e.getMessage());
             return "usuario/cadastro";
        }

    }
}
