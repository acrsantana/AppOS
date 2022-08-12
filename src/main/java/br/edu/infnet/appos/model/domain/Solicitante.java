package br.edu.infnet.appos.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class Solicitante {
    private String nome;
    private String telefone;
    private boolean vip;

    public void impressao(){
        System.out.println("### Solicitante ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Solicitante: [" + nome + ";" + telefone + ";" + vip + "]";
    }
}
