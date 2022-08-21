package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data @AllArgsConstructor
public class Servico implements IPrinter {
    private String nomeServico;
    private Integer tempoDeExecução;
    private BigDecimal valor;


    @Override
    public String toString() {
        return nomeServico + ";" + tempoDeExecução + ";" + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(nomeServico, servico.nomeServico) && Objects.equals(tempoDeExecução, servico.tempoDeExecução);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeServico, tempoDeExecução);
    }

    @Override
    public void impressao() {
        System.out.println("### Serviço ###");
        System.out.println(toString());
    }
}
