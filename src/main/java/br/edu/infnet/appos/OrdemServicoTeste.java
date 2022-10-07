package br.edu.infnet.appos;

import br.edu.infnet.appos.exceptions.CapacidadeCargaInvalidaException;
import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.exceptions.QuantidadePassageirosInvalidaException;
import br.edu.infnet.appos.exceptions.QuantidadePortasInvalidasException;
import br.edu.infnet.appos.model.domain.*;
import br.edu.infnet.appos.model.service.OrdemServicoService;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Order(10)
public class OrdemServicoTeste implements ApplicationRunner {

    @Autowired OrdemServicoService ordemServicoService;
    @Autowired ServicoService servicoService;
    Logger logger = LoggerFactory.getLogger(OrdemServicoTeste.class);

    @Override
    public void run(ApplicationArguments args) {

        File file = new File("src\\main\\resources\\files\\ordensServico.txt");

        try {
            boolean verificaServicos = false;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            List<OrdemServico> ordensServicos = new ArrayList<>();
            List<Servico> servicos = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Usuario usuario = new Usuario();
            usuario.setId(1);
            Solicitante solicitante;
            OrdemServico ordemServico = null;
            Veiculo veiculo;
            String[] campos;
            while (linha != null){
                campos = linha.split(";");

                switch (campos[0]) {
                    case "OS":
                        ordemServico = new OrdemServico();
                        ordemServico.setGarantia(Boolean.parseBoolean(campos[3]));
                        ordemServico.setMecanico(campos[1]);
                        ordemServico.setData(LocalDateTime.parse(campos[2], formatter));
                        ordemServico.setUsuario(usuario);
                        ordensServicos.add(ordemServico);
                        break;
                    case "SO":
                        solicitante = new Solicitante(campos[1], campos[2], Boolean.parseBoolean(campos[3]));
                        solicitante.setUsuario(usuario);
                        if (!Objects.isNull(ordemServico))
                            ordemServico.setSolicitante(solicitante);
                        break;
                    case "CA":
                        veiculo = new Carro(campos[4], Boolean.parseBoolean(campos[5]), Integer.parseInt(campos[6]));
                        veiculo.setMarca(campos[1]);
                        veiculo.setModelo(campos[2]);
                        veiculo.setAnoFabricacao(Integer.parseInt(campos[3]));
                        veiculo.setUsuario(usuario);
                        if (!Objects.isNull(ordemServico))
                            ordemServico.setVeiculo(veiculo);
                        break;
                    case "MO":
                        veiculo = new Moto(Integer.parseInt(campos[4]), campos[5], Integer.parseInt(campos[6]));
                        veiculo.setMarca(campos[1]);
                        veiculo.setModelo(campos[2]);
                        veiculo.setAnoFabricacao(Integer.parseInt(campos[3]));
                        veiculo.setUsuario(usuario);
                        if (!Objects.isNull(ordemServico))
                            ordemServico.setVeiculo(veiculo);
                        break;
                    case "CM":
                        veiculo = new Caminhao(campos[4], Float.parseFloat(campos[5]), Float.parseFloat(campos[6]));
                        veiculo.setMarca(campos[1]);
                        veiculo.setModelo(campos[2]);
                        veiculo.setAnoFabricacao(Integer.parseInt(campos[3]));
                        veiculo.setUsuario(usuario);
                        if (!Objects.isNull(ordemServico))
                            ordemServico.setVeiculo(veiculo);
                        break;
                    case "SE":
                        Servico servico = new Servico(campos[1], Integer.parseInt(campos[2]), new BigDecimal(campos[3]));
                        servico.setUsuario(usuario);
                        servicos.add(servico);
                        if (!Objects.isNull(ordemServico))
                            ordemServico.setServicos(servicos);
                        verificaServicos = true;
                        break;
                }

                linha = bufferedReader.readLine();
                if (verificaServicos && !Objects.isNull(linha)){
                    if (!linha.startsWith("SE")){
                        servicos = new ArrayList<>();
                        verificaServicos = false;
                    }
                }
            }
            ordensServicos.forEach(os -> ordemServicoService.addOrdemServico(os));
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            logger.error("Arquivo não encontrado: {}", e.getMessage());
        } catch (IOException e) {
            logger.error("Erro na leitura do arquivo: {}", e.getMessage());
        } catch (NomeNaoPreenchidoException | QuantidadePortasInvalidasException | QuantidadePassageirosInvalidaException |
                 CapacidadeCargaInvalidaException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Carga do arquivo {} finalizada com sucesso", file.getName());
        }
    }
}
