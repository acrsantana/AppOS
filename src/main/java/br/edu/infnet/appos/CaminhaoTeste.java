package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.CaminhaoController;
import br.edu.infnet.appos.exceptions.CapacidadeCargaInvalidaException;
import br.edu.infnet.appos.exceptions.ComprimentoInvalidoException;
import br.edu.infnet.appos.model.domain.Caminhao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CaminhaoTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(CaminhaoTeste.class);
    @Override
    public void run(ApplicationArguments args) {
        try {
            Caminhao c1 = new Caminhao("Baú", 1000.0f, 7.0f);
            c1.setMarca("Mercedez Benz");
            c1.setModelo("Refrigerado");
            c1.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + c1.getPotencia());
            System.out.println("Preço :" + c1.getValor());
            CaminhaoController.adicionaCaminhao(c1, "Caminhão 1");
        } catch (CapacidadeCargaInvalidaException | ComprimentoInvalidoException e){
            logger.error(e.getMessage());
        }

        try {
            Caminhao c2 = new Caminhao("Carreta", 2000.0f, 10.0f);
            c2.setMarca("Hyundai");
            c2.setModelo("Aberto");
            c2.setAnoFabricacao(2022);
            System.out.println("Potencia do veículo: " + c2.getPotencia());
            System.out.println("Preço :" + c2.getValor());
            CaminhaoController.adicionaCaminhao(c2, "Caminhão 2");
        } catch (CapacidadeCargaInvalidaException | ComprimentoInvalidoException e){
            logger.error(e.getMessage());
        }

        try {
            Caminhao c3 = new Caminhao("Bitrem", 4000.0f, 12.0f);
            c3.setMarca("Volkswagen");
            c3.setModelo("Super");
            c3.setAnoFabricacao(2010);
            System.out.println("Potencia do veículo: " + c3.getPotencia());
            System.out.println("Preço :" + c3.getValor());
            CaminhaoController.adicionaCaminhao(c3, "Caminhão 3");
        } catch (CapacidadeCargaInvalidaException | ComprimentoInvalidoException e){
            logger.error(e.getMessage());
        }

        try {
            Caminhao c4 = new Caminhao("Bitrem", 40f, 12.0f);
            c4.setMarca("Volkswagen");
            c4.setModelo("Super");
            c4.setAnoFabricacao(2010);
            System.out.println("Potencia do veículo: " + c4.getPotencia());
            System.out.println("Preço :" + c4.getValor());
            CaminhaoController.adicionaCaminhao(c4, "Caminhão 3");
        } catch (CapacidadeCargaInvalidaException | ComprimentoInvalidoException e){
            logger.error(e.getMessage());
        }

        try {
            Caminhao c5 = new Caminhao("Bitrem", 600f, 4f);
            c5.setMarca("Volkswagen");
            c5.setModelo("Super");
            c5.setAnoFabricacao(2010);
            System.out.println("Potencia do veículo: " + c5.getPotencia());
            System.out.println("Preço :" + c5.getValor());
            CaminhaoController.adicionaCaminhao(c5, "Caminhão 3");
        } catch (CapacidadeCargaInvalidaException | ComprimentoInvalidoException e){
            logger.error(e.getMessage());
        }

    }
}
