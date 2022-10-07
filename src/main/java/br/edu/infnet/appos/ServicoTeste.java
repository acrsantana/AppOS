package br.edu.infnet.appos;

import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.domain.Usuario;
import br.edu.infnet.appos.model.service.ServicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;

@Component
@Order(6)
public class ServicoTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(ServicoTeste.class);

    @Autowired
    ServicoService servicoService;

    @Override
    public void run(ApplicationArguments args) {

        File file = new File("src\\main\\resources\\files\\servicos.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            String[] campos;
            Servico servico;
            Usuario usuario = new Usuario();
            usuario.setId(1);
            while (linha != null){
                campos = linha.split("\\|");
                servico = new Servico(campos[0], Integer.parseInt(campos[1]), new BigDecimal(campos[2]));
                servico.setUsuario(usuario);
                servicoService.add(servico);
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            logger.error("Arquivo não encontrado: {}", e.getMessage());
        } catch (IOException e) {
            logger.error("Erro na leitura do arquivo: {}", e.getMessage());
        } finally {
            logger.info("Carga do arquivo {} finalizada com sucesso", file.getName());
        }
    }
}
