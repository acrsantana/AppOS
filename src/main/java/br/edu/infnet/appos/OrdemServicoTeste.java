package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.OrdemServicoController;
import br.edu.infnet.appos.exceptions.*;
import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.test.AppImpressao;
import br.edu.infnet.appos.model.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Order(5)
public class OrdemServicoTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(OrdemServicoTeste.class);

    @Override
    public void run(ApplicationArguments args) {

        try {
            List<Servico> servicos = new ArrayList<>();
            servicos.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
            servicos.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
            OrdemServico os = new OrdemServico(
                    new Solicitante("Luna", "31999999999", true),
                    new Carro("Sedan", true, 4),
                    servicos);
            os.setMecanico("Adalberto");
            os.setGarantia(false);

            OrdemServicoController.adicionaOS(os, "Adicionada O.S. 1");
        } catch (PedidoInvalidoException | NomeNaoPreenchidoException | QuantidadePortasInvalidasException e) {
            logger.info(e.getMessage());
        }

        try {
            List<Servico> servicos2 = new ArrayList<>();

            servicos2.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

            OrdemServico os2 = new OrdemServico(new Solicitante("Tiago", "71999999999", false), new Moto(125, "CG", 2), servicos2);
            os2.setMecanico("Lucas");
            os2.setGarantia(true);

            OrdemServicoController.adicionaOS(os2, "Adicionada O.S. 2");
        } catch (PedidoInvalidoException | NomeNaoPreenchidoException | QuantidadePassageirosInvalidaException e) {
            logger.info(e.getMessage());
        }

        try {
            List<Servico> servicos3 = new ArrayList<>();

            servicos3.add(new Servico("Troca de óleo", 1, new BigDecimal(100)));
            servicos3.add(new Servico("Alinhamento", 1, new BigDecimal(200)));
            servicos3.add(new Servico("Lavagem completa", 1, new BigDecimal(80)));

            OrdemServico os3 = new OrdemServico(new Solicitante("Paulo", "51999999999", true), new Caminhao("Carreta", 20000, 30), servicos3);
            os3.setMecanico("Jairo");
            os3.setGarantia(false);

            OrdemServicoController.adicionaOS(os3, "Adicionada O.S. 3");
        } catch (PedidoInvalidoException | NomeNaoPreenchidoException | CapacidadeCargaInvalidaException e) {
            logger.info(e.getMessage());
        }


        try {
            List<Servico> servicos4 = null;

            OrdemServico os4 = new OrdemServico(
                new Solicitante("Paulo", "51999999999", true),
                new Caminhao("Carreta", 20000, 30),
                servicos4);
            os4.setMecanico("Jairo");
            os4.setGarantia(false);

            OrdemServicoController.adicionaOS(os4, "Adicionada O.S. 4");
        } catch (PedidoInvalidoException | NomeNaoPreenchidoException | CapacidadeCargaInvalidaException e) {
            logger.info(e.getMessage());
        }

        try {
            List<Servico> servicos4 = new ArrayList<>();

            OrdemServico os4 = new OrdemServico(
                new Solicitante("Paulo", "51999999999", true),
                new Caminhao("Carreta", 20000, 30),
                servicos4);
            os4.setMecanico("Jairo");
            os4.setGarantia(false);

            OrdemServicoController.adicionaOS(os4, "Adicionada O.S. 4");
        } catch (PedidoInvalidoException | NomeNaoPreenchidoException | CapacidadeCargaInvalidaException e) {
            logger.info(e.getMessage());
        }

    }
}
