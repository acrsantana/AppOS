package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data @AllArgsConstructor
public class Servico {
    private String nomeServico;
    private Integer tempoDeExecução;
    private BigDecimal valor;


    @Override
    public String toString() {
        return nomeServico + ";" + tempoDeExecução + ";" + valor;
    }
}
