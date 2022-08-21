package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico {
    private String descricao;
    private LocalDateTime data;
    private boolean garantia;
    private Solicitante solicitante;

    public OrdemServico(
            Solicitante solicitante
    ) {
        this.solicitante = solicitante;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + garantia + ";" + solicitante;
    }
}
