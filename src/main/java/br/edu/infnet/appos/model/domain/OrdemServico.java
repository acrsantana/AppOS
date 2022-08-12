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

    public void impressao(){
        System.out.println("### Ordem de Serviço ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Ordem de Serviço: [" + descricao + ";" + data + ";" + garantia + "]";
    }
}
