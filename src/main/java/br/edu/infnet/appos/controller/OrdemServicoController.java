package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {
    private static List osList;

    @GetMapping
    public String telaLista(Model model){
        osList = new ArrayList<>();

        Set<Servico> servicos = new HashSet<>();
        servicos.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos.add(new Servico("Alinhamento", 1, new BigDecimal(200)));

        OrdemServico os = new OrdemServico(
                new Solicitante("Luna", "31999999999", true),
                new Carro("Sedan", true, 4),
                servicos
        );
        os.setMecanico("Adalberto");
        os.setGarantia(false);
        osList.add(os);

        Set<Servico> servicos2 = new HashSet<>();

        servicos2.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os2 = new OrdemServico(
                new Solicitante("Tiago", "71999999999", false),
                new Moto(125, "CG", 2),
                servicos2
        );
        os2.setMecanico("Lucas");
        os2.setGarantia(true);

        osList.add(os2);

        Set<Servico> servicos3 = new HashSet<>();

        servicos3.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos3.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
        servicos3.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os3 = new OrdemServico(
                new Solicitante("Paulo", "51999999999", true),
                new Caminhao("Carreta", 20000, 30),
                servicos3);
        os3.setMecanico("Jairo");
        os3.setGarantia(false);

        osList.add(os3);

        model.addAttribute("listagem", osList);

        return "ordemServico/lista";
    }
}
