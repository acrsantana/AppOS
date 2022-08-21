package br.edu.infnet.appos.controller;

import br.edu.infnet.appos.model.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    private static Map<Integer, OrdemServico> mapaOS = new HashMap<>();
    private static Integer id = 1;
    private static List osList;

    @GetMapping
    public String telaLista(Model model){

        List<Servico> servicos = new ArrayList<>();
        servicos.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos.add(new Servico("Alinhamento", 1, new BigDecimal(200)));

        OrdemServico os = new OrdemServico(
                new Solicitante("Cezão da Bahia", "(71) 99999-9999", true),
                new Carro("Sedan", true, 4),
                servicos
        );
        os.setMecanico("Adalberto");
        os.setGarantia(false);
        os.setId(id++);
        mapaOS.put(os.getId(), os);

        List<Servico> servicos2 = new ArrayList<>();

        servicos2.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os2 = new OrdemServico(
            new Solicitante("Tiago Alcantara", "(11) 11111-1111", false),
                new Moto(125, "CG", 2),
                servicos2
        );
        os2.setMecanico("Lucas");
        os2.setGarantia(true);

        os2.setId(id++);
        mapaOS.put(os2.getId(), os2);

        List<Servico> servicos3 = new ArrayList<>();

        servicos3.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos3.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
        servicos3.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os3 = new OrdemServico(
            new Solicitante("Luna Luneta", "(21) 22222-2222", true),
                new Caminhao("Carreta", 20000, 30),
                servicos3);
        os3.setMecanico("Jairo");
        os3.setGarantia(false);

        os3.setId(id++);
        mapaOS.put(os3.getId(), os3);

        model.addAttribute("listagem", pegaLista());

        return "ordemServico/lista";
    }

    private Collection<OrdemServico> pegaLista(){
        return mapaOS.values();
    }
}
