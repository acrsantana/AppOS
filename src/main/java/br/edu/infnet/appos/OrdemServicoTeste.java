package br.edu.infnet.appos;

import br.edu.infnet.appos.controller.OrdemServicoController;
import br.edu.infnet.appos.exceptions.*;
import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.test.AppImpressao;
import br.edu.infnet.appos.model.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Order(5)
public class OrdemServicoTeste implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(OrdemServicoTeste.class);

    @Override
    public void run(ApplicationArguments args) {

        String diretorio = "d:\\";
        String nomeArquivo = "ordensServico.txt";

        try {
            FileReader fileReader = new FileReader(diretorio + nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            String[] campos = null;
            while (linha != null){
                campos = linha.split(";");
                System.out.println(Arrays.toString(campos));
                Solicitante solicitante = new Solicitante(campos[0], campos[1], Boolean.getBoolean(campos[2]));
                Carro carro = new Carro(campos[3], Boolean.getBoolean(campos[4]), Integer.parseInt(campos[5]));
                List<Servico> servicos = new ArrayList<>();
                servicos.add(new Servico(campos[8], Integer.parseInt(campos[9]), new BigDecimal(campos[10])));
                OrdemServico os = new OrdemServico(solicitante, carro, servicos);
                os.setMecanico(campos[6]);
                os.setGarantia(Boolean.getBoolean(campos[7]));
                OrdemServicoController.adicionaOS(os, "Adicionada OS do arquivo" + diretorio + nomeArquivo);
                linha = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            logger.error("Arquivo não encontrado: {}", e.getMessage());
        } catch (IOException e) {
            logger.error("Erro na leitura do arquivo: {}", e.getMessage());
        } catch (NomeNaoPreenchidoException | QuantidadePortasInvalidasException | PedidoInvalidoException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Processamento finalizado");
        }
    }
}
