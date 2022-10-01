package br.edu.infnet.appos.model.dto;

import br.edu.infnet.appos.interfaces.IPrinter;
import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.domain.Solicitante;
import br.edu.infnet.appos.model.domain.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor @Data
public class OrdemServicoDto implements IPrinter{
    private Integer id;
    private String mecanico;
    private String data;
    private boolean garantia;
    private Solicitante solicitante;
    private Veiculo veiculo;
    private List<Servico> servicos;


    public OrdemServicoDto( OrdemServico os) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        BeanUtils.copyProperties(os, this);
        this.data = formatter.format(os.getData());
    }

    @Override
    public String toString() {

        return "Ordem de Serviço: [" + mecanico + ";" + data + ";" + garantia + ";" + solicitante + ";" + servicos.size() + "]";
    }

    @Override public void impressao() {
        System.out.println("### Ordem de Serviço ###");
        System.out.println(toString());
    }
}
