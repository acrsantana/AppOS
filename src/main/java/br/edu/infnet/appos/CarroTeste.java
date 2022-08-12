package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CarroTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Carro c1 = new Carro("Coupe", true, 2);
        c1.setMarca("Tesla");
        c1.setModelo("Model S");
        c1.setAnoFabricacao(2021);

        Carro c2 = new Carro("SUV", true, 4);
        c2.setMarca("Mercedez Benz");
        c2.setModelo("G63 AMG");
        c2.setAnoFabricacao(2022);

        Carro c3 = new Carro("Sedan", true, 4);
        c3.setMarca("Audi");
        c3.setModelo("A4");
        c3.setAnoFabricacao(2015);

        AppImpressao.relatorio(c1, "Carro 1");
        AppImpressao.relatorio(c2, "Carro 2");
        AppImpressao.relatorio(c3, "Carro 3");

    }
}
