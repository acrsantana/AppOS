package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MotoTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Moto m1 = new Moto(125, "Scooter", 2);
        m1.setMarca("Honda");
        m1.setModelo("PCX");
        m1.setAnoFabricacao(2020);

        Moto m2 = new Moto(600, "Cafe Racer", 2);
        m2.setMarca("Kawasaki");
        m2.setModelo("Ninja");
        m2.setAnoFabricacao(2020);

        Moto m3 = new Moto(1000, "Super Esportiva", 2);
        m3.setMarca("Honda");
        m3.setModelo("CBR");
        m3.setAnoFabricacao(2020);

        AppImpressao.relatorio(m1, "Moto 1");
        AppImpressao.relatorio(m2, "Moto 2");
        AppImpressao.relatorio(m3, "Moto 3");
    }
}
