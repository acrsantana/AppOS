package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.PedidoInvalidoException;
import br.edu.infnet.appos.interfaces.IPrinter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor @Getter @Setter
@Entity @Table(name = "ordens_de_servico")
public class OrdemServico implements IPrinter{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mecanico;
    private LocalDateTime data;
    private boolean garantia;
    @ManyToOne(cascade = CascadeType.ALL)
    private Solicitante solicitante;
    @ManyToOne (cascade = CascadeType.ALL)
    private Veiculo veiculo;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Servico> servicos;


    public OrdemServico(
            Solicitante solicitante,
            Veiculo veiculo,
            List<Servico> servicos
    ) throws PedidoInvalidoException {

        if (Objects.isNull(servicos))
            throw new PedidoInvalidoException("É necessário informar a lista de serviços");

        if (servicos.isEmpty())
            throw new PedidoInvalidoException("A lista de serviços não pode ser vazia");

        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.servicos = servicos;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "Ordem de Serviço: [" + mecanico + ";" + data + ";" + garantia + ";" + solicitante + ";" + servicos.size() + "]";
    }

    @Override public void impressao() {
        System.out.println("### Ordem de Serviço ###");
        System.out.println(this);
    }
}
