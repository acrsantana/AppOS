package br.edu.infnet.appos.model.domain;

import java.time.LocalDateTime;

public class OrdemServico {
    public String descricao;
    public LocalDateTime data;
    public boolean garantia;

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + garantia;
    }
}
