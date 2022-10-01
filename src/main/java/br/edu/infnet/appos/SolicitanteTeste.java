package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.SolicitanteController;
import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.model.domain.Carro;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.SolicitanteService;
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
@Order(4)
public class SolicitanteTeste implements ApplicationRunner {

    @Autowired
    SolicitanteService solicitanteService;
    Logger logger = LoggerFactory.getLogger(SolicitanteTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        String pathname;
        if (System.getProperty("os.name").equals("Windows 11")){
            pathname = "src\\main\\resources\\files\\solicitante.txt";
        } else {
            pathname = "src/main/resources/files/solicitante.txt";
        }
        File file = new File(pathname);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            String[] campos;
            Usuario usuario = new Usuario();
            usuario.setId(1);
            while (linha != null){
                campos = linha.split("\\|");
                try {
                    Solicitante solicitante = new Solicitante(campos[0], campos[1], Boolean.parseBoolean(campos[2]));
                    solicitante.setUsuario(usuario);
                    solicitanteService.add(solicitante);
                } catch (NomeNaoPreenchidoException e) {
                    throw new RuntimeException(e);
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
