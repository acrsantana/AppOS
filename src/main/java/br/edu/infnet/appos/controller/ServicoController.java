package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.service.ServicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servico")
public class ServicoController {

    static Logger logger = LoggerFactory.getLogger(ServicoController.class);

    @Autowired
    private ServicoService servicoService;
    @GetMapping
    public String telaLista(Model model){
        logger.info("Buscando lista de serviços");
        model.addAttribute("listagem", servicoService.findAll());
        return "servico/lista";
    }

    @GetMapping("{id}/excluir")
    public String excluiCarro(@PathVariable Integer id){
        logger.info("Excluir serviço {}", id);
        servicoService.delete(id);
        return "redirect:/servico";
    }

    @GetMapping("cadastro")
    public String telaCadastro(){
        return "servico/cadastro";
    }
    @PostMapping("cadastro")
    public String adicionar(Servico servico){
        logger.info("Adicionando o serviço {} ao banco de dados", servico.getNomeServico());
        servicoService.add(servico);
        return "redirect:/servico";
    }

}
