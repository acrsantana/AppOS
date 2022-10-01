package br.edu.infnet.appos;

import br.edu.infnet.appos.exceptions.CapacidadeCargaInvalidaException;
import br.edu.infnet.appos.model.domain.Caminhao;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.CaminhaoService;
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
@Order(3)
public class CaminhaoTeste implements ApplicationRunner {

    @Autowired
    CaminhaoService caminhaoService;
    Logger logger = LoggerFactory.getLogger(CaminhaoTeste.class);
    @Override
    public void run(ApplicationArguments args) {

        String pathname;
        if (System.getProperty("os.name").equals("Windows 11")){
            pathname = "src\\main\\resources\\files\\caminhao.txt";
        } else {
            pathname = "src/main/resources/files/caminhao.txt";
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

                    Caminhao caminhao = new Caminhao(campos[0], Float.parseFloat(campos[1]), Float.parseFloat(campos[2]));
                    caminhao.setMarca(campos[3]);
                    caminhao.setModelo(campos[4]);
                    caminhao.setAnoFabricacao(Integer.parseInt(campos[5]));
                    caminhao.setUsuario(usuario);
                    caminhaoService.add(caminhao);
                } catch (CapacidadeCargaInvalidaException e) {
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
