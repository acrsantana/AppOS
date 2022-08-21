package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico {
    private String descricao;
    private LocalDateTime data;
    private boolean garantia;
    private Solicitante solicitante;

    public OrdemServico(
            String nome,
            String telefone,
            boolean vip
    ) {
        this.solicitante = new Solicitante(nome, telefone, vip);
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + garantia + ";" + solicitante;
    }
}
