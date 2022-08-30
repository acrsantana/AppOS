package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.MotoController;
import br.edu.infnet.appos.exceptions.QuantidadePassageirosInvalidaException;
import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MotoTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(MotoTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        try {
            Moto m1 = new Moto(125, "Scooter", 2);
            m1.setMarca("Honda");
            m1.setModelo("PCX");
            m1.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + m1.getPotencia());
            MotoController.adicionaMoto(m1, "Moto 1 - " + m1.getMarca());
        } catch (QuantidadePassageirosInvalidaException e) {
            logger.error(e.getMessage());
        }


        try {
            Moto m2 = new Moto(600, "Cafe Racer", 2);
            m2.setMarca("Kawasaki");
            m2.setModelo("Ninja");
            m2.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + m2.getPotencia());
            MotoController.adicionaMoto(m2, "Moto 2 - " + m2.getMarca());
        } catch (QuantidadePassageirosInvalidaException e) {
            logger.error(e.getMessage());
        }


        try {
            Moto m3 = new Moto(1000, "Super Esportiva", 2);
            m3.setMarca("Honda");
            m3.setModelo("CBR");
            m3.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + m3.getPotencia());
            MotoController.adicionaMoto(m3, "Moto 3 - " + m3.getMarca());
        } catch (QuantidadePassageirosInvalidaException e) {
            logger.error(e.getMessage());
        }

        try {
            Moto m4 = new Moto(1000, "Super Esportiva", 3);
            m4.setMarca("Honda");
            m4.setModelo("CBR");
            m4.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + m4.getPotencia());
            MotoController.adicionaMoto(m4, "Moto 4 - " + m4.getMarca());
        } catch (QuantidadePassageirosInvalidaException e) {
            logger.error(e.getMessage());
        }

        try {
            Moto m5 = new Moto(1000, "Super Esportiva", 0);
            m5.setMarca("Honda");
            m5.setModelo("CBR");
            m5.setAnoFabricacao(2020);
            System.out.println("Potencia do veículo: " + m5.getPotencia());
            MotoController.adicionaMoto(m5, "Moto 5 - " + m5.getMarca());
        } catch (QuantidadePassageirosInvalidaException e) {
            logger.error(e.getMessage());
        }

    }
}
