package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Caminhao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CaminhaoTeste implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Caminhao c1 = new Caminhao("Baú", 1000.0f, 7.0f);
        Caminhao c2 = new Caminhao("Carreta", 2000.0f, 10.0f);
        Caminhao c3 = new Caminhao("Bitrem", 4000.0f, 12.0f);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
