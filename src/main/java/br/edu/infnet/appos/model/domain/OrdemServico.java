package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico implements IPrinter{
    private String mecanico;
    private LocalDateTime data;
    private boolean garantia;
    private Solicitante solicitante;
    private Veiculo veiculo;
    private List<Servico> servicos;
    private Integer id = 0;

    public OrdemServico(
            Solicitante solicitante,
            Veiculo veiculo,
            List<Servico> servicos
    ) {
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
