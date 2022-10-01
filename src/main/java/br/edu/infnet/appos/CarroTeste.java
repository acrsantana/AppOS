package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.CarroController;
import br.edu.infnet.appos.exceptions.ProblemasNaLeituraDoArquivoException;
import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.service.CarroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Objects;

@Component
@Order(1)
public class CarroTeste implements ApplicationRunner {

    @Autowired
    private CarroService carroService;
    Logger logger = LoggerFactory.getLogger(CarroTeste.class);
    @Override
    public void run(ApplicationArguments args) {
        File file = new File("src/main/resources/files/carro.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            String[] campos;
            boolean ar;
            while (linha != null){
                campos = linha.split("\\|");
                try {

                    Carro carro = new Carro(campos[0], Boolean.parseBoolean(campos[1]), Integer.parseInt(campos[2]));
                    carro.setMarca(campos[3]);
                    carro.setModelo(campos[4]);
                    carro.setAnoFabricacao(Integer.parseInt(campos[5]));
                    System.out.println("Potencia do veículo: " + carro.getPotencia());
                    carroService.add(carro);
                } catch (QuantidadePortasInvalidasException e) {
                    logger.error(e.getMessage());
                }
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Carga do arquivo finalizada");
        }
    }
}
