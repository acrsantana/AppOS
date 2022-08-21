package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.SolicitanteController;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class SolicitanteTeste implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
        Solicitante s2 = new Solicitante("Jojo Colonia", "(11) 11111-1111", false);
        Solicitante s3 = new Solicitante("Luna Luneta", "(21) 22222-2222", true);
        SolicitanteController.adicionaSolicitante(s1, "Adicionado Solicitante 1");
        SolicitanteController.adicionaSolicitante(s2, "Adicionado Solicitante 2");
        SolicitanteController.adicionaSolicitante(s3, "Adicionado Solicitante 3");
    }
}
