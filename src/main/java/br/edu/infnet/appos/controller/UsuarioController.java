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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String cadastrar(Usuario usuario) {
        try {
            logger.info("Inserindo usuário {} no banco de dados", usuario.getNome());
            usuarioService.cadastrar(usuario);
            return "redirect:/";
        } catch (UsuarioJaCadastradoException e) {
             logger.error(e.getMessage());
             return "usuario/cadastro";
        }

    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        usuarioService.delete(id);
        return "redirect:/usuario";

    }
}
