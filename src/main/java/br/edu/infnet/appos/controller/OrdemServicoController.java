package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.dto.OrdemServicoDto;
import br.edu.infnet.appos.model.service.OrdemServicoService;
import br.edu.infnet.appos.model.service.ServicoService;
import br.edu.infnet.appos.model.service.SolicitanteService;
import br.edu.infnet.appos.model.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {
    @Autowired OrdemServicoService ordemServicoService;
    @Autowired SolicitanteService solicitanteService;
    @Autowired VeiculoService veiculoService;
    @Autowired ServicoService servicoService;
    static Logger logger = LoggerFactory.getLogger(OrdemServicoController.class);

    @GetMapping
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        model.addAttribute("listagem", ordemServicoService.getOrdemServico(usuario));
        return "ordemServico/lista";
    }

    @GetMapping("{id}/excluir")
    public String  excluiOS(@PathVariable Integer id){
        logger.info("Excluir ordem de serviço {}", id);
        ordemServicoService.remove(id);
        return "redirect:/ordemServico";
    }
    @GetMapping("cadastro")
    public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario){
        model.addAttribute("solicitantes", solicitanteService.findAll(usuario));
        model.addAttribute("veiculos", veiculoService.findAll(usuario));
        model.addAttribute("listaServicos", servicoService.findAll(usuario));
        return "ordemServico/cadastro";
    }

    @PostMapping("cadastro")
    public String adicionaOS(OrdemServicoDto os, @SessionAttribute("usuario") Usuario usuario){
        System.out.println(usuario);
        os.setUsuario(usuario);
        ordemServicoService.addOrdemServico(os);
        return "redirect:/ordemServico";
    }

}
