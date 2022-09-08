package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.SolicitanteController;
import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class SolicitanteTeste implements ApplicationRunner {

    @Autowired
    SolicitanteService solicitanteService;
    Logger logger = LoggerFactory.getLogger(SolicitanteTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        try {
            Solicitante s1 = new Solicitante("Cezão da Bahia", "(71) 99999-9999", true);
            solicitanteService.add(s1);
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s2 = new Solicitante("Jojo Colonia", "(11) 11111-1111", false);
            solicitanteService.add(s2);
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s3 = new Solicitante("Luna Luneta", "(21) 22222-2222", true);
            solicitanteService.add(s3);
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s4 = new Solicitante(null, "(21) 22222-2222", true);
            solicitanteService.add(s4);
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

        try {
            Solicitante s5 = new Solicitante("", "(21) 22222-2222", true);
            solicitanteService.add(s5);
        } catch (NomeNaoPreenchidoException e) {
            logger.error(e.getMessage());
        }

    }
}
