package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrdemServicoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<Servico> servicos = new HashSet<>();
        servicos.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
        servicos.add(new Servico("Alinhamento", 1, new BigDecimal(200)));

        OrdemServico os = new OrdemServico(
                new Solicitante("Luna", "31999999999", true),
                new Carro("Sedan", true, 4),
                servicos
                );
        os.setMecanico("Adalberto");
        os.setGarantia(false);

        Set<Servico> servicos2 = new HashSet<>();

        servicos2.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));
        servicos2.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os2 = new OrdemServico(
                new Solicitante("Tiago", "71999999999", false),
                new Moto(125, "CG", 2),
                servicos2
                );
        os2.setMecanico("Lucas");
        os2.setGarantia(true);

        Set<Servico> servicos3 = new HashSet<>();

        servicos3.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos3.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
        servicos3.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));
        servicos3.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
        servicos3.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
        servicos3.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

        OrdemServico os3 = new OrdemServico(
                new Solicitante("Paulo", "51999999999", true),
                new Caminhao("Carreta", 20000, 30),
                servicos3);
        os3.setMecanico("Jairo");
        os3.setGarantia(false);

        System.out.println(os);
        System.out.println(os2);
        System.out.println(os3);
    }
}
