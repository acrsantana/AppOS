package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.PedidoInvalidoException;
import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor @Data
//@Entity @Table(name = "ordens_de_servico")
public class OrdemServico implements IPrinter{

    private LocalDateTime data;
    private boolean garantia;
    private String mecanico;
    private Solicitante solicitante;
    private Veiculo veiculo;
    private List<Servico> servicos;
    private Integer id = 0;

    public OrdemServico(
            Solicitante solicitante,
            Veiculo veiculo,
            List<Servico> servicos
    ) throws PedidoInvalidoException {

        if (Objects.isNull(servicos))
            throw new PedidoInvalidoException("É necessário informar a lista de serviços");

        if (servicos.isEmpty())
            throw new PedidoInvalidoException("A lista de serviços não pode ser vazia");

        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.servicos = servicos;
        this.data = LocalDateTime.now();
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
