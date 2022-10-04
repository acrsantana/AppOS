package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.model.domain.*;
import br.edu.infnet.appos.model.dto.OrdemServicoDto;
import br.edu.infnet.appos.model.service.OrdemServicoService;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {
    @Autowired OrdemServicoService ordemServicoService;
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

    public String adicionaOS(OrdemServico os){
        ordemServicoService.addOrdemServico(os);
        return "redirect:/ordemServico";
    }

}
