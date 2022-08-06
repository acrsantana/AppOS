package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Carro;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CarroTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Carro c1 = new Carro("Coupe", true, 2);
        Carro c2 = new Carro("SUV", true, 4);
        Carro c3 = new Carro("Sedan", true, 4);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
