package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data @AllArgsConstructor @NoArgsConstructor
public class OrdemServico implements IPrinter {
    private String descricao;
    private LocalDateTime data;
    private boolean garantia;


    @Override
    public String toString() {

        return "Ordem de Serviço: [" + descricao + ";" + data + ";" + garantia + "]";
    }

    @Override public void impressao() {
        System.out.println("### Ordem de Serviço ###");
        System.out.println(toString());
    }
}
