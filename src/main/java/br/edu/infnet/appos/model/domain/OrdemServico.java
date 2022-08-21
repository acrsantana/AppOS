package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico implements IPrinter{
    private String mecanico;
    private LocalDateTime data;
    private boolean garantia;
    private Solicitante solicitante;
    private Veiculo veiculo;
    private Set<Servico> servicos;

    public OrdemServico(
            Solicitante solicitante,
            Veiculo veiculo,
            Set<Servico> servicos
    ) {
        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.servicos = servicos;
        this.data = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return mecanico + ";" + data + ";" + garantia + ";" + solicitante + ";" + servicos.size();

        return "Ordem de Serviço: [" + descricao + ";" + data + ";" + garantia + "]";
    }

    @Override public void impressao() {
        System.out.println("### Ordem de Serviço ###");
        System.out.println(toString());
    }
}
