package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Solicitante;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SolicitanteTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
        Solicitante s2 = new Solicitante("Solicitante 2", "(11) 11111-1111", false);
        Solicitante s3 = new Solicitante("Solicitante 3", "(21) 22222-2222", true);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
