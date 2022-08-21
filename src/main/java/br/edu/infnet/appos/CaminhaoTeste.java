package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.CaminhaoController;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CaminhaoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Caminhao c1 = new Caminhao("Baú", 1000.0f, 7.0f);
        c1.setMarca("Mercedez Benz");
        c1.setModelo("Refrigerado");
        c1.setAnoFabricacao(2020);
        CaminhaoController.adicionaCaminhao(c1, "Caminhão 1");

        Caminhao c2 = new Caminhao("Carreta", 2000.0f, 10.0f);
        c2.setMarca("Hyundai");
        c2.setModelo("Aberto");
        c2.setAnoFabricacao(2022);
        CaminhaoController.adicionaCaminhao(c2, "Caminhão 2");

        Caminhao c3 = new Caminhao("Bitrem", 4000.0f, 12.0f);
        c3.setMarca("Volkswagen");
        c3.setModelo("Super");
        c3.setAnoFabricacao(2010);
        CaminhaoController.adicionaCaminhao(c3, "Caminhão 3");
    }
}
