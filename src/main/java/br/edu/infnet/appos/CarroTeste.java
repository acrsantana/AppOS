package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.CarroController;
import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.model.domain.Carro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CarroTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(CarroTeste.class);
    @Override
    public void run(ApplicationArguments args) {


        try {
            Carro c1 = new Carro("Coupe", true, 2);
            c1.setMarca("Tesla");
            c1.setModelo("Model S");
            c1.setAnoFabricacao(2021);
            System.out.println("Potencia do veículo: " + c1.getPotencia());
            CarroController.adicionaCarro(c1, "Carro 1 - Tesla");
        } catch (QuantidadePortasInvalidasException e) {
            logger.error(e.getMessage());
        }

        try {
            Carro c2 = new Carro("SUV", true, 4);
            c2.setMarca("Mercedez Benz");
            c2.setModelo("G63 AMG");
            c2.setAnoFabricacao(2022);
            System.out.println("Potencia do veículo: " + c2.getPotencia());
            CarroController.adicionaCarro(c2, "Carro 2 - Mercedes");
        } catch (QuantidadePortasInvalidasException e) {
            logger.error(e.getMessage());
        }

        try {
            Carro c3 = new Carro("Sedan", true, 4);
            c3.setMarca("Audi");
            c3.setModelo("A4");
            c3.setAnoFabricacao(2015);
            System.out.println("Potencia do veículo: " + c3.getPotencia());
            CarroController.adicionaCarro(c3, "Carro 3 - Audi");
        } catch (QuantidadePortasInvalidasException e) {
            logger.error(e.getMessage());
        }

        try {
            Carro c4 = new Carro("Sedan", true, 1);
            c4.setMarca("Audi");
            c4.setModelo("A4");
            c4.setAnoFabricacao(2015);
            System.out.println("Potencia do veículo: " + c4.getPotencia());
            CarroController.adicionaCarro(c4, "Carro 3 - Audi");
        } catch (QuantidadePortasInvalidasException e) {
            logger.error(e.getMessage());
        }

        try {
            Carro c5 = new Carro("Sedan", true, 5);
            c5.setMarca("Audi");
            c5.setModelo("A4");
            c5.setAnoFabricacao(2015);
            System.out.println("Potencia do veículo: " + c5.getPotencia());
            CarroController.adicionaCarro(c5, "Carro 3 - Audi");
        } catch (QuantidadePortasInvalidasException e) {
            logger.error(e.getMessage());
        }
    }
}
