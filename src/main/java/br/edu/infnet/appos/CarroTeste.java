package br.edu.infnet.appos;

import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.CarroService;
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
public class CarroTeste implements ApplicationRunner {

    @Autowired
    private CarroService carroService;
    Logger logger = LoggerFactory.getLogger(CarroTeste.class);
    @Override
    public void run(ApplicationArguments args) {
        String pathname;
        if (System.getProperty("os.name").equals("Windows 11")){
            pathname = "src\\main\\resources\\files\\veiculos.txt";
        } else {
            pathname = "src/main/resources/files/veiculos.txt";
        }
        File file = new File(pathname);
        Usuario usuario = new Usuario();
        usuario.setId(1);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            String[] campos;
            boolean ar;
            while (linha != null){
                campos = linha.split("\\|");
                if ("CA".equalsIgnoreCase(campos[0])){
                    try {

                        Carro carro = new Carro(campos[1], Boolean.parseBoolean(campos[2]), Integer.parseInt(campos[3]));
                        carro.setMarca(campos[4]);
                        carro.setModelo(campos[5]);
                        carro.setAnoFabricacao(Integer.parseInt(campos[6]));
                        carro.setUsuario(usuario);
                        carroService.add(carro);
                    } catch (QuantidadePortasInvalidasException e) {
                        logger.error(e.getMessage());
                    }
                }
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Carga do arquivo {} finalizada com sucesso", file.getName());
        }
    }
}
