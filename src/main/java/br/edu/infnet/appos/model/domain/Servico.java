package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@RequiredArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "servicos")
public class Servico implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String nomeServico;
    @NonNull
    private Integer tempoDeExecucao;
    @NonNull
    private BigDecimal valor;


    @Override
    public String toString() {
        return nomeServico + ";" + tempoDeExecucao + ";" + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(nomeServico, servico.nomeServico) && Objects.equals(tempoDeExecucao, servico.tempoDeExecucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeServico, tempoDeExecucao);
    }

    @Override
    public void impressao() {
        System.out.println("### Serviço ###");
        System.out.println(toString());
    }
}
