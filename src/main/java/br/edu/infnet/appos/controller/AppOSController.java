package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@SessionAttributes("usuario")
@Controller
@RequestMapping("/")
public class AppOSController {

    Logger logger = LoggerFactory.getLogger(AppOSController.class);
    @Autowired
    UsuarioService usuarioService;

    Usuario usuario;

    @GetMapping
    public String telaHome(){
        return "home";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/login")
    public String autorizar(Model model, @RequestParam String email, @RequestParam String password) {
        try {
            usuario = usuarioService.findByEmail(email);
            if (usuario.getPassword().equals(password))
                model.addAttribute("usuario", usuario);
            else {
                logger.error("Senha inválida");
                usuario.setNome("");
                model.addAttribute("usuario", usuario);
                return "login";
            }

        } catch (NoSuchElementException e) {
            logger.error("Usuário não encontrado: {}", email);
            return "login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        usuario.setNome("");
        model.addAttribute("usuario", usuario);
        return "redirect:/";
    }

    @ModelAttribute("usuario")
    public Usuario getUsuario() {
        return new Usuario();
    }
}
