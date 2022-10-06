package br.edu.infnet.appos.model.dto;

import br.edu.infnet.appos.interfaces.IPrinter;
import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data
public class OrdemServicoDto{
    private String mecanico;
    private boolean garantia;
    private Integer solicitante;
    private Integer veiculo;
    private List<Integer> servicos;


    public OrdemServicoDto( OrdemServico os) {
        BeanUtils.copyProperties(os, this);
    }
}
