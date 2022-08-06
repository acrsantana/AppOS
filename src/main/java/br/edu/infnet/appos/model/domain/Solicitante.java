package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class Solicitante {
    private String nome;
    private String telefone;
    private boolean vip;

    @Override
    public String toString() {
        return nome + ";" + telefone + ";" + vip;
    }
}
