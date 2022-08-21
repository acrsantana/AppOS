package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico {
    private String mecanico;
    private LocalDateTime data;
    private boolean garantia;
    private Solicitante solicitante;
    private Veiculo veiculo;
    private List<Servico> servicos;

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
        return mecanico + ";" + data + ";" + garantia + ";" + solicitante + ";" + servicos.size();
    }
}
