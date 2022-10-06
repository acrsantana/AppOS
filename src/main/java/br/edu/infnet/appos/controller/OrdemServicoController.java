package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.OrdemServico;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {
    @Autowired OrdemServicoService ordemServicoService;
    @Autowired SolicitanteService solicitanteService;
    @Autowired VeiculoService veiculoService;
    @Autowired ServicoService servicoService;
    static Logger logger = LoggerFactory.getLogger(OrdemServicoController.class);

    @GetMapping
    public String telaLista(Model model){
        model.addAttribute("listagem", ordemServicoService.getOrdemServico());
        return "ordemServico/lista";
    }

    @GetMapping("{id}/excluir")
    public String  excluiOS(@PathVariable Integer id){
        logger.info("Excluir ordem de serviço {}", id);
        ordemServicoService.remove(id);
        return "redirect:/ordemServico";
    }
    @GetMapping("cadastro")
    public String telaCadastro(Model model){
        model.addAttribute("solicitantes", solicitanteService.findAll());
        model.addAttribute("veiculos", veiculoService.findAll());
        model.addAttribute("listaServicos", servicoService.findAll());
        return "ordemServico/cadastro";
    }

    @PostMapping("cadastro")
    public String adicionaOS(OrdemServicoDto os){
        ordemServicoService.addOrdemServico(os);
        return "redirect:/ordemServico";
    }

}
