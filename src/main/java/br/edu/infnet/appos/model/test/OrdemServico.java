package br.edu.infnet.appos.model.test;

import java.time.LocalDateTime;

public class OrdemServico {
    String descricao;
    LocalDateTime data;
    boolean garantia;

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + garantia;
    }
}
