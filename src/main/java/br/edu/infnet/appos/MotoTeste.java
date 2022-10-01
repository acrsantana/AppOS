package br.edu.infnet.appos;

import br.edu.infnet.appos.exceptions.QuantidadePassageirosInvalidaException;
import br.edu.infnet.appos.model.domain.Moto;
import br.edu.infnet.appos.model.service.MotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(2)
public class MotoTeste implements ApplicationRunner {

    @Autowired
    private MotoService motoService;
    Logger logger = LoggerFactory.getLogger(MotoTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        File file = new File("src/main/resources/files/moto.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            String[] campos;
            while (linha != null){
                campos = linha.split("\\|");
                try {

                    Moto moto = new Moto(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2]));
                    moto.setMarca(campos[3]);
                    moto.setModelo(campos[4]);
                    moto.setAnoFabricacao(Integer.parseInt(campos[5]));
                    System.out.println("Potencia do veículo: " + moto.getPotencia());
                    motoService.add(moto);
                } catch (QuantidadePassageirosInvalidaException e) {
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
