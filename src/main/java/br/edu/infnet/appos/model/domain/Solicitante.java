package br.edu.infnet.appos.model.domain;

import br.edu.infnet.appos.exceptions.NomeNaoPreenchidoException;
import br.edu.infnet.appos.interfaces.IPrinter;
import br.edu.infnet.appos.model.dto.SolicitanteDto;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "solicitantes")
public class Solicitante implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private boolean vip;

    @OneToOne
    private Usuario usuario;
    @ManyToOne
    private Veiculo veiculo;

    public Solicitante(SolicitanteDto solicitanteDto){
        BeanUtils.copyProperties(solicitanteDto, this);
        this.vip = Boolean.parseBoolean(solicitanteDto.getVip());
    }

    public Solicitante(String nome, String telefone, boolean vip) throws NomeNaoPreenchidoException {
        if (Objects.isNull(nome))
            throw new NomeNaoPreenchidoException("O nome do solicitante não pode ser nulo");

        if (nome == "")
            throw new NomeNaoPreenchidoException("O nome do solicitante não pode ser em branco");

        this.nome = nome;
        this.telefone = telefone;
        this.vip = vip;
    }

    @Override public void impressao() {
        System.out.println("### Solicitante ###");
        System.out.println(toString());
    }

    @Override
    public String toString() {

        return "Solicitante: [" + nome + ";" + telefone + ";" + vip + "]";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Solicitante that = (Solicitante) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override public int hashCode() {
        return getClass().hashCode();
    }
}
