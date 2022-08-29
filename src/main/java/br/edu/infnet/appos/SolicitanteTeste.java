package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.SolicitanteController;
import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.model.domain.Solicitante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class SolicitanteTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(SolicitanteTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        try {
            Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
            SolicitanteController.adicionaSolicitante(s1, "Adicionado Solicitante 1");
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s2 = new Solicitante("Jojo Colonia", "(11) 11111-1111", false);
            SolicitanteController.adicionaSolicitante(s2, "Adicionado Solicitante 2");
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s3 = new Solicitante("Luna Luneta", "(21) 22222-2222", true);
            SolicitanteController.adicionaSolicitante(s3, "Adicionado Solicitante 3");
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s4 = new Solicitante(null, "(21) 22222-2222", true);
            SolicitanteController.adicionaSolicitante(s4, "Adicionado Solicitante 3");
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s5 = new Solicitante("", "(21) 22222-2222", true);
            SolicitanteController.adicionaSolicitante(s5, "Adicionado Solicitante 3");
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

    }
}
